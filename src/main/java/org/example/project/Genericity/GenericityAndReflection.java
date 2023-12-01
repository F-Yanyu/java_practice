package org.example.project.Genericity;

public class GenericityAndReflection {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        /**
         * @泛型和反射
         * Java的部分反射API也是泛型。
         *
         * 例如：
         *      Class<T>就是泛型：
         *          Class<String> clazz = String.class;
         *          String str = clazz.newInstance();
         *
         *      构造方法Constructor<T>也是泛型：
         *          Class<Integer> clazz = Integer.class;
         *          Constructor<Integer> cons = clazz.getConstructor(int.class);
         *          Integer i = cons.newInstance(123);
         *
         */

        /*
        我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：
         */
        Pair<String>[] ps = null; // ok
        //Pair<String>[] ps = new Pair<String>[2]; // compile error!

        // 不安全的使用数组引用
        // Pair<String>[] ps = (Pair<String>[]) arr;

        // 必须通过强制转型实现带泛型的数组：
        // 不安全的使用数组引用
        @SuppressWarnings("unchecked")
        Pair<String>[] ps1 = (Pair<String>[]) new Pair[2];
        // 上面的代码中，由于拿不到原始数组的引用，就只能对泛型数组ps进行操作，这种操作就是安全的。

        /*
        所以我们不能直接创建泛型数组T[]，因为擦拭后代码变为Object[]：
        // compile error:
        public class Abc<T> {
            T[] createArray() {
                return new T[5];
                }
        }

        必须借助Class<T>来创建泛型数组：
        T[] createArray(Class<T> cls) {
            return (T[]) Array.newInstance(cls, 5);
        }

         */

        /*
        我们还可以利用可变参数创建泛型数组T[]：
        public class ArrayHelper {
            @SafeVarargs
            static <T> T[] asArray(T... objs) {
                return objs;
            }
        }

        String[] ss = ArrayHelper.asArray("a", "b", "c");
        Integer[] ns = ArrayHelper.asArray(1, 2, 3);

         谨慎使用泛型可变参数
         如果仔细观察，可以发现编译器对所有可变泛型参数都会发出警告，除非确认完全没有问题，才可以用@SafeVarargs消除警告。
         */

        /*
        @小结
        部分反射API是泛型，例如：Class<T>，Constructor<T>；
        可以声明带泛型的数组，但不能直接创建带泛型的数组，必须强制转型；
        可以通过Array.newInstance(Class<T>, int)创建T[]数组，需要强制转型；
        同时使用泛型和可变参数时需要特别小心。
         */


    }
}
