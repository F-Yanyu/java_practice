package org.example.project.objectOriented;

public class Extend {
    public static void main(String[] args) {
        /**
         * @extends 继承
         * 不需要写重复的功能，只需要写新增的功能，子类也是不允许书写与父类重名的字段
         *
         * 在oop术语中，我们把“父类（parent class）”称作、“超类（super class）”、“基类（base class）”，把“子类（subclass）”也称为“扩展类（extended class）”。
         *
         * 任何类，除了Object，都会继承自某个类，如果没有加“extends”的类，编译器会自动加上“extends Object”。
         *
         * java中只允许一个class继承自一个类，所以一个类有且只有一个父类，只有“Object”特殊，它没有父类。
         *
         *
         */


        /**
         * @protected
         * 继承有个特点，就是子类无法访问父类的"private"字段，和“private”方法。
         * 为了能让子类访问到父类的字段，可以把”private“换成“protected”
         * 一个protected字段和方法可以被其子类，以及子类的子类所访问
         */


        /**
         * @super
         * "super"关键字表示父类。子类访问父类的字段或方法可以使用“super.fieldName”。
         * 实际上使用“super.name”或者“this.name”,或者“name”效果都是一样的，编译器会默认定位到父类的”name“字段。
         * 注意：
         *     如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
         *     子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
         */


        /**
         * @阻止继承
         *正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承。
         * 从Java 15开始，允许使用sealed修饰class，并通过permits明确写出能够从该class继承的子类名称。
         * sealed类在Java 15中目前是预览状态，要启用它，必须使用参数--enable-preview和--source 15
         */

        /**
         * @向上转型
         * 这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。
         * 例如：
         *      Student s = new Student();
         *      Person p = new Person();
         *      Person p = new Student(); // 是被允许的
         */

        /**
         * @向下转型
         * 和向上转型相反，如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）
         * 注意：向下转型很可能会失败。失败的时候，Java虚拟机会报ClassCastException。
         *
         * @instanceof操作符，可以先判断一个实例究竟是不是某种类型
         * 从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。
         */


        /**
         * @区分继承和组合
         * 继承是is关系，组合是has关系。
         */

        /**
         * practice:
         *
         */
        PersonOfExtends p = new PersonOfExtends("小明", 12);
        Student s = new Student("小红", 20, 99);
        // TODO: 定义PrimaryStudent，从Student继承，新增grade字段:
        Student ps = new PrimaryStudentOfExtends("小军", 9, 100, 5);
        System.out.println(ps.getScore());




    }
}

class PersonOfExtends {
    protected String name;
    protected int age;

    public PersonOfExtends(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends PersonOfExtends {
    protected int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

class PrimaryStudentOfExtends extends Student{
    protected int grade;
    public PrimaryStudentOfExtends(String name,int age,int score,int grade){
        super(name,age,score);
    }

}


