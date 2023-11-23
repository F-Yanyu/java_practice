package org.example.project.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AccessingFields {
    public static void main(String[] args) throws NoSuchFieldException {
        /**
         * @访问字段 对任意的一个Object实例，只要我们获取了它的Class，就可以获取它的一切信息。
         * 通过Class实例获取字段信息，Class类提供了以下几个方法来获取字段：
         *      - Field getField(name):根据字段名获取某个public的field（包括父类）
         *      - Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
         *      - Field[] getFields()：获取所有public的field（包括父类）
         *      - Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
         *
         * 请看下面栗子：
         */
        Class stdClass = StudentOfAccessingField.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));

        /**
         * @一个field对象包含了一个字段的所有信息：
         *      - getName():返回字段名称，例如，”name“;
         *      - getType():返回字段类型，也是一个Class实例，例如，String.class;
         *      - getModifiers():返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
         *
         * 以String类的value字段为例，它的定义是：
         *         public final class String{
         *             private final byte[] value;
         *         }
         */
        // 我们用反射获取该字段的信息，代码如下；
        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName());// "value"
        System.out.println(f.getType());// class [B 表示byte[]类型
        int m = f.getModifiers();
        System.out.println(Modifier.isFinal(m));// true
        System.out.println(Modifier.isPublic(m));// false
        System.out.println(Modifier.isProtected(m));// false
        System.out.println(Modifier.isPrivate(m));// true
        System.out.println(Modifier.isStatic(m));// false

        /**
         * @获取字段值
         */
        Object p = new testPersonOfAccessingField("XiaoMing");
        Class c = p.getClass();
        Field fi = c.getDeclaredField("name");
        try {
            fi.setAccessible(true); // 设置访问权限为true
            Object value = fi.get(p);
            /*
            会得到一个IllegalAccessException，这是因为name被定义为一个private字段，
            正常情况下，Main类无法访问Person类的private字段。要修复错误，可以将private改为public，
            或者，在调用Object value = f.get(p);前，先写一句：f.setAccessible(true);

            setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，
            有可能阻止setAccessible(true)。例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，
            这样可以保证JVM核心库的安全。
             */
            System.out.println(value);
        } catch (IllegalAccessException e) {
            System.out.println(e);
            throw new IllegalAccessError("not get FieldValue");
        }


        /**
         * @设置字段值
         */
        try {
            fi.set(p, "Xiao Hong");
            System.out.println(((testPersonOfAccessingField) p).getName());
        } catch (IllegalAccessException e) {
            throw new IllegalAccessError("not set FieldValue");
        }

        /**
         * @小结
         * Java的反射API提供的Field类封装了字段的所有信息：
         * 通过Class实例的方法可以获取Field实例：getField()，getFields()，getDeclaredField()，getDeclaredFields()；
         * 通过Field实例可以获取字段信息：getName()，getType()，getModifiers()；
         * 通过Field实例可以读取或设置某个对象的字段，如果存在访问限制，要首先调用setAccessible(true)来访问非public字段。
         * 通过反射读写字段是一种非常规方法，它会破坏对象的封装。
         */
    }
}


class PersonOfAccessingField {
    public String name;

    public PersonOfAccessingField(String name) {
        this.name = name;
    }
}

class StudentOfAccessingField extends PersonOfAccessingField {
    public StudentOfAccessingField(String name) {
        super(name);
    }

    public int score;
    private int grade;
}


class testPersonOfAccessingField {
    private String name;

    public testPersonOfAccessingField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
