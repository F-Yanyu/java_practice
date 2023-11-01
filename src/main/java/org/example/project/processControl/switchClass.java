package org.example.project.processControl;

public class switchClass {
    public static void main(String[] args) {
        int option = 1;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Not selected");
                break;
        }
        // 不要忘写break

        // 从Java 12开始，switch语句升级为更简洁的表达式语法，使用类似模式匹配（Pattern Matching）的方法，保证只有一种路径会被执行，并且不需要break语句：
        String fruit = "apple";
        switch (fruit) {
            case "apple" -> System.out.println("Selected apple");
            case "pear" -> System.out.println("Selected pear");
            case "mango" -> {
                System.out.println("Selected mango");
                System.out.println("Good choice!");
            }
            default -> System.out.println("No fruit selected");
        }

        // 给某个变量赋值
//        int opt;
//        switch (fruit) {
//            case "apple":
//                opt = 1;
//                break;
//            case "pear":
//            case "mango":
//                opt = 2;
//                break;
//            default:
//                opt = 0;
//                break;
//        }


        // 使用新的swicth语法不但不需要break，还可以直接返回值，把上面的代码改写
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "banner" -> 2;
            default -> 3;
        };// 注意赋值语句要以;结束


        System.out.println("opt:"+opt);


        // 如果需要复杂的语句，我们也可以写很多语句，放到{...}里，然后，用yield返回一个值作为switch语句的返回值：
        String mine = "fuyanyu";
        int name = switch (mine){
            case "mayun" -> "no Name";
            case "fuyanyu" -> {
                System.out.println("yes HaHaHa");
            };
            default -> "haha";
        };
    }
}
