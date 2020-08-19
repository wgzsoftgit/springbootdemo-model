package com.demomodel.utils.Md5.Symmetricencryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 一般不会出现
 * @author wgz
 * @date 创建时间：2020年8月3日 上午12:20:24
 */
public class DES {
	public static void main(String[] args){
        //jdkDES();

        byte[] secretKeyEncode = createSecretKeyEncode();
        System.out.println(decrypt(secretKeyEncode,encryption(secretKeyEncode,"hello world")));
    }

    /**
     * 创建密钥
     * @return
     */
    public static byte[] createSecretKeyEncode(){
        //生成key
        KeyGenerator keyGenerator= null;
        try {
            keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey=keyGenerator.generateKey();
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     * @param secretKeyEncode
     * @param msg
     * @return
     */
    public static byte[] encryption(byte[] secretKeyEncode,String msg){
        //KEY转化
        DESKeySpec desKeySpec= null;
        try {
            desKeySpec = new DESKeySpec(secretKeyEncode);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);
            byte[] result = cipher.doFinal(msg.getBytes());
            return result;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param secretKeyEncode
     * @param msg
     * @return
     */
    public static String decrypt(byte[] secretKeyEncode,byte[] msg){
        try {
            //KEY转化
            DESKeySpec desKeySpec=new DESKeySpec(secretKeyEncode);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey convertSecretKey = factory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            return new String(cipher.doFinal(msg));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}
