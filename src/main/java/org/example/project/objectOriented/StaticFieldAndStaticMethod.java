package org.example.project.objectOriented;

public class StaticFieldAndStaticMethod {
    public static void main(String[] args){
        /**
         * @staticField (静态字段)
         * 实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段。
         *
         */

        /*
        对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例：
        推荐用类名来访问静态字段。可以把静态字段理解为描述class本身的字段（非实例字段）。
         */
        PersonOfStaticField ming = new PersonOfStaticField("小明",18);
        PersonOfStaticField hong = new PersonOfStaticField("小红",21);
        ming.number = 110;
        System.out.println(hong.number);
        hong.number = 120;
        System.out.println(ming.number);

        /**
         * @staticMethod (静态方法)
         * 调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。静态方法类似其它编程语言的函数。
         * 因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
         * 静态方法经常用于工具类。例如：
         * Arrays.sort()
         * Math.random()
         */

        PersonOfStaticField.setNumber(99);
        System.out.println("PersonOfStaticField.number:"+PersonOfStaticField.number);

        /**
         * @接口的静态方法
         * 因为interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型：
         * public interface Person {
         *     public static final int MALE = 1;
         *     public static final int FEMALE = 2;
         * }
         * 实际上，因为interface的字段只能是public static final类型，所以我们可以把这些修饰符都去掉，上述代码可以简写为：
         * public interface Person {
         *     // 编译器会自动加上public statc final:
         *     int MALE = 1;
         *     int FEMALE = 2;
         * }
         */

        // 总结
        // 静态字段属于所有实例“共享”的字段，实际上是属于class的字段；
        // 调用静态方法不需要实例，无法访问this，但可以访问静态字段和其他静态方法；
    }   // 静态方法常用于工具类和辅助方法。
}


class PersonOfStaticField{
    public String name;
    public int age;
    public static int number;
    public PersonOfStaticField(String name,int age){
        this.name = name;
        this.age = age;
    }
    public static void setNumber(int num){
        number = num;
    }
}