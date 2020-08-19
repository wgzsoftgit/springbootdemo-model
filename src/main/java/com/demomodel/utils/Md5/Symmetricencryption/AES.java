package com.demomodel.utils.Md5.Symmetricencryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.kerby.util.Base64;


public class AES {
	private static String SRC="hello world";

    public static void main(String[] args){
        jdkAES();
    }

    public static void jdkAES(){
        try {
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //key的转换
            Key key=new SecretKeySpec(keyBytes,"AES");

            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] bytes = cipher.doFinal(SRC.getBytes());
            System.out.println("jdk aes encrypt:"+ Base64.encodeBase64String(bytes));

            //解密
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] result=cipher.doFinal(bytes);
            System.out.println("jdk aes desrypt:"+new String(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
