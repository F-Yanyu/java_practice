package org.example.project.ExceptionHanding;

public class NullPointerExceptionPractice {
    public static void main(String[] args) {
        /**
         * @NullPointerException 即空指针异常，俗称NPE
         * 如果一个对象为null就会跳出这个异常。通常由jvm抛出的。
         */
        String s = null;
//        System.out.println(s.toLowerCase());

        /**
         * @处理NullPointerException
         * - 首先必须明确，NullPointException是一种逻辑错误，遇到NullPointerException,遵循原则是
         *      早暴露，早修复，严谨使用catch来隐藏这种编码错误。
         */
        /*
        错误示例：
        try{
            transferMoney(form,to,amount);
        }catch(NullPointerException e) {

        }
         */

        /**
         * 好的编码习惯可以避免NullPointerException的产生，请看下边例子：
         *
         * @成员变量在定义时初始化
         * public class Person{
         *    private String name = "";
         * }
         * 这样可以使得调用方无需检查结果是否为null
         * 如果调用方一定要根据null判断，比如返回null表示文件不存在，那么考虑返回Optional<T>：
         * public Optional<String> readFromFile(String file) {
         *     if (!fileExist(file)) {
         *         return Optional.empty();
         *     }
         *     ...
         * }
         *
         * 这样调用方必须通过Optional.isPresent()判断是否有结果。
         */

        /**
         * @定位NullPointerException
         * 除了普通的打印排查以外，从java 14开始，如果产生NullPointerException,JVM可以给出详细的信息告诉我们null对象到底是谁。
         * 但默认是关闭的，我们可以给JVM添加一个-XX:+ShowCodeDetailsInExceptionMessages参数启用它：
         * java -XX:+ShowCodeDetailsInExceptionMessage Main.java
         */
        PersonOfNullPointerException person = new PersonOfNullPointerException();
        System.out.println(person.address.city.toLowerCase());

        /**
         * @小结
         * NullPointerException是java代码常见的逻辑错误，应该早暴露，早修复。
         * 可以启用Java 14的增强异常信息来查看NullPointerException的详细错误信息。
         */
    }
}

class PersonOfNullPointerException {
    String[] name = new String[2];
    Address address = new Address();
}

class Address{
    String city;
    String Street;
    String zipcode;
}
