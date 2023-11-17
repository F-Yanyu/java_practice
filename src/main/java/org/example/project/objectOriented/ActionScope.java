package org.example.project.objectOriented;

public class ActionScope {
    public static void main(String[] args) {
        /**
         * @scope 作用域
         * 在Java中，我们经常看到public、protected、private这些修饰符。
         * 在Java中，这些修饰符可以用来限定访问作用域。
         *
         * private访问权限被限定在class的内部，而且与方法声明顺序无关。
         * 推荐把private方法放到后面，
         *
         * 由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限：
         */

        /**
         * 定义的protected用作继承关系，定义为protected的字段和方法可以被子类访问。（以及子类的子类）
         *     protected void hi() {
         *     }
         */

        /**
         * @包作用域 是指一个类允许访问同一个package的没有public、private、修饰的class，以及没有public、protected、private修饰的字段和方法。
         * 栗子：
         * package abc;
         * class Hello{
         *  void hi(){
         *  }
         * }
         *
         * package abc;
         * class Main{
         *  void foo(){
         *      Hello h = new Hello();
         *      h.hi();// 可以调用package权限的方法。
         *  }
         * }
         */

        /**
         * @局部变量
         * 在方法内部定义的变量称为局部变量，局部变量作用域从变量声明处开始到对应的块结束。方法参数也是局部变量。
         * 使用局部变量时，应该尽可能把局部变量的作用域缩小，尽可能延后声明局部变量。
         */

        /**
         * @final
         * java提供final修饰符，final与访问权限不冲突，它有很多作用。
         *
         * 用final修饰符可以阻止被继承。
         * public final class Hello{
         *      private int n = 0;
         *      protected void hi(int t){
         *          long i = t;
         *      }
         * }
         *
         * 用final修饰method可以阻止被子类覆盖
         * public class Hello{
         *     protected final void add(){
         *         System.out.println("haha");
         *     }
         * }
         *
         * 用final修饰field可以阻止被重新赋值
         * public class Hello{
         *     private final int n = 0;
         *     public void edit(int a){
         *         this.n = a// error
         *     }
         * }
         *
         * 用final修饰局部变量可以阻止被重新赋值
         * public class Hello{
         *     public void edit(final int n){
         *         n = 1;//error
         *     }
         * }
         */


        /**
         * @最佳实践
         * 如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。
         * 把方法定义为package权限有助于测试，因为测试类和被测试类只要位于一个package，测试代码就可以访问被测试类的package权限方法。
         * 一个java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。
         */
    }
    /*
    嵌套类
    */
    static class Inner {
        public void hi() {
            ActionScope.hello();
        }
    }
    private static void hello() {
        System.out.println("private hello");
    }
};

