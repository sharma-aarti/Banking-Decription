# Internet Banking System Decryption Service

## Introduction
 implemented an internal interface for an Internet Banking System.
The interface is used as a "central point" of secure decryption of sensitive data.

## Description
The implementation of `RSADecryptionService` (all requirements are specified for the UTF-8 charset).

Requirements:

- The `byte[] decrypt(byte[] data)` method decrypts data by using the RSA algorithm.

     - When the data parameter is null or an array is empty, or the provided data is too long for the RSA algorithm, the method throws the `InvalidDataLengthException`.
     
     - When the data passed as a parameter is incorrect (cannot be decrypted), the `InvalidDataToDecryptException` is thrown.
     
     - Use the RSA 2048-bit private key (encoded according to the PKCS #8 standard) and the public key (encoded according to the X.509 standard) from `src/main/resources`.
 
- The `String decrypt(String dataAsBase64)` method performs the same functionality and implement the same requirements as `byte[] decrypt(byte[] data)` but: 

    - The data is passed as Base64.

    - When the data passed as a parameter is incorrect (incorrect Base64), the `InvalidDataToDecryptException` is thrown.	

- The `byte[] sign(byte[] data)` method signs the data passed as parameters with a digital RSA signature using the private key. 

	- If the data is null or empty, the method should throw the `InvalidDataToDecryptException`.
	
	- The method should use the `SHA256withRSA` hash algorithm.

