package org.example.project.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallingMethod {
    public static void main(String[] args) throws NoSuchMethodException {
        /**
         * 通过Class实例获取所有的Method信息,Class类提供了一下几种方法来获取Method：
         *      - Method getMethod(name,Class...):获取某个public的Method（包括父类）
         *      - Method getDeclaredMethod(name,Class...):获取当前类的某个Method（不包括父类）
         *      - Method[] getMethods():获取所有public的Method（包括父类）
         *      - Method[] getDeclaredMethods():获取当前类的所有Method（不包括父类）
         *
         * 一个Method对象包含一个方法的所有信息：
         *      - getName():返回方法名称，例如："getScore"；
         *      - getReturnType():返回方法返回值类型，也是一个Class实例，例如：String.class；
         *      - getParameterTypes():返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
         *      - getModifiers():返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
         */
        Class c = StudentOfCallingMethod.class;
        // 获取public方法getScore，参数为String:
        System.out.println(c.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(c.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(c.getDeclaredMethod("getGrade", int.class));

        /**
         * @调用方法
         * 当我们获取到一个Method对象时，就可以对他进行调用。我们以下面的代码为例：
         */
        String s = "Hello World";
        String r = s.substring(6); // World
        // 使用反射来调用subString方法：
        Method m = String.class.getMethod("substring", int.class);
        try {
            // 对Method实例调用invoke(调用)就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。
            String r2 = (String) m.invoke(s, 6); // World
            System.out.println("通过Mehtod调用String.substring.invoke:"+r2);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("not Target");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        /**
         * @调用静态方法
         * 如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。
         */

        /**
         * @调用非public方法
         * 为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：
         */

        /**
         * @多态
         * 使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。
         */

        /**
         * @小结
         * Java的反射API提供的Method对象封装了方法的所有信息：
         * 通过Class实例的方法可以获取Method实例：getMethod()，getMethods()，getDeclaredMethod()，getDeclaredMethods()；
         * 通过Method实例可以获取方法信息：getName()，getReturnType()，getParameterTypes()，getModifiers()；
         * 通过Method实例可以调用某个对象的方法：Object invoke(Object instance, Object... parameters)；
         * 通过设置setAccessible(true)来访问非public方法；
         * 通过反射调用方法时，仍然遵循多态原则。
         */
    }
}

class PersonOfCallingMethod {
    public String getName() {
        return "Person";
    }
}

class StudentOfCallingMethod extends PersonOfCallingMethod {
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }
}
