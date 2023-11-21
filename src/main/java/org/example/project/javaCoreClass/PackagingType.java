package org.example.project.javaCoreClass;

public class PackagingType {
    public static void main(String[] args){
        /**
         * java的数据类型分为两种
         * 基本数据类型：byte,short,int,long,float,double,boolean,char
         * 引用类型：所有的class和interface
         *
         * 引用类型可以赋值为null，表示空，但基本烈性不能赋值为null
         * String s = null;
         * int a = null;// compile error!
         */

        /**
         * 想要把int基本类型变成一个引用类型，我们可以定义一个Integer类，
         * 它只包含一个实例字段int，这样，Integer类就可以视为int的包装类（Wrapper Class）：
         */
        Integer a = null;
        Integer n2 = new Integer(99);
        // 定义好了Integer类，我们就可以把int和Integer互相转换：
        int n3 = n2.intValue();
        System.out.println(n3);

        /*
        实际上，因为包装类型非常有用，Java核心库为每种基本类型都提供了对应的包装类型：
         */

        /**
         * @Auto-Boxing(自动装箱）
         * 因为int和integer之间可以相互转换，所以，java编辑器可以帮助我们自动在int和integer之间进行转型：
         * Integer n = 100; // 编辑器会自动使用Integer.valueOf(int)
         * int x = n; // 编辑器会自动使用Integer.intValue();
         * 这种直接把int变为integer的赋值写法叫做”自动装箱“，翻过俩叫“自动拆箱”（Auto-UnBoxing）
         *
         *
         */

        /**
         * @不变类
         * 所有的包装类都是不变类，对两个Integer实例进行比较，绝对不能使用‘==’，因为Integer是引用类型，要使用equals()比较。
         */

        /**
         * @静态工厂方法
         * 我们把能创建”新“对象的静态方法，称为静态工厂方法。Integer.valueOf()就是静态工厂方法。
         *  创建新对象时，优先选用静态工厂方法而不是new操作符。
         */

        /**
         * @进制转换
         * Integer类本身还提供了大量方法，例如，最常用的静态方法parseInt()可以把字符串解析成一个整数：
         * Integer还可以把整数格式化为指定进制的字符串：
         * Integer还可以把整数格式化为指定进制的字符串：
         */

        int as = Integer.parseInt("100");
        int an = Integer.parseInt("1000",16);
        System.out.println(an);

        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

        /**
         * @包装类型的静态变量
         * // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
         * Boolean t = Boolean.TRUE;
         * Boolean f = Boolean.FALSE;
         * // int可表示的最大/最小值:
         * int max = Integer.MAX_VALUE; // 2147483647
         * int min = Integer.MIN_VALUE; // -2147483648
         * // long类型占用的bit和byte数量:
         * int sizeOfLong = Long.SIZE; // 64 (bits)
         * int bytesOfLong = Long.BYTES; // 8 (bytes)
         */

        /**
         * 所有的整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型：
         * // 向上转型为Number:
         * Number num = new Integer(999);
         * // 获取byte, int, long, float, double:
         * byte b = num.byteValue();
         * int n = num.intValue();
         * long ln = num.longValue();
         * float f = num.floatValue();
         * double d = num.doubleValue();
         */


        /**
         * @处理无符号整形
         * 在Java中，并没有无符号整型（Unsigned）的基本数据类型。byte、short、int和long都是带符号整型，最高位是符号位。而C语言则提供了CPU支持的全部数据类型，包括无符号整型。
         * 无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
         *
         * 例如，byte是有符号整型，范围是-128~+127，但如果把byte看作无符号整型，它的范围就是0~255。我们把一个负的byte按无符号整型转换为int：
         *  byte x = -1;
         *  byte y = 127;
         *  System.out.println(Byte.toUnsignedInt(x)); // 255
         *  System.out.println(Byte.toUnsignedInt(y)); // 127
         *  因为byte的-1的二进制表示是11111111，以无符号整型转换后的int就是255。
         * 类似的，可以把一个short按unsigned转换为int，把一个int按unsigned转换为long。
         */
    }
}

//class Integer{
//    private int value;
//    public Integer(int value){
//        this.value = value;
//    }
//    public int intValue(){
//        return value;
//    }
//}