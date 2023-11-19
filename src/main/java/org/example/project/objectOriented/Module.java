package org.example.project.objectOriented;

public class Module {
    public static void main(String[] args) {
        /**
         * @Module
         * 把一堆class封装为jar仅仅是一个打包的过程，而把一堆class封装为模块则不但需要打包，还需要写入依赖关系，并且还可以包含二进制代码（通常是JNI扩展）。此外，模块支持多版本，即在同一个模块中可以为不同的JVM提供不同的版本。
         *
         * bin目录存放编译后的class文件，src目录存放源码，按包名的目录结构存放，仅仅在src目录下多了一个module-info.java这个文件，这就是模块的描述文件。在这个模块中，它长这样：
         * module hello.world {
         * 	requires java.base; // 可不写，任何模块都会自动引入java.base
         * 	requires java.xml;
         * }
         * 其中，module是关键字，后面的hello.world是模块的名称，它的命名规范与包一致。花括号的requires xxx;表示这个模块需要引用的其他模块名。除了java.base可以被自动引入外，这里我们引入了一个java.xml的模块。
         *
         * 当我们使用模块声明了依赖关系后，才能使用引入的模块。例如，Main.java代码如下：
         *  package com.itranswarp.sample;
         *
         *  // 必须引入java.xml模块后才能使用其中的类:
         *  import javax.xml.XMLConstants;
         *
         *  public class Main {
         * 	    public static void main(String[] args) {
         * 		    Greeting g = new Greeting();
         * 		    System.out.println(g.hello(XMLConstants.XML_NS_PREFIX));
         *      }
         *  }
         * 如果把requires java.xml;从module-info.java中去掉，编译将报错。可见，模块的重要作用就是声明依赖关系。
         *
         */


        /**
         * @访问权限
         * 确切地说，class的这些访问权限只在一个模块内有效，模块和模块之间，例如，a模块要访问b模块的某个class，必要条件是b模块明确地导出了可以访问的包。
         */

        /**
         * @小结
         * Java 9引入的模块目的是为了管理依赖；
         *
         * 使用模块可以按需打包JRE；
         *
         * 使用模块对类的访问权限有了进一步限制。
         *
         */
    }
}
