package org.example.project.Collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class UsingTreeMap {
    public static void main(String[] args) {
        /**
         * @使用UsingTreeMap
         * 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
         *
         * @小结
         * SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；
         *
         * 作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；
         *
         * 要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。
         */
        Map<PersonOfUsingTreeMap,Integer> map = new TreeMap<>(new Comparator<PersonOfUsingTreeMap>() {
            @Override
            public int compare(PersonOfUsingTreeMap o1, PersonOfUsingTreeMap o2) {
                if(o1.score == o2.score){
                    return 0;
                }
                return o1.score > o2.score ? -1 : 1;
            }
        });
        map.put(new PersonOfUsingTreeMap("fuyanyu",99),1);
        map.put(new PersonOfUsingTreeMap("fuyanxu",100),2);

        System.out.println(map.get(new PersonOfUsingTreeMap("fuyanyu",99)));// null,因为compare没有定义0


    }
}

class PersonOfUsingTreeMap{
    public String name;
    public int score;

    public PersonOfUsingTreeMap(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
