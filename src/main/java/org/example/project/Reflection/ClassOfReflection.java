package org.example.project.Reflection;

public class ClassOfReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * @Reflection 反射
         * 由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，
         * 我们就可以通过这个Class实例获取到该实例对应的class的所有信息。
         * 这种通过Class实例获取class信息的方法称为反射（Reflection）。
         *
         * 其中获取一个class的Class实例有三种方法：
         */

        /*
        一：直接通过一个class的静态变量class获取：
         */
        Class cls1 = String.class;


        /*
        二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取。
         */
        String s = "hello";
        Class cls2 = s.getClass();


        /*
        三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
         */
        Class cls3 = Class.forName("java.lang.String");

        /**
         * @比较
         * 因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例：
         *
         */

        /**
         * @动态加载
         * VM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载。
         */

        /**
         * @小结
         * JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；
         * 获取一个class对应的Class实例后，就可以获取该class的所有信息；
         * 通过Class实例获取class信息的方法称为反射（Reflection）；
         * JVM总是动态加载class，可以在运行期根据条件来控制加载class。
         */
    }
}
