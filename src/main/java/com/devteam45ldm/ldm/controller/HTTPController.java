package com.devteam45ldm.ldm.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.stream.Collectors;

@RestController
public class HTTPController {

    private final OkHttpClient client = getUnsafeOkHttpClient();

    @GetMapping("/http/url")
    public ResponseEntity<String> checkURL(@RequestParam String url) throws IOException {
        String httpUrl = url.startsWith("http://") ? url : "http://" + url;
        String httpsUrl = url.startsWith("https://") ? url : "https://" + url;

        if (url.startsWith("http://") || url.startsWith("https://")) {
            return checkUrlHeaders(url);
        } else {
            ResponseEntity<String> httpsResponse = checkUrlHeaders(httpsUrl);
            if (httpsResponse.getStatusCode().is2xxSuccessful() || httpsResponse.getStatusCode().is3xxRedirection()) {
                return httpsResponse;
            } else {
                return checkUrlHeaders(httpUrl);
            }
        }
    }

    private ResponseEntity<String> checkUrlHeaders(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .head()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                .header("Accept-Language", "en-US,en;q=0.5")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String headers = response.headers().toMultimap().entrySet().stream()
                    .map(entry -> entry.getKey() + ": " + String.join(", ", entry.getValue()))
                    .collect(Collectors.joining("\n"));

            return ResponseEntity.status(response.code())
                    .body("Headers for " + url + ":\n" + headers);
        } catch (SSLHandshakeException e) {
            return ResponseEntity.status(495).body("An error occurred while checking " + url + ": Untrusted certificate");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("An error occurred while checking " + url + ": " + e.getMessage());
        } finally {
            if (response != null && response.body() != null) {
                response.body().close();
            }
        }
    }

    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };

            // trust all certificates
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setHostnameVerifier((hostname, session) -> true);

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
