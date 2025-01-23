#!/bin/bash

# Directory where secrets are stored
SECRETS_DIR="/secrets"

# Create the secrets directory if it doesn't exist
mkdir -p "$SECRETS_DIR"

# Define the secrets to generate and their lengths
declare -A SECRETS
SECRETS["mongo_root_password.txt"]="32"
SECRETS["vault_token.txt"]="64"

# Iterate over each secret
for SECRET in "${!SECRETS[@]}"; do
  FILE_PATH="$SECRETS_DIR/$SECRET"

  # Check if the file exists
  if [ -f "$FILE_PATH" ]; then
    # Check if the file contains the word "default"
    if grep -q "default" "$FILE_PATH"; then
      echo "Default value found in $SECRET. Generating a new value..."
      openssl rand -base64 "${SECRETS[$SECRET]}" > "$FILE_PATH"
      chmod 600 "$FILE_PATH"
    else
      echo "$SECRET already has a custom value. Skipping generation."
    fi
  else
    # Generate a new secret if the file doesn't exist
    echo "File $SECRET does not exist. Generating a new value..."
    openssl rand -base64 "${SECRETS[$SECRET]}" > "$FILE_PATH"
    chmod 600 "$FILE_PATH"
  fi
done

echo "Secrets checked and updated if necessary."
exit 0
