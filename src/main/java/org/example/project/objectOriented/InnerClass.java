package org.example.project.objectOriented;

public class InnerClass {
    public static void main(String[] args){
        /**
         * @innerClass 内部类
         * Java的内部类可分为Inner Class、Anonymous Class和Static Nested Class三种：
         *
         * 它被定义在另一个类的内部，所以称为内部类（Nested Class）。
         * 它与普通类有个最大的不同，就是Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例。
         */
        Outer outer = new Outer("付延余");
        Outer.Inner inner = outer.new Inner();

        inner.logName();


        /**
         * @AnonymousClass 匿名类
         * 在定义匿名类的时候就必须实例化它，定义匿名类的写法如下：
         *
         * Runnable r = new Runnable() {
         *     // 实现必要的抽象方法...
         * };
         */
        OuterOfAnon outerOfAnon = new OuterOfAnon("likeFyy");
        outerOfAnon.hello();


        /**
         * @StaticNestedClass
         * 最后一种内部类和Inner Class类似，但是使用static修饰，称为静态内部类（Static Nested Class）：
         *
         * 用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，而是一个完全独立的类，因此无法引用Outer.this，
         * 但它可以访问Outer的private静态字段和静态方法。如果把StaticNested移到Outer之外，就失去了访问private的权限。
         */

        OuterOfStaticNestedClass.StaticNested sn = new OuterOfStaticNestedClass.StaticNested();
        sn.hello();
    }
}


/**
 * @innerClass栗子
 */
class Outer{
    private String name;
    Outer(String name){
       this.name = name;
    }

    class Inner{
        void logName(){
            System.out.println("hello:"+name);
        }
    }
}

/**
 * @AnonymousClass栗子
 */

class OuterOfAnon{
    private String name;
    OuterOfAnon(String name){
        this.name = name;
    }
    void hello(){
        Runnable r = new Runnable(){ // 匿名类
            @Override
            public void run() {
                System.out.println("Hello, " + OuterOfAnon.this.name);
            }
        };
        new Thread(r).start();
    }
}

/**
 * @StaticNestedClass栗子
 */
class OuterOfStaticNestedClass {
    private static String NAME = "OUTER";

    private String name;

    OuterOfStaticNestedClass(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            System.out.println("Hello, " + OuterOfStaticNestedClass.NAME);
        }
    }
}