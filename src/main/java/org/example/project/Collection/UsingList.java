package org.example.project.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UsingList {
    public static void main(String[] args) {
        /**
         * @List
         * 在集合类中，List是最基础的一种集合：它是一种有序列表。
         * List的行为和数组几乎完全相同：List内部按照放入元素的先后顺序存放，每个元素都可以通过索引确定自己的位置，List的索引和数组一样，从0开始。
         *
         * list的特点
         *      - 使用List时，我们要关注List接口的规范。List接口允许我们添加重复的元素，即List内部的元素可以重复：
         *      - 可以添加null
         *
         * 创建List
         *      除了使用ArrayList和LinkedList，我们还可以通过List接口提供的of()方法，根据给定元素快速创建List：
         *      但是List.of()方法不接受null，传入null会抛出NullPointerException异常
         * 遍历List
         *      和数组类型一样，我们遍历一个List，完全可以使用for循环根据索引配合get(int)方法遍历：
         */

        /*
        创建List
         */
        List<Integer> list = List.of(1, 2, 4);

        /*
        遍历List
         */
        /*
         这种方法不推荐
                - 代码复杂度
                - get(int)方法只有在ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢。
         */
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List的" + i + "项是：" + list.get(i));
        }

        /*
        我们坚持使用迭代器Iterator来访问List。Iterator本身也是对象，但它是由List的实例调用Iterator()方法的时候创建的。
        Iterator对象知道如果遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高效的访问效率
            Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。
         */
        List<String> list1 = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list1.listIterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }

        /*
        并且，由于Iterator遍历是如此常用，所以，Java的for each循环本身就可以帮我们使用Iterator遍历。把上面的代码再改写如下：
         */
        for (String s : list1) {
            System.out.println(s);
        }

        /**
         * @List和Array转换
         * 把List变为Array有三种方法：
         *      第一种是调用toArray()方法直接返回一个Object[]数组：
         *          这种方法会丢失类型信息，所以实际应用很少。
         *      第二种方式是给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中：
         *      最后一种更简洁的写法是通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
         * 把Array变成List
         *      通过List.of(T...)最简单。
         *      JDK11之前的版本，可以使用Arrays.asList(T...)方法把数组转换成List.
         *
         */
        // toArray()
        List<String> list3 = List.of("fu", "yan", "yu");
        Object[] arr1 = list.toArray();
        for (Object s : arr1) {
            System.out.println(s);
        }

        // 给同Array(T[])传入一个类型相同的Array
        List<Integer> list4 = List.of(1, 2, 3);
        Integer[] arr2 = list4.toArray(new Integer[3]);
        for (Integer n : arr2) {
            System.out.println(n);
        }
        /*
        传入的数组与List的不一致，少了，List会重新创建一个新数组，并返回，多了，会自动填充为null，其实最常见的就是创建长度一样的。
         */
        List<Integer> list5 = List.of(1, 3, 4);
        Integer[] arr3 = list5.toArray(new Integer[list5.size()]);

        // 通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
        Integer[] arr4 = list5.toArray(Integer[]::new);

        /*
         通过List.of(T...)方法，把Array变成List

         要注意的是，返回的List不一定就是ArrayList或者LinkedList，因为List只是一个接口，如果我们调用List.of()，它返回的是一个只读List：
         对只读List调用add()、remove()方法会抛出UnsupportedOperationException。
         */
        Integer[] arr5 = {1, 2, 3};
        List<Integer> List6 = List.of(arr5);

        /**
         * 练习一
         * 给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字：
         */
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list7 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list7.add(i);
        }
        // 随机删除List中的一个元素:
//        int removed = list7.remove((int) (Math.random() * list7.size()));
//        int found = findMissingNumber(start, end, list7);
//        System.out.println(list7.toString());
//        System.out.println("missing number: " + found);
//        System.out.println(removed == found ? "测试成功" : "测试失败");

        /**
         * @练习二
         *
         * 增强版：和上述题目一样，但整数不再有序，试找出缺失的数字：
         */

        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list7);
        // 随机删除List中的一个元素:
        int removed = list7.remove((int) (Math.random() * list7.size()));
        int found = findMissingNumber(start, end, list7);
        System.out.println(list7.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");


        /**
         * @小结
         * List是按索引顺序访问的长度可变的有序表，优先使用ArrayList而不是LinkedList；
         *
         * 可以直接使用for each遍历List；
         *
         * List可以和Array相互转换。
         */
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list1.add(i);
        }
        list.add(null);
        int result = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list.get(i)) {
                if (result == 0) {
                    result = list1.get(i);
                }
            }
        }

        return result;
    }
}
