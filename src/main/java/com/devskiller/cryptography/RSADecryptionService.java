package com.devskiller.cryptography;


import com.devskiller.cryptography.exception.InvalidDataLengthException;
import com.devskiller.cryptography.exception.InvalidDataToDecryptException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSADecryptionService {

    private static final String PUBLIC_KEY_PATH = "src/main/resources/publicKey";
    private static final String PRIVATE_KEY_PATH = "src/main/resources/privateKey";

    public byte[] decrypt(byte[] data) {
        if (data == null || data.length == 0) {
            throw new InvalidDataLengthException();
        }

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] privateKeyBytes = CryptoUtils.readFile(PRIVATE_KEY_PATH);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException |
                 InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new InvalidDataToDecryptException("Error decrypting data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String dataAsBase64) throws InvalidDataToDecryptException  {
        byte[] decodedData = Base64.getDecoder().decode(dataAsBase64);
        byte[] decryptedBytes = decrypt(decodedData);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public byte[] sign(byte[] data) throws Exception {
        if (data == null || data.length == 0) {
            throw new InvalidDataToDecryptException("Data is null or empty");
        }

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] privateKeyBytes = CryptoUtils.readFile(PRIVATE_KEY_PATH);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data);

            return signature.sign();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException |
                 SignatureException e) {
            throw new Exception("Error signing data", e);
        }
    }

}
