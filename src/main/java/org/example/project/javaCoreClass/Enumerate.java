package org.example.project.javaCoreClass;

public class Enumerate {
    public static void main(String[] args) {
        /**
         * @enumerate(枚举)
         * 我们正常可以通过static final 来在class中定义枚举值例如：
         * class Person{
         *  public static final int Mon = 0;
         * }
         * 但是编译器无法判断每个拿来跟枚举值比较的数的合理性。
         *
         * 可以使用enum来定义枚举类。
         * 这是为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用
         */
        Weekday day = Weekday.SUN;
        System.out.println(day);
        if(day == Weekday.SAT || day == Weekday.SUN){
            System.out.println("word at home!");
        } else {
            System.out.println("word at office");
        }

        /**
         * @好处
         * - enum常量本身带有类型信息，即Weekday.SUN类型是Weekday，编译器会自动检查出类型错误。
         * - 不可能引用到非枚举的值，因为无法通过编译。
         * - 不同类型的枚举不能互相比较或者赋值，因为类型不符
         */

        /**
         * @enum类型
         * 特点：
         *      定义的enum类型总是继承自java.lang.Enum，且无法被继承；
         *      只能定义出enum的实例，而无法通过new操作符创建enum的实例；
         *      定义的每个实例都是引用类型的唯一实例；
         *      可以将enum类型用于switch语句。
         * 编译器编译出的class大概就像这样：
         *      public final class Color extends Enum { // 继承自Enum，标记为final class
         */

        /**
         * 因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：
         *  注意：判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()！
         */
        // name():返回常量名
        String s = Weekday.SUN.name();
        System.out.println(s);
        // ordinal():返回定义常量的顺序，从0开始
        int a = Weekday.THU.ordinal();
        System.out.println(a);


        /**
         * @switch
         * 枚举类可以应用在switch语句中。因为枚举类天生具有类型信息和有限个枚举常量，所以比int、String类型更适合用在switch语句中
         *
         */
        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }

        /**
         * 小结
         * Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；
         *
         * 通过name()获取常量定义的字符串，注意不要使用toString()；
         *
         * 通过ordinal()返回常量定义的顺序（无实质意义）；
         *
         * 可以为enum编写构造方法、字段和方法
         *
         * enum的构造方法要声明为private，字段强烈建议声明为final；
         *
         * enum适合用在switch语句中。
         */
    }
}

//class Weekday{
//    public static final int SUN = 0;
//    public static final int MON = 1;
//    public static final int TUE = 2;
//    public static final int WED = 3;
//    public static final int THU = 4;
//    public static final int FRI = 5;
//    public static final int SAT = 6;
//}

enum Weekday{
    SUN,MON,TUE,WED,THU,FRI,SAT
}


