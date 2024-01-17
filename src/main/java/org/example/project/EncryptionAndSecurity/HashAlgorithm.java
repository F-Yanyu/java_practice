package org.example.project.EncryptionAndSecurity;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashAlgorithm {
    public static void main(String[] args) throws Exception {
        /**
         * @哈希算法
         * 哈希算法最重要的特点就是：
         *
         * 相同的输入一定得到相同的输出；
         * 不同的输入大概率得到不同的输出。
         * 哈希算法的目的就是为了验证原始数据是否被篡改。
         *
         * Java字符串的hashCode()就是一个哈希算法，它的输入是任意字符串，输出是固定的4字节int整数：
         */

        System.out.println("hello".hashCode());

        /**
         * @哈希碰撞
         * 哈希碰撞是指，两个不同的输入得到了相同的输出：
         */

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println("根据碰撞概率，哈希算法的输出长度越长，就越难产生碰撞，也就越安全。Java标准库提供了常用的哈希算法，并且有一套统一的接口。我们以MD5算法为例，看看如何对输入计算哈希：");
        System.out.println(new BigInteger(1,result).toString(16));


        /**
         * @小结
         * 哈希算法可用于验证数据完整性，具有防篡改检测的功能；
         * 常用的哈希算法有MD5、SHA-1等；
         * 用哈希存储口令时要考虑彩虹表攻击。
         */
    }
}
