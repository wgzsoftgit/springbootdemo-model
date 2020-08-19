package com.demomodel.utils.Md5.AsymmetriencryptionAlgorithm;


import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.kerby.util.Base64;
/**
 * 解决方法：
配置JVM的系统变量：-Djdk.crypto.KeyAgreement.legacyKDF=true
具体操作：
在eclipse的run Configurations里面配置系统变量，如下图，左侧选择相应的应用，右侧Arguments下填入咱们要添加的系统变量，然后apply，运行程序，错误解决！
 * @author wgz
 * @date 创建时间：2020年8月3日 上午11:34:52
 */
public class DH {
	private static String SRC="hello world";
	
public static void main(String[] args) {
	jdkDH();
}
		

	
	// jdk实现：
	public static void jdkDH() {

		try {
//1.初始化发送方密钥
			KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			senderKeyPairGenerator.initialize(512);
			KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
//发送方公钥，发送给接收方（网络、文件。。。）
			byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();

//2.初始化接收方密钥
			KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
			PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey).getParams();
			KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			receiverKeyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiverKeypair = receiverKeyPairGenerator.generateKeyPair();
			PrivateKey receiverPrivateKey = receiverKeypair.getPrivate();
			byte[] receiverPublicKeyEnc = receiverKeypair.getPublic().getEncoded();

//3.密钥构建
			KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
			receiverKeyAgreement.init(receiverPrivateKey);
			receiverKeyAgreement.doPhase(receiverPublicKey, true);
			SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");

			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
			senderKeyAgreement.init(senderKeyPair.getPrivate());
			senderKeyAgreement.doPhase(senderPublicKey, true);
			SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
			if (Objects.equals(receiverDesKey, senderDesKey)) {
				System.out.println("双方密钥相同。");
			}

//4.加密
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
			byte[] result = cipher.doFinal(SRC.getBytes());
			System.out.println("bc dh encrypt:" + Base64.encodeBase64String(result));

//5.解密
			cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
			result = cipher.doFinal(result);
			System.out.println("bc dh decrypt:" + new String(result));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
