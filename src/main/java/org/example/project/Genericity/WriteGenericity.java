package org.example.project.Genericity;

public class WriteGenericity {
    public static void main(String[] args) {
        /**
         * 编写泛型
         *      首先，按照某种类型，例如：String，来编写类：
         *      然后，标记所有的特定类型，这里是String：
         *      最后，把特定类型String替换为T，并申明<T>：
         *      熟练后即可直接从T开始编写。
         *
         * 静态方法
         *      编写泛型类时，要特别注意，泛型类型<T>不能用于静态方法。
         *      在static后面加<T>可以编译过，可以把T换成K,需要清楚地将静态方法的泛型类型和实例类型的泛型类型区分开。
         *
         * 多个泛型类型
         *      泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>：
         *      public class Pair<T, K> {
         *          private T first;
         *          private K last;
         *          public Pair(T first, K last) {
         *              this.first = first;
         *              this.last = last;
         *          }
         *          public T getFirst() { ... }
         *          public K getLast() { ... }
         *      }
         *
         *      使用的时候，需要指出两种类型
         *      Pair<String,int> pair = new pair<>("test",123);
         *
         * @小结
         * 编写泛型时，需要定义泛型类型<T>；
         * 静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；
         * 泛型可以同时定义多种类型，例如Map<K, V>
         */


    }
}

// 编写泛型类，可以定义多种类型
class PersonOfWriteGenericity<T,K> {
    private T name;
    private K scoreName;
    public T getName(){
        return name;
    }
    public void setName(T name){
        this.name = name;
    }

    public K getScoreName(){
        return scoreName;
    }
    public void setScoreName(K name){
        this.scoreName = name;
    }
}
