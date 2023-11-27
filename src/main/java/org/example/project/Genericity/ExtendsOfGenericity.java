package org.example.project.Genericity;

public class ExtendsOfGenericity {
    public static void main(String[] args) {
        /**
         * @extends通配符
         *
         *
         */
        // 传入的类型是PairOfExtendsOfGenericity<Number>，实际参数类型是(Integer, Integer)。
//        int sum = PairHelper.add(new PairOfExtendsOfGenericity<Number>(123,321));
//        System.out.println(sum);
        // 但是我们直接传入Inter类型会报错，因为Pair<Integer>不是Pair<Number>的子类，因此，add(Pair<Number>)不接受参数类型Pair<Integer>。
        PairOfExtendsOfGenericity<Integer> p = new PairOfExtendsOfGenericity<>(123, 321);
        int n = add(p);
        System.out.println(n);

        /*
        有没有办法使得方法参数接受Pair<Integer>？办法是有的，这就是使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型。

        这样一来，给方法传入Pair<Integer>类型时，它符合参数Pair<? extends Number>类型。
        这种使用<? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number了。

        除了可以传入Pair<Integer>类型，我们还可以传入Pair<Double>类型，Pair<BigDecimal>类型等等，因为Double和BigDecimal都是Number的子类。
        */

        /**
         * @extends通配符的作用
         *
         * List<? extends Integer>的限制：
         * 允许调用get()方法获取Integer的引用；
         * 不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）。
         * 因此，方法参数类型List<? extends Integer>表明了该方法内部只会读取List的元素，
         * 不会修改List的元素（因为无法调用add(? extends Integer)、remove(? extends Integer)这些方法。
         * 换句话说，这是一个对参数List<? extends Integer>进行只读的方法（恶意调用set(null)除外）。
         */


        /**
         * @使用extends限定T类型
         *
         * 在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型：
         * public class Pair<T extends Number> { ... }
         * 非Number类型将无法通过编译：
         */

        /**
         * @小结
         *
         * 使用类似<? extends Number>通配符作为方法参数时表示：
         *
         *      - 方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
         *
         *      - 方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
         *
         * 即一句话总结：使用extends通配符表示可以读，不能写。
         *
         * 使用类似<T extends Number>定义泛型类时表示：
         *
         *      - 泛型类型限定为Number以及Number的子类。
         */

    }
    // Number不能接受Integer类型。
    /*
    static int add(PairOfExtendsOfGenericity<Number> p){
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    };
     */

    //  修改如下
    static int add(PairOfExtendsOfGenericity<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        /*
         这就是<? extends Number>通配符的一个重要限制：方法参数签名stFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)。
         这里唯一的例外是可以给方法参数传入null：
         */
//         p.setFirst(new Integer(first.intValue() + 100));
//         p.setLast(new Integer(last.intValue() + 100));
//         return p.getFirst().intValue() + p.getFirst().intValue();
        return first.intValue() + last.intValue();
    }


}


class PairOfExtendsOfGenericity<T> {
    private T first;
    private T last;

    public PairOfExtendsOfGenericity(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }


    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

}

class PairHelper {
    static int add(PairOfExtendsOfGenericity<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}