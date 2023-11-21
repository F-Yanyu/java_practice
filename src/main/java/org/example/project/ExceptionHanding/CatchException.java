package org.example.project.ExceptionHanding;

public class CatchException {
    public static void main(String[] args) {
        /**
         * @捕获异常
         * @多catch语句
         * 可以使用多个catch语句，每个catch分别捕获对应的Exception及其子类。JVM在捕获到异常后，会从上到下匹配catch语句，匹配到某个catch后，执行catch代码块，然后不再继续匹配。
         *
         * 简单地说就是：多个catch语句只有一个能被执行。例如：
         * try {
         *    process1();
         *    process2();
         *    process3();
         * } catch (IOException e) {
         *    System.out.println(e);
         * } catch (NumberFormatException e) {
         *    System.out.println(e);
         * }
         */


        /**
         * 存在多个catch的时候，catch的顺序非常重要：子类必须写在前面
         */

        /**
         * @finally语句
         * Java的try ... catch机制还提供了finally语句，finally语句块保证有无错误都会执行
         *
         * @特点：
         * 1.finally不是必须写的，可写可不写。
         * 2.finally总是最后执行。
         * 某些情况下，可以没有catch，只使用try ... finally结构。
         */


        /**
         * @捕获多种异常
         * 如果某些异常的处理逻辑相同，但是异常本身不存在继承关系，那么就得编写多条catch子句：
         *
         * try {
         *     process1();
         *     process2();
         *     process3();
         * } catch(IOException e){
         *     System.out.println("Bad input");
         * } catch(NumberFormatException e){
         *     System.out.println("Bad input");
         * }
         *
         * 由于IOException和NumberFormatException的代码一样，所以可以使用“|”合并在一起
         * try {
         *      process1();
         *      process2();
         *      process3();
         *  } catch(IOException e | NumberFormatException e){
         *      System.out.println("Bad input");
         *  }
         */

        /**
         * @小结
         * 使用try ... catch ... finally时：
         * 多个catch语句的匹配顺序非常重要，子类必须放在前面；
         * finally语句保证了有无异常都会执行，它是可选的；
         * 一个catch语句也可以匹配多个非继承关系的异常。
         */




    }
}
