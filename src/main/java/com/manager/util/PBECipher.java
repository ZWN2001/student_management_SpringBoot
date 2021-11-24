package com.manager.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


public class PBECipher {
    public static final String ALGORITHM = "PBEWITHMD5andDES";
    static final String CIPHER_NAME = "PBEwithSHA1and128bitAES-CBC-BC";
    static final int ITERATION_COUNT = 1000;

    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory sKeyFactory = SecretKeyFactory
                .getInstance(CIPHER_NAME);
        SecretKey skey = sKeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, ITERATION_COUNT);
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);

        return cipher.doFinal(input);
    }

}
