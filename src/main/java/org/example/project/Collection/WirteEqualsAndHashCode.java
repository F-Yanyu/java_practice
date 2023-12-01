package org.example.project.Collection;

import java.util.HashMap;
import java.util.Map;

public class WirteEqualsAndHashCode {
    public static void main(String[] args) {
        /**
         * @编写equals和hashCode
         *
         * hashMap
         *      - HashMap之所以能根据key直接拿到value，原因是它内部通过空间换时间的方法，用一个大数组存储所有value，并根据key直接计算出value应该存储在哪个索引：
         *
         * 因此，正确使用Map必须保证：
         *  作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
         *  作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
         *      - 如果两个对象相等，则两个对象的hashCode()必须相等；
         *      - 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
         * 即对应两个实例a和b：
         *      - 如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
         *      - 如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。
         * 上述第一条规范是正确性，必须保证实现，否则HashMap不能正常工作。
         * 而第二条如果尽量满足，则可以保证查询效率，因为不同的对象，如果返回相同的hashCode()，会造成Map内部存储冲突，使存取的效率下降。
         * 编写equals()和hashCode()遵循的原则是：
         *      - equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算。
         *      - 另外注意，对于放入HashMap的value对象，没有任何要求。
         */

        String key1 = "a";
        Map<String,Integer> map = new HashMap<>();
        map.put(key1,123);
        String key2 = new String("a");
        Integer value = map.get(key2);
        System.out.println(value); // 123
        System.out.println(key1 == key2); // false
        System.out.println(key1.equals(key2)); // true


        /**
         * @小结
         * 要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
         *
         * 一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
         *
         * 如果equals()返回true，则hashCode()返回值必须相等；
         *
         * 如果equals()返回false，则hashCode()返回值尽量不要相等。
         *
         * 实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
         */
    }
}
