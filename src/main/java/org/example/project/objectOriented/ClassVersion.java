package org.example.project.objectOriented;

public class ClassVersion {
    public static void main(String[] args){
        /**
         * @java版本
         *
         * 指定编译输出有两种方式，一种是在javac命令行中用参数--release设置：
         * $ javac --release 11 Main.java
         * 参数--release 11表示源码兼容Java 11，编译的class输出版本为Java 11兼容，即class版本55。
         *
         * 第二种方式是用参数--source指定源码版本，用参数--target指定输出class版本：
         * $ javac --source 9 --target 11 Main.java
         * 上述命令如果使用Java 17的JDK编译，它会把源码视为Java 9兼容版本，并输出class为Java 11兼容版本。注意--release参数和--source --target参数只能二选一，不能同时设置。
         */


        /**
         * @小节
         * 高版本的JDK可编译输出低版本兼容的class文件，但需注意，低版本的JDK可能不存在高版本JDK添加的类和方法，导致运行时报错。
         * 运行时使用哪个JDK版本，编译时就尽量使用同一版本编译源码。
         */
    }
}
