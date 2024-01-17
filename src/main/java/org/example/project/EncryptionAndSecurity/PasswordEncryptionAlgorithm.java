package org.example.project.EncryptionAndSecurity;

public class PasswordEncryptionAlgorithm {
    public static void main(String[] args) throws Exception {
        /**
         * @口令加密算法
         *
         */

        /*
        PBE的作用就是把用户输入的口令和一个安全随机的口令采用杂凑后计算出真正的密钥。以AES密
         */

        /**
         * @小结
         * PBE算法通过用户口令和安全的随机salt计算出Key，然后再进行加密；
         * Key通过口令和安全的随机salt计算得出，大大提高了安全性；
         * PBE算法内部使用的仍然是标准对称加密算法（例如AES）。
         */
    }
}
