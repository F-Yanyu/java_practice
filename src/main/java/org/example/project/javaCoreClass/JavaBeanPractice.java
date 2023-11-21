package org.example.project.javaCoreClass;

import java.beans.*;
public class JavaBeanPractice {
    public static void main(String[] args) throws Exception{
        /**
         * @JavaBean
         * 如果读写方法符合一下命名规范：
         * // 读方法
         * public Type getXyz()
         * // 写方法
         * public void setXyz(Type value)
         * 那么这种class就被称作JavaBean
         */

        /*
         @boolean的读方法一般为"isXyx()"
         // 读
         public boolean isXyz()
         // 写
         public void setXyz(boolean value)
         */

        /**
         * 我们一般把一组对应的读方法（getter)和写方法（setter）称为属性（property）例如，name属性：
         * // 读
         * public String getName()
         * // 写
         * public setName(String)
         */

        /**
         * @枚举JavaBean属性
         * 要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector：
         * 运行上述代码，可以列出所有的属性，以及对应的读写方法。注意class属性是从Object继承的getClass()方法带来的。
         */
        BeanInfo info = Introspector.getBeanInfo(Haha.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }

    }
}

class Haha{
    private String name;
    private int age; // 创建好右键点击空白处，选择Generate,getterAndSetter自动生成下边的读写方法。

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
