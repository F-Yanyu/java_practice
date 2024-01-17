package org.example.project.EncryptionAndSecurity;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncryptionAlgorithm {
    public static void main(String[] args) {
        /**
         * @编码算法
         */
        /**
         * @URL编码
         * 如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
         * 如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。
         *
         * Java标准库提供了一个URLEncoder类来对任意字符串进行URL编码：
         * Java标准库的URLDecoder就可以解码：
         */

        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println(encoded);
        String decoded = URLDecoder.decode(encoded,StandardCharsets.UTF_8);
        System.out.println(decoded);


        /**
         * @Base64编码
         * URL编码是对字符进行编码，表示成%xx的形式，而Base64编码是对二进制数据进行编码，表示成文本格式。
         *
         */

    }
}
