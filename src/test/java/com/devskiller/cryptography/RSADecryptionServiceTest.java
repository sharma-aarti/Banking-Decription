package com.devskiller.cryptography;

import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class RSADecryptionServiceTest {

    private final RSADecryptionService rsaDecryptionService = new RSADecryptionService();

    @Test
    public void decryptsBytes() {
        byte[] encryptedBytes = new byte[]{-110, 96, 114, -37, 24, 55, 73, 90, 90, 16, -57, 72, 50, 91, 117, -75, 30, -66, 11, 110, 52, 111, -122, 123, -82, -57, 34, 78, -34, 14, -104, 89, 73, 84, -14, 29, 61, -96, 28, 26, 80, 12, 80, -66, 78, -39, 47, -13, 41, -64, -42, 78, 97, -32, -89, -109, -48, -74, -44, 109, 33, 85, -33, -97, 4, 72, 69, 59, -20, -92, -44, -108, -94, -19, 40, 82, 125, -109, -118, -45, 40, -126, 62, -28, 14, -116, -67, -29, -9, -114, -88, -78, 82, -128, 94, 70, 108, -128, 36, 52, 85, 104, -120, 0, -20, 25, -87, 74, -112, 57, -6, 6, 63, -111, -55, -48, -51, -3, 84, -118, 116, -46, 83, 47, -15, 57, -125, 66, 19, -25, -124, -2, 111, 78, 108, -68, 12, 31, -103, -100, -51, -64, 51, -26, -45, -71, -63, -57, -1, -65, -12, -77, 66, -24, 16, 120, -115, -109, 48, 73, -18, -30, 58, -54, 99, -2, 67, 124, -9, 46, -74, -123, 6, -74, 104, 69, 37, -108, 66, -1, -53, -24, 68, 76, 59, 40, 55, -96, -111, -97, 89, -69, -50, 25, -21, -26, -29, 87, -85, -116, 44, 68, 86, -128, -67, 97, -111, -127, 11, -52, -37, 103, 125, 88, -78, -55, -103, 17, -86, 65, -109, -12, 44, -103, 6, 37, -93, 29, 74, -87, -18, -83, -51, -71, 115, -33, 27, -1, -58, -92, 99, 125, -27, -92, 52, 55, -60, 41, 24, 53, -89, -127, 7, 86, 4, 20};

        byte[] result = rsaDecryptionService.decrypt(encryptedBytes);

        assertThat(result).isEqualTo("message".getBytes(UTF_8));
    }

    @Test
    public void decryptsText() {
        String message = "QcopWkcFLsbC22ox5acH0eXTKyZJ1EyXktPHf+Pz/pz8QhDVkczfGHBaZdKtt+6q8pysBdocvFD8EPT334W4+XjyA7lDeQQ5EVPTeFH3GNOOGBMG3p0oWFAfS2Q9fu41nIS5bju3KroMmV2iuX6gaMFH3w60xCcP65+Mg6rBNY7xpb5eQ+HPMWctukwFd0iT71sC3if2eaZqz0IPhJAPWE5jZ+8GN2LdNJKfMKcptoCQlbiWcRQSv6saz9x7bYXhSvKQhGlDIUUqxV0U7oLgSmjfN1ISrwapDc5NkIV4V1+Fi4Q5fW01wzjA5hyfn+v0IvcB4TWbx6Ywaxfe5ix+mg==";

        String result = rsaDecryptionService.decrypt(message);

        assertThat(result).isEqualTo("message");
    }

    @Test
    public void signsBytes() throws Exception {
        byte[] expectedSignature = new byte[] { 119, 125, -26, 75, -25, -27, -76, -2, 69, -86, 121, -78, 104, -2, 109, 27, -9, -52, -103, -62, -81, 74, 65, -127, 33, 105, -52, 48, -34, -36, 15, -107, 12, -118, -61, 45, 67, -46, -23, -78, 65, 25, 120, -112, 15, -54, -34, -100, 69, -45, 92, 49, -36, -32, 27, 116, -127, 99, 46, -80, -11, 105, -69, 87, 28, 74, -25, -121, 108, 77, 84, -21, 45, 117, -44, 20, 106, -84, 103, 24, -114, 65, 29, 105, 72, -34, 67, -71, 0, -94, 127, 72, 16, -104, 3, 78, 97, -52, 67, -20, 90, 12, -64, -58, 105, 110, -52, 3, 107, 102, 127, -34, 66, 8, 103, -34, 88, -59, -8, -24, 110, -114, -92, 117, 77, -94, -64, 37, 73, -123, -127, 19, -63, -6, -47, 63, 76, 112, 58, 100, 38, -13, 81, 8, 43, 86, 1, -26, 79, 26, -84, 107, -120, 53, 123, -66, -105, 65, -111, -21, -116, -25, -80, 50, 9, 62, -92, 10, -89, -104, 25, -80, 45, 117, 65, 96, 110, 35, 61, -75, -73, -107, -42, -5, 15, -19, -80, 36, 41, -104, -54, -83, -65, 109, 19, 20, -101, -63, -10, -16, -77, -122, -125, 121, 49, 6, -70, 70, 65, -69, 11, -117, 93, 17, 82, -95, -43, 46, -84, 126, -13, 74, 26, -2, -126, -84, -95, -23, -35, -33, -122, 22, -72, -128, -63, -28, 25, -76, 107, 16, 51, 17, 64, -73, 125, -38, -86, 48, -17, 84, -78, -45, 105, 75, -113, 55 };
        String message = "message";
     
        byte[] signature = rsaDecryptionService.sign(message.getBytes(UTF_8));
     
        assertThat(expectedSignature).isEqualTo(signature);
    }
    
}