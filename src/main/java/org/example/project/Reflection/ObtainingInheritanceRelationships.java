package org.example.project.Reflection;

public class ObtainingInheritanceRelationships {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 当我们获取到某个Class对象时，实际上就获取到了一个类的类型：
         */

//        Class c1 = String.class;
//        String s1 = "123";
//        Class c2 = s1.getClass();
//        Class c3 = Class.forName("java.lang.String");
//
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);


        /**
         * @获取父类的Class
         * 有了Class实例我们还可以获取它的父类Class
         */
        Class c1 = Integer.class;
        Class c2 = c1.getSuperclass();
        System.out.println(c2); // class java.lang.Number
        Class c3 = c2.getSuperclass();
        System.out.println(c3); // class java.lang.Object
        System.out.println(c3.getSuperclass()); // null
        /*
        上面的打印可以看出，Integer的父类类型是Number,Number的父类类型是Object，Object的父类类型是null，除了
        Object外，其他任何非interface的class都必定存在一个父类类型。
         */

        /**
         * @获取interface
         * 由于一个类可以实现一个或多个接口，通过class我们就可以查询到实现的接口类型，例如查看Integer实现的接口：
         *
         */
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
        /*
        运行上述代码可知，Integer实现的接口有：
            java.lang.Comparable
            java.lang.constant.Constable
            java.lang.constant.ConstantDesc

        要特别注意：getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型：
        */
        Class sf = s.getSuperclass();
        Class[] sf1 = sf.getInterfaces();
        for(Class i : sf1){
            System.out.println(i);
        }
        /*
        Integer的父类是Number,Number实现的接口是interface java.io.Serializable
        此外，对所有interface的Class调用getSuperclass()返回的是null，获取接口的父接口要用getInterfaces()：
        如果一个类没有实现任何interface，那么getInterfaces()返回空数组。
        */

        /**
         * @继承关系
         * 当我们判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符：
         *      boolean isDouble = n instanceof Double; // false
         *      boolean isInteger = n instanceof Integer; // true
         *      boolean isNumber = n instanceof Number; // true
         *      boolean isSerializable = n instanceof java.io.Serializable; // true
         * 如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom()：
         *      // Integer i = ?
         *      Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
         *      // Number n = ?
         *      Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
         *      // Object o = ?
         *      Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
         *      // Integer i = ?
         *      Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
         *
         * @小结
         * 通过Class对象可以获取继承关系：
         *  Class getSuperclass()：获取父类类型；
         *  Class[] getInterfaces()：获取当前类实现的所有接口。
         * 通过Class对象的isAssignableFrom()方法可以判断一个向上转型是否可以实现。
         */
    }
}
