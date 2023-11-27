package org.example.project.Genericity;

public class TypeErasure {
    public static void main(String[] args) {
        /**
         * @擦拭法（Type Erasure）
         * 所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。
         *
         * Java使用擦拭法实现泛型，导致了：
         *      编译器把类型<T>视为Object；
         *      编译器根据<T>实现安全的强制转型。
         *
         * 局限性：
         *      <T>不能是基本类型
         *          Object类型无法持有基本类型
         *      无法取得带泛型的Class。
         *          因为T是Object，我们对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class。
         *      无法判断带泛型的类型：
         *          原因和前面一样，并不存在Pair<String>.class，而是只有唯一的Pair.class。
         *      不能实例化T类型：
         *          要实例化T类型，我们必须借助额外的Class<T>参数：
         *              public class Pair<T> {
         *                  private T first;
         *                  private T last;
         *                  public Pair(Class<T> clazz) {
         *                      first = clazz.newInstance();
         *                      last = clazz.newInstance();
         *                  }
         *              }
         *          上述代码借助Class<T>参数并通过反射来实例化T类型，使用的时候，也必须传入Class<T>。例如：
         *              Pair<String> pair = new Pair<>(String.class);
         *          因为传入了Class<String>的实例，所以我们借助String.class就可以实例化String类型。
         *
         * 不恰当的覆写方法
         *
         * 泛型继承
         *      一个类可以继承自一个泛型类。
         *      public class IntPair extends Pair<Integer> {
         *      }
         *      使用的时候，因为子类IntPair并没有泛型类型，所以，正常使用即可：
         *
         * @小结
         * Java的泛型是采用擦拭法实现的；
         *
         * 擦拭法决定了泛型<T>：
         *
         * 不能是基本类型，例如：int；
         * 不能获取带泛型类型的Class，例如：Pair<String>.class；
         * 不能判断带泛型类型的类型，例如：x instanceof Pair<String>；
         * 不能实例化T类型，例如：new T()。
         * 泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；
         *
         * 子类可以获取父类的泛型类型<T>。
         */
    }
}
