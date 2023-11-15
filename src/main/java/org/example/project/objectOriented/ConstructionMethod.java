package org.example.project.objectOriented;

public class ConstructionMethod {
    public static void main(String[] args){
        /**
         * 例：
         * Person ming = new Person();
         * ming.setName("小明");
         * ming.setAge(12);
         * 初始化对象实例需要3行代码，而且，如果忘了调用setName()或者setAge()，这个实例内部的状态就是不正确的。
         *
         * 使用构造方法，在创建对象实例时就把内部字段全部初始化为合适的值
         *
         * 构造方法的名称就是类名,构造方法没有返回值（也没有void），调用构造方法，必须用new操作符
         * 每一个类都有构造方法。
         * 我们自定义一个构造方法后，编译器将不会自动创建构造方法。如果想要使用带参数和不带参数的构造方法，需要全部都定义出来。
         *
         * 默认初始化，引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false：
         *
         * 可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量，位置，类型自动区分。
         *
         * 一个构造方法可以调用其他构造方法，语法是this(...);
         */
        PersonOfConstruction ming = new PersonOfConstruction("ming",19);
        System.out.println(ming.getName());
        System.out.println(ming.getAge());


        /**
         * practice:请给Person类增加(String, int)的构造方法：
         */


    }
}

class PersonOfConstruction{
    private String name;
    private int age = 0;
    public PersonOfConstruction(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
