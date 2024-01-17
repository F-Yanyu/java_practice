package org.example.project.EncryptionAndSecurity;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.Arrays;

public class HmacAlgorithm {
    public static void main(String[] args) throws Exception {
        /**
         * Hmac算法
         */
        KeyGenerator hmacMD5 = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = hmacMD5.generateKey();
        // 打印随机生成的key
        byte[] encoded = secretKey.getEncoded();
        System.out.println("key："+Arrays.toString(encoded));
        System.out.println("随机生成的key:"+new BigInteger(1,encoded).toString(16) );

        Mac hmacMD51 = Mac.getInstance("HmacMD5");
        hmacMD51.init(secretKey);
        hmacMD51.update("HelloWorld".getBytes("UTF-8"));
        byte[] bytes = hmacMD51.doFinal();
        System.out.println(new BigInteger(1,bytes).toString(16));
        System.out.println(Arrays.toString(bytes));

        // 有了Hmac计算的哈希和SecretKey，我们想要验证怎么办？这时，SecretKey不能从KeyGenerator生成，而是从一个byte[]数组恢复：
        SecretKey key = new SecretKeySpec(bytes, "HmacMD5");
        System.out.println(Arrays.toString(encoded));
    }
}
