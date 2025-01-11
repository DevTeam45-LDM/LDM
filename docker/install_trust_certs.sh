#!/bin/bash

# Path to the configuration directory
CONFIG_DIR="/config"
CERTS_FILE="${CONFIG_DIR}/trust-certs.txt"
CERTS_DIR="/usr/share/ca-certificates/local"
CA_CERTIFICATES_CONF="/etc/ca-certificates.conf"

# Check if the trust-certs.txt file exists
if [ ! -f "$CERTS_FILE" ]; then
  echo "File $CERTS_FILE not found. No certificates to install."
  exit 0
fi

# Create the certificates directory if it doesn't exist
mkdir -p "$CERTS_DIR"

# Read the trust-certs.txt file line by line
while IFS= read -r line || [ -n "$line" ]; do
  # Trim whitespace and remove everything after '#' (comments)
  #echo $line
  ENTRY=$(echo "$line" | sed -E 's/[[:space:]]*#.*//' | tr -d '\r' | xargs)
  #echo $ENTRY
  #echo "-----------------"
  # Skip empty lines or lines that only contained comments
  if [ -z "$ENTRY" ]; then
    continue
  fi

  # Check if the entry is a crt.sh ID or a local file
  if [[ "$ENTRY" =~ ^[0-9]+$ ]]; then
    # Handle crt.sh ID
    CERT_ID="$ENTRY"
    CERT_FILE="${CERTS_DIR}/crtsh_${CERT_ID}.crt"

    if [ ! -f "$CERT_FILE" ]; then
      echo "Downloading certificate for ID: $CERT_ID"
      curl -fsSL "https://crt.sh/?d=${CERT_ID}" -o "$CERT_FILE"

      # Check if the download was successful
      if [ $? -eq 0 ]; then
        echo "local/crtsh_${CERT_ID}.crt" >> "$CA_CERTIFICATES_CONF"
        echo "Certificate for ID: $CERT_ID installed successfully."
      else
        echo "Failed to download certificate for ID: $CERT_ID. Skipping."
        rm -f "$CERT_FILE"
      fi
    else
      echo "Certificate for ID: $CERT_ID already installed. Skipping."
    fi
  elif [[ "$ENTRY" =~ ^/ ]]; then
    # Handle local file path
    LOCAL_FILE="${CONFIG_DIR}${ENTRY}"
    CERT_FILE="${CERTS_DIR}/$(basename "$ENTRY")"

    if [ ! -f "$CERT_FILE" ]; then
      if [ -f "$LOCAL_FILE" ]; then
        echo "Installing local certificate: $LOCAL_FILE"
        cp "$LOCAL_FILE" "$CERT_FILE"
        echo "local${ENTRY}" >> "$CA_CERTIFICATES_CONF"

        # Check if the copy was successful
        if [ $? -eq 0 ]; then
          echo "Local certificate $(basename "$ENTRY") installed successfully."
        else
          echo "Failed to install local certificate $(basename "$ENTRY")."
        fi
      else
        echo "Local certificate file not found: $LOCAL_FILE. Skipping."
      fi
    else
      echo "Local certificate $(basename "$ENTRY") already installed. Skipping."
    fi
  else
    echo "Invalid entry: $ENTRY. Skipping."
  fi
done < "$CERTS_FILE"

# Update the certificate database
echo "Updating certificate database..."

dpkg-reconfigure ca-certificates -f noninteractive
update-ca-certificates

echo "All certificates processed."
