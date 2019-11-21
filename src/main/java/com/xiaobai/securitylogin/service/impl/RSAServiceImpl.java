package com.xiaobai.securitylogin.service.impl;

import com.xiaobai.securitylogin.service.RSAService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA相关操作实现类
 *
 * @author 小白
 * @date 2019/11/19
 */
@Service
public class RSAServiceImpl implements RSAService {
    private static final String ALGORITHM = "RSA";
    private static final String PRIVATE_KEY = "privateKey";

    @Override
    public String generateKey(HttpServletRequest request) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGenerator.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        String privateKeyStr = new String(Base64.encodeBase64(privateKey.getEncoded()));
        // 将私钥存储在session中
        request.getSession().setAttribute(PRIVATE_KEY,privateKeyStr);
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()));
        return publicKeyStr;
    }

    @Override
    public String encrypt(String message, String publicKey) throws Exception {
        byte[] key = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String cipherText = new String(Base64.encodeBase64(cipher.doFinal(message.getBytes("UTF-8"))));
        return cipherText;
    }

    @Override
    public String decrypt(String cipherText, HttpServletRequest request) throws Exception {
        byte[] inputBytes = Base64.decodeBase64(cipherText);
        String privateKey = request.getSession().getAttribute(PRIVATE_KEY).toString();
        byte[] key = Base64.decodeBase64(privateKey);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
        String message = new String(cipher.doFinal(inputBytes));
        return message;
    }
}
