package org.example.project.objectOriented;

public class privateField {
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
    }

}

class Toy{
    private String name;
    private int age;
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
}
