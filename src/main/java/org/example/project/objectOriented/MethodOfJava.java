package org.example.project.objectOriented;
import java.util.Arrays;

public class MethodOfJava {
    public static void main(String[] args){
        Toy toy = new Toy();
//        toy.age = 19;// (提示是私密的)

        // 类中定义了私密的field(属性，变量),外部访问不到，
        // 这个时候就需要使用method来间接操作私密变量了。

        toy.setName("FuYanyu");
        System.out.println(toy.getName());

        /**
         * private method
         * 定义private方法的理由是内部方法是可以调用private方法的
         */
        toy.setAge(18);
        System.out.println(toy.getAge());
        toy.ageAdd();
        System.out.println(toy.getAge());// 内部调用private方法改变age的值；


        /*
        @可变参数
         设置instance中的变量使用可变参数
         完全可以把（可变参数）改写成 String[]:
            不同的是：
                传入参数要是数组：String[] = new String[]{"1","2"}
                参数类型是String[]的话，可以传入null,要是可变参数的话，无法传入null,因为传入0个参数时，接收到的实际值是一个空数组而不是null。
         */
        toy.setVarArgs("fyy");
        System.out.println(Arrays.toString(toy.names));
        String[] names = {"haha","222"};
        toy.setVarArgs(names);
        System.out.println(Arrays.toString(toy.names));
        toy.setVarArgs("hahad","xixiix");
        System.out.println(Arrays.toString(toy.names));


        /**
         * @参数绑定
         */

        /*
        基本类型
         */
        int testNum = 15;
        toy.setNum(testNum);
        System.out.println("参数绑定（基本类型）："+toy.num);
        testNum ++;
        System.out.println("参数绑定（基本类型）：（改变后）" + toy.num); // 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
        /*
        引用类型
        其中引用类型字符串不会像数组一样，因为字符串的不可变性，只是变量的指向改变了
         */
        String[] testNums = new String[]{"1","2"};
        toy.setNums(testNums);
        System.out.println("参数绑定（引用类型）："+ Arrays.toString(toy.getNums()));
        testNums[0] = "2";
        System.out.println("参数绑定（引用类型）：（改变后）" + Arrays.toString(toy.nums));


        /**
         * @practice练习
         */
        Person ming = new Person();
        ming.setName("小明");
        ming.setAge(12);
        System.out.println(ming.getAge());
    }

}

class Toy{
    private String name;
    private int age;
    public String[] names;
    public int num;
    public String[] nums;
    public void setName(String name){
        if(name == null){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip();// 去掉首尾空格。如果没有命名冲突可以省略this关键字。
    };
    public String getName(){
        return name;
    };
    public void setAge(int age){
      if(age > 100){
          throw new IllegalArgumentException("invalid age");
      }
      this.age = age;
    };
    public int getAge(){
        return age;
    };
    public void ageAdd(){
      addMethod();
    };
    private void addMethod(){
        age ++;
    };

    // 可变参数（相当于数组类型）
    public void setVarArgs(String... args){ // 完全可以把（可变参数）改写成 String[]
        names = args;
    };

    /*
    参数绑定
     */
    // 基本类型
    public int getNum(){
        return this.num;
    };
    public void setNum(int num){
        this.num = num;
    };
    // 引用类型
    public String[] getNums(){
        return this.nums;
    };
    public void setNums(String[] num){
        this.nums = num;
    }
}

class Person {
    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
