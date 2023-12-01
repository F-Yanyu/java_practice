package org.example.project.Collection;

import java.util.List;
import java.util.Objects;

public class WriteEquals {
    public static void main(String[] args) {
        /**
         * 编写equals
         *
         * List提供boolean contains(Object o)方法来判断List是否包含某个指定元素
         *      contains是通过equals来判断数组中的元素和你指定的元素是否相等的。
         * int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1。
         *
         * 要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到
         */
        List a = List.of("A", "B", "c");
        // contains
        System.out.println(a.contains("A"));// true
        System.out.println(a.contains("a"));// false
        // indexOf
        System.out.println(a.indexOf("c"));// 2
        System.out.println(a.indexOf("C"));// -1

        List<PersonOfWriteEquals> person = List.of(
                new PersonOfWriteEquals("fu"),
                new PersonOfWriteEquals("yan"),
                new PersonOfWriteEquals("yu")
        );
        System.out.println(person.contains(new PersonOfWriteEquals("fu"))); // false
        /*
        因为PersonOfWriteEquals类没有覆写contains方法。

        因此，我们总结一下equals()方法的正确编写方法：

        先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
        用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
        对引用类型用Objects.equals()比较，对基本类型直接用==比较。
         */


        /**
         * 练习
         * 给Person类增加equals方法，使得调用indexOf()方法返回正常：
         */
        List<Person2OfWriteEquals> list = List.of(
                new Person2OfWriteEquals("Xiao", "Ming", 18),
                new Person2OfWriteEquals("Xiao", "Hong", 25),
                new Person2OfWriteEquals("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person2OfWriteEquals("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");

        /**
         * @小结
         * 在List中查找元素时，List的实现类通过元素的equals()方法比较两个元素是否相等，因此，放入的元素必须正确覆写equals()方法，Java标准库提供的String、Integer等已经覆写了equals()方法；
         * 编写equals()方法可借助Objects.equals()判断。
         * 如果不在List中查找元素，就不必覆写equals()方法。
         */
    }
}


class PersonOfWriteEquals {
    private String name;

    public PersonOfWriteEquals(String name) {
        this.name = name;
    }
}

// 覆写equals
class Person2OfWriteEquals{
    String firstName;
    String lastName;
    int age;

    public Person2OfWriteEquals(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // 覆写equals方法，使得List类中可以查找元素。
    public boolean equals(Object o){
        if(o instanceof Person2OfWriteEquals p){
            return Objects.equals(this.firstName,p.firstName) && Objects.equals(this.lastName,p.lastName) && this.age == p.age;
        }
        return false;
    }
}

