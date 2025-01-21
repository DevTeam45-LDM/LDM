package com.devteam45ldm.ldm.controller;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.riversun.okhttp3.OkHttp3CookieHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.stream.Collectors;

@RestController
public class HTTPController {

    private final OkHttpClient client = getUnsafeOkHttpClient();

    @GetMapping("/http/url")
    public ResponseEntity<String> checkURL(@RequestParam String url) throws IOException {
        String httpsUrl = url.startsWith("https://") ? url : "https://" + url;
        String httpUrl = url.startsWith("http://") ? url : "http://" + url;

        if (url.startsWith("http://") || url.startsWith("https://")) {
            return checkUrlHeaders(url);
        } else {
            ResponseEntity<String> httpsResponse = checkUrlHeaders(httpsUrl);
            if (httpsResponse.getStatusCode().is2xxSuccessful() || httpsResponse.getStatusCode().is3xxRedirection() || httpsResponse.getStatusCode().value() == 401) {
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
            return ResponseEntity.status(525).body("An error occurred while checking " + url + ": SSL Handshake Exception: " + e.getMessage());
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
            // Trust all certificates
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {
                            // No implementation required
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {
                            // No implementation required
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            // Install the all-trusting trust manager
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            // Create an all-trusting SSL Socket Factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Build the OkHttpClient with custom SSL settings
            OkHttp3CookieHelper cookieHelper = new OkHttp3CookieHelper();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true)
                    .followRedirects(true) // Standardmäßig aktiviert, kann explizit gesetzt werden
                    .followSslRedirects(true) // Für SSL-Umleitungen
                    .cookieJar(cookieHelper.cookieJar())
                    .addInterceptor(logging)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an unsafe OkHttpClient", e);
        }
    }
}
