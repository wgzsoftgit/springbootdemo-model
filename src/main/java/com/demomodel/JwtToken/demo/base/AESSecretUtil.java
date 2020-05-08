package com.demomodel.JwtToken.demo.base;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;


/**
 * AES加密工具类
 * @author wgz
 * @date 创建时间：2020年4月25日 上午9:46:03
 */
public class AESSecretUtil {

    /**秘钥的大小*/
    private static final int KEYSIZE = 128;
    
    /**
     * @Author: Helon
     * @Description: AES加密 返回byte[]
     * @param data - 待加密内容
     * @param key - 加密秘钥
     * @Data: 2018/7/28 18:42
     * @Modified By:
     */
    public static byte[] encrypt(String data, String key) {
        if(StringUtils.isNotBlank(data)){
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                //选择一种固定算法，为了避免不同java实现的不同算法，生成不同的密钥，而导致解密失败
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                random.setSeed(key.getBytes());
                keyGenerator.init(KEYSIZE, random);
                SecretKey secretKey = keyGenerator.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                byte[] byteContent = data.getBytes("utf-8");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);// 初始化
                byte[] result = cipher.doFinal(byteContent);
                return result; // 加密
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Author: Helon
     * @Description: AES加密，返回String
     * @param data - 待加密内容
     * @param key - 加密秘钥
     * @Data: 2018/7/28 18:59
     * @Modified By:
     */
    public static String encryptToStr(String data, String key){

        return StringUtils.isNotBlank(data)?parseByte2HexStr(encrypt(data, key)):null;
    }


    /**
     * @Author: Helon
     * @Description: AES解密  返回byte[]
     * @param data - 待解密字节数组
     * @param key - 秘钥
     * @Data: 2018/7/28 19:01
     * @Modified By:
     */
    public static byte[] decrypt(byte[] data, String key) {
        if (ArrayUtils.isNotEmpty(data)) {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                //选择一种固定算法，为了避免不同java实现的不同算法，生成不同的密钥，而导致解密失败
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                random.setSeed(key.getBytes());
                keyGenerator.init(KEYSIZE, random);
                SecretKey secretKey = keyGenerator.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);// 初始化
                byte[] result = cipher.doFinal(data);
                return result; // 加密
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Author: Helon
     * @Description: AES解密，返回String
     * @param enCryptdata - 待解密字节数组
     * @param key - 秘钥
     * @Data: 2018/7/28 19:01
     * @Modified By:
     */
    public static String decryptToStr(String enCryptdata, String key) {
        return StringUtils.isNotBlank(enCryptdata)?new String(decrypt(parseHexStr2Byte(enCryptdata), key)):null;
    }

    /**
     * @Author: Helon
     * @Description: 将二进制转换成16进制 返回String
     * @param buf - 二进制数组
     * @Data: 2018/7/28 19:12
     * @Modified By:
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    
    /** Array of all hexadecimal chars 所有十六进制字符的数组*/
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();  
    /**方案二             字节数组转字符串
     * @param bytes a byte array字节数组
     * @return a hex string十六进制字符串
     */
    public static String bytesToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_CHARS[v >>> 4];
            hexChars[i * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * @Author: Helon
     * @Description: 将16进制转换为二进制  返回byte[]
     * @param hexStr - 16进制字符串
     * @Data: 2018/7/28 19:13
     * @Modified By:
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
   
    /**方案二      十六进制字符串转字节数组
     * @param s a hex string十六进制字符串
     * @return a byte array字节数组
     * 
     */
   
    public static byte[] hexStringToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
    /** Regex pattern for hexadecimal strings 十六进制字符串的正则表达式模式*/
    private static final Pattern HEX_STRING_PATTERN = Pattern.compile("^([0-9A-Fa-f]{2})+$");
    /**
     * @param s a string
     * @return 如果提供的字符串为十六进制，则为true；否则为false 
     */
    public static boolean isHexString(String s) {
        return (s != null) && HEX_STRING_PATTERN.matcher(s).matches();
    }
    public static void main(String[] args) {
    	String str="123456789";
    	String initdata="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxMjMiLCJ1c2VyTmFtZSI6Ikp1ZHkiLCJleHAiOjE1MzI3Nzk2MjIsIm5iZiI6MTUzMjc3NzgyMn0.sIw_leDZwG0pJ8ty85Iecd_VXjObYutILNEwPUyeVSo";
        String ss = encryptToStr(str, SecretConstant.DATAKEY);
        
        byte[] encrypt = encrypt(str,SecretConstant.DATAKEY);//AES加密 返回byte[]
        String parseByte2HexStr = parseByte2HexStr(encrypt);  //将二进制转换成16进制 返回String
        System.out.println("判断是否是十六进制"+isHexString(parseByte2HexStr));
        //1AD9A5475194D80B78483C5BE8C6EDC7D1D02B63C2016F779FE6F1EAEA72D10ACC299908BB7BAA3F227EE519E7DD2A5A6233126254DC4045B2EFF497326EFA7C45670A1EF4F29097635AAF5ADCC68B9EBFD044A8A4F9DF1D23B14F8AB1768F556120BFBE8C56382A91564FCBD3366F1EADFCBB0BA414A308A2817DE87297EF88F5227B83E10C05F498D4DCFD3106D5C3DDF5A777C14FC45CCB3E0F66A9015FF79BE04DFA0246FAB63077C393FE40B55F
        System.out.println("将二进制转换成16进制 返回String"+parseByte2HexStr);
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxMjMiLCJ1c2VyTmFtZSI6Ikp1ZHkiLCJleHAiOjE1MzI3Nzk2MjIsIm5iZiI6MTUzMjc3NzgyMn0.sIw_leDZwG0pJ8ty85Iecd_VXjObYutILNEwPUyeVSo
        System.err.println("AES解密，返回String"+decryptToStr(parseByte2HexStr, SecretConstant.DATAKEY));
        
        
        System.out.println("AES加密，返回String##$$"+ss);
        System.out.println("AES解密，返回String"+decryptToStr(ss, SecretConstant.DATAKEY));
        
        
    }

}
