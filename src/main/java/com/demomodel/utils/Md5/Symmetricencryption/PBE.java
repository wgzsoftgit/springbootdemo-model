package com.demomodel.utils.Md5.Symmetricencryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.kerby.util.Base64;

//结合了消息摘要算法和对称加密算法的优点。
public class PBE {
	private static String src="hello world";

    public static void main(String[] args){
        jdkPBE();
    }

    public static void jdkPBE(){
        try {
            //初始化盐
            SecureRandom random=new SecureRandom();
            byte[] salt = random.generateSeed(8);

            //口令与密钥
            String password="shipp";
            PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key=factory.generateSecret(pbeKeySpec);

            //加密过程
            PBEParameterSpec pbeParameterSpec=new PBEParameterSpec(salt,100);
            Cipher cipher= Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk pbe encrypt:"+ Base64.encodeBase64String(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);
            byte[] bytes = cipher.doFinal(result);
            System.out.println("jdk pbe decrypt:"+new String(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
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
