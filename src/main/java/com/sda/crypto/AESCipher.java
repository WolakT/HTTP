package com.sda.crypto;


import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



public class AESCipher {

    private final static String AES_PADDING_ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding";
    private final static String SAMPLE_KEY = "xuwAMrtGPhG5xkf6-T6aBQ";
    private final Cipher encryptCipher;
    private final Cipher decryptCipher;


    public AESCipher(){
        encryptCipher = initCipher(SAMPLE_KEY, ENCRYPT_MODE);
        decryptCipher = initCipher(SAMPLE_KEY, DECRYPT_MODE);
    }

    private Cipher initCipher(String cryptoKey,int mode){
        SecretKeySpec secretKey = new SecretKeySpec(Base64.decodeBase64(cryptoKey), "AES");
        try {
            Cipher cipher = Cipher.getInstance(AES_PADDING_ENCRYPTION_ALGORITHM);
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            cipher.init(mode, secretKey, new IvParameterSpec(iv));
            return cipher;
        }catch(GeneralSecurityException e ){
            throw new RuntimeException(e);
        }
    }

    public String encrypt(String input) {
        try {
            return Base64.encodeBase64URLSafeString(encryptCipher.doFinal(input.getBytes()));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String input) {
        try {
            return new String(decryptCipher.doFinal(Base64.decodeBase64(input)));
        }catch (GeneralSecurityException e){
            throw new RuntimeException(e);
        }
    }
}
