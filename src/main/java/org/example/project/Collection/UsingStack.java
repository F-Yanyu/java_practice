package org.example.project.Collection;

import java.util.Deque;
import java.util.LinkedList;

public class UsingStack {
    public static void main(String[] args) {
        /**
         * @使用Stack 栈（Stack）是一种后进先出（LIFO：Last In First Out）的数据结构。
         *
         * Stack只有入栈和出栈的操作：
         *  - 把元素压栈：push(E)；
         *  - 把栈顶的元素“弹出”：pop()；
         *  - 取栈顶元素但不弹出：peek()。
         * 在Java中，我们用Deque可以实现Stack的功能：
         *  - 把元素压栈：push(E)/addFirst(E)；
         *  - 把栈顶的元素“弹出”：pop()/removeFirst()；
         *  - 取栈顶元素但不弹出：peek()/peekFirst()。
         *
         * 为什么Java的集合类没有单独的Stack接口呢？因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。
         * 当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。
         *
         * @Stack的作用
         * JVM在处理Java方法调用的时候就会通过栈这种数据结构维护方法调用的层次。因为方法调用栈有容量限制，嵌套调用过多会造成栈溢出，即引发StackOverflowError：
         * 我们再来看一个Stack的用途：对整数进行进制的转换就可以利用栈。
         *
         * @计算中缀表达式
         * 我们使用的带括号的数学表达式实际上是中缀表达式，即运算符在中间，例如：1 + 2 * (9 - 5)。这个编译过程就会用到栈。
         *
         *
         * @小结
         * 栈（Stack）是一种后进先出（LIFO）的数据结构，操作栈的元素的方法有：
         *
         * 把元素压栈：push(E)；
         * 把栈顶的元素“弹出”：pop(E)；
         * 取栈顶元素但不弹出：peek(E)。
         * 在Java中，我们用Deque可以实现Stack的功能，注意只调用push()/pop()/peek()方法，避免调用Deque的其他方法。
         *
         * 最后，不要使用遗留类Stack。
         */

        /*
         练习一
         请利用Stack把一个给定的整数转换为十六进制：
         */
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }

        /*
        练习二（进阶）
       请利用Stack把字符串中缀表达式编译为后缀表达式，然后再利用栈执行后缀表达式获得计算结果：
         */
//        String exp = "1 + 2 * (9 - 5)";
//        SuffixExpression se = compile(exp);
//        int result = se.execute();
//        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));

        /*
        练习三（进阶）
        请把带变量的中缀表达式编译为后缀表达式，执行后缀表达式时，传入变量的值并获得计算结果：
         */

//        String exp = "x + 2 * (y - 5)";
//        SuffixExpression se = compile(exp);
//        Map<String, Integer> env = Map.of("x", 1, "y", 9);
//        int result = se.execute(env);
//        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static String toHex(int n) {
        Deque<Object> deque = new LinkedList<>();
        int S = n;
        int sum = 0;
        for (int i = 0; S != 0; i++) {
            sum += 1;
            int yuResult = S % 16;
            String yuResult2 = "";
            if (yuResult > 9) {
                yuResult2 = switch (yuResult) {
                    case 10 -> "A";
                    case 11 -> "B";
                    case 12 -> "C";
                    case 13 -> "D";
                    case 14 -> "E";
                    case 15 -> "F";
                    default -> yuResult2;
                };
            }
            S = S / 16;
            if (!yuResult2.isEmpty()) {
                deque.push(yuResult2);
            } else {
                deque.push(yuResult);
            }
        }
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < sum; i++) {
            finalResult.append(deque.pop());
        }

        return finalResult.toString();
    }

    // 练习二
    static SuffixExpression compile(String exp) {
        // TODO:
        return new SuffixExpression();
    }

    // 练习三
//    static SuffixExpression compile(String exp) {
//        // TODO:
//        return new SuffixExpression();
//    }
}

// 练习二
class SuffixExpression {
    int execute() {
        // TODO:
        return 0;
    }
}

// 练习三
//class SuffixExpression {
//    int execute(Map<String, Integer> env) {
//        // TODO:
//        return 0;
//    }
//}