package org.example.project.objectOriented;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

public class AbstractClass {
    public static void main(String[] args) {
        /**
         * @抽象类
         * 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
         * 因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）。
         * 使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类：
         *
         * 抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”。
         * 例：
         *      如PersonClass定义了抽象方法run()，那么子类StudentClass就必须重写run()方法。
         *
         *
         * 面向抽象编程
         * Person s = new Student();
         * Person t = new Teacher();
         * 这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型：
         * // 不关心Person变量的具体子类型:
         * s.run();
         * t.run();
         * 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。
         */

//    PersonOfAbstract person = new PersonOfAbstract();// 无法被实例化。
        PersonOfAbstract stud = new StudentOfAbstract();
        haha(stud);

    }
    public static void haha(PersonOfAbstract stud){
        stud.run();
    }

};

abstract class PersonOfAbstract {
    public abstract void run();
};

class StudentOfAbstract extends PersonOfAbstract {
    @Override
    public void run() { // 继承抽象类，必须覆写抽象方法。
        System.out.println("hahah");
    }
}