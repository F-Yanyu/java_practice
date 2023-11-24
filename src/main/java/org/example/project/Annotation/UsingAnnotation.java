package org.example.project.Annotation;

public class UsingAnnotation {
    public static void main(String[] args) {
        /**
         * 注解（Annotation）：注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”：
         *
         * java的注解分为3大类：
         * 1.由编译器使用的注解
         *      - @Override:让编译器检查该方法是否正确的实现了覆盖。
         *      - @SuppressWarnings:告诉编译器忽略此处代码产生的警告。
         *      这类注解不会被编译进".class"文件，他们编译后就会被编译器丢掉。
         * 2.是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。
         *      这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。
         * 3.是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。
         *      例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用（这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。
         */

        /**
         * @小结
         *  注释（Annotation）是java语言用于工具处理的标注
         *  注解可以配置参数，没有指定配置的参数使用默认值
         *  如果参数名称是value,且只有一个参数，那么可以省略参数名称。
         */
    }
}
