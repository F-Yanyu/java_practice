package org.example.project.IO;

public class FilterSchemaPractice {
    public static void main(String[] args) {
        /**
         * @Filter模式
         * 这种通过一个“基础”组件再叠加各种“附加”功能组件的模式，称之为Filter模式（或者装饰器模式：Decorator）。它可以让我们通过少量的类来实现各种功能的组合：
         *
         * @编写FilterInputStream
         *
         *
         * @小结
         * Java的IO标准库使用Filter模式为InputStream和OutputStream增加功能：
         *
         * 可以把一个InputStream和任意个FilterInputStream组合；
         *
         * 可以把一个OutputStream和任意个FilterOutputStream组合。
         *
         * Filter模式可以在运行期动态增加功能（又称Decorator模式）。
         */


    }
}
