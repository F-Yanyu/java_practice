package org.example.project.objectOriented;

public class Interface {
    public static void main(String[] args){
        /**
         * @接口
         * 在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。
         * 如果一个抽象类没有字段，所有方法全部都是抽象方法：
         * abstract class Person {
         *     public abstract void run();
         *     public abstract String getName();
         * }
         * 就可以把该抽象类改写为接口：interface。
         * 在Java中，使用interface可以声明一个接口：
         * 特点：不能有字段，所有的方法默认都是public abstract的。
         */


        /**
         * @implements
         * 当一个类具体的实现一个interface的时候需要使用“implements”
         * 例：
         *      class Student implements Person{
         *          private String name;
         *          public Student(String name){
         *              this.name = name;
         *          }
         *          @override
         *          public void run(){
         *              System.out.println("haha")
         *          }
         *      }
         */


        /**
         * 在java中一个类只能继承自另一个类，但是，一个类可以实现多个interface,例如：
         * class Student implements Person,Hello{
         *      ...
         * }
         */

        /**
         * @default方法（JDK>=1.8）
         * 实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
         * default方法和抽象类的普通方法是有所不同的。因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
         */


    }
}
interface PersonOrInterface{
    void run();
}
