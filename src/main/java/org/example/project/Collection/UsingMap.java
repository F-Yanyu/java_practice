package org.example.project.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingMap {
    public static void main(String[] args) {
        /**
         * 使用Map
         * 即通过一个键去查询对应的值。使用List来实现存在效率非常低的问题，因为平均需要扫描一半的元素才能确定，而Map这种键值（key-value）映射表的数据结构，作用就是能高效通过key快速查找value（元素）。
         *
         * 始终牢记：Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
         */

        // 用Map来实现根据name查询某个Student的代码如下：
        // Map也是一个接口，最常用的实现类是HashMap。
        // 如果只是想查询某个key是否存在，可以调用boolean containsKey(K key)方法。
        StudentOfUsingMap student = new StudentOfUsingMap("xiao hong",20);
        Map<String,StudentOfUsingMap> map = new HashMap<>();
        map.put("xiao hong",student);
        StudentOfUsingMap target = map.get("xiao hong");
        System.out.println(target == student);// true
        System.out.println(target.score);// 20
        StudentOfUsingMap target1 = map.get("bob");
        System.out.println(target1); // null

        /**
         * @遍历Map
         */
        //对Map来说，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合：
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 123);
        map1.put("pear", 456);
        map1.put("banana", 789);
        for (String key : map1.keySet()) {
            Integer value = map1.get(key);
            System.out.println(key + " = " + value);
        }

        // 同时遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射：
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        // 遍历Map时，不可假设输出的key是有序的！


        /**
         * @练习
         * 请编写一个根据name查找score的程序，并利用Map充当缓存，以提高查找效率：
         */
        List<StudentOfPractice> list = List.of(
                new StudentOfPractice("Bob", 78),
                new StudentOfPractice("Alice", 85),
                new StudentOfPractice("Brush", 66),
                new StudentOfPractice("Newton", 99));
        var holder = new StudentsOfPractice(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");

    }
}

class StudentOfUsingMap {
    public String name;
    public int score;
    public StudentOfUsingMap(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class StudentsOfPractice {
    List<StudentOfPractice> list;
    Map<String, Integer> cache;

    StudentsOfPractice(List<StudentOfPractice> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            Integer result = findInList(name);
            if(result != null){
                cache.put(name,result);
                score = result;
            }
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class StudentOfPractice {
    String name;
    int score;

    StudentOfPractice(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
