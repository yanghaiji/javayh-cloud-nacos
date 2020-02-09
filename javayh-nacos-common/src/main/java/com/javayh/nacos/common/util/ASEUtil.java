package com.javayh.nacos.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.codec.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @ClassName javayh-cloud-nacos → com.javayh.nacos.common.util → ASEUtil
 * @Description 加密
 * @Author Dylan
 * @Date 2020/1/20 16:51
 * @Version
 */
@Slf4j
public class ASEUtil {


    private static final String PASS_NEED = "javayh-haiji-dylan";
    private static final String INSTANCE = "AES/ECB/PKCS5Padding";
    private static SecretKeySpec key;
    private static  Cipher  encCipher = null;
    private static  Cipher  decCipher = null;

    static {
        byte[] enCodeFormat = Arrays.copyOf(PASS_NEED.getBytes(), 16);
        key = new SecretKeySpec(enCodeFormat, "AES");
        try {
            encCipher = Cipher.getInstance(INSTANCE);
            encCipher.init(Cipher.ENCRYPT_MODE, key);
            decCipher = Cipher.getInstance(INSTANCE);
            decCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException e) {
            log.info(" NoSuchAlgorithmException is error {}", e.getMessage());
        } catch (NoSuchPaddingException e) {
            log.info(" NoSuchPaddingException is error {}", e.getMessage());
        } catch (InvalidKeyException e) {
            log.info(" InvalidKeyException is error {}", e.getMessage());
        }
    }

    public static String encryData(String plaintData){
        byte result[] = new byte[0];
        try {
            result = encCipher.doFinal(plaintData.getBytes());
        } catch (IllegalBlockSizeException e) {
            log.info(" IllegalBlockSizeException is error {}", e.getMessage());
        } catch (BadPaddingException e) {
            log.info(" BadPaddingException is error {}", e.getMessage());
        }
        return new String(Base64.encode(result));
    }

    public static  String decryData(String encData){
        byte result[] = new byte[0];
        try {
            result = decCipher.doFinal(Base64.decode(encData.getBytes()));
        }  catch (IllegalBlockSizeException e) {
            log.info(" IllegalBlockSizeException is error {}", e.getMessage());
        } catch (BadPaddingException e) {
            log.info(" BadPaddingException is error {}", e.getMessage());
        }
        return new String(result);
    }



    public static byte[] encryData(byte []plaintData){
        byte result[] = new byte[0];
        try {
            result = encCipher.doFinal(plaintData);
        } catch (IllegalBlockSizeException e) {
            log.info(" IllegalBlockSizeException is error {}", e.getMessage());
        } catch (BadPaddingException e) {
            log.info(" BadPaddingException is error {}", e.getMessage());
        }
        return result;
    }

    public static  byte[] decryData(byte [] encData){
        byte result[] = new byte[0];
        try {
            result = decCipher.doFinal(encData);
        } catch (IllegalBlockSizeException e) {
            log.info(" IllegalBlockSizeException is error {}", e.getMessage());
        } catch (BadPaddingException e) {
            log.info(" BadPaddingException is error {}", e.getMessage());
        }
        return result;
    }

//	public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException {
//		String admin = encryData("123");
//		System.out.println(admin);
//	}
}