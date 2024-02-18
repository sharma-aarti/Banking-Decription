package com.devskiller.cryptography;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class CryptoUtils {
    public static byte[] readFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readAllBytes(path);
    }
}
