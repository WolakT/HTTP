package com.sda.crypto;

public class CryptoDemo {

    public static void main(String[] args) {

        String message = "To be or not to be java developer, that is the question !";

        //AES
        AESCipher aesCipher = new AESCipher();
        String encypted = aesCipher.encrypt(message);

        System.out.println(encypted);

        String decrypted = aesCipher.decrypt(encypted);

        System.out.println(decrypted);
    }
}
