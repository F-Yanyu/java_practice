package org.example.project.objectOriented;

public class privateField {
    public static void main(String[] args){
        Toy toy = new Toy();
//        toy.age = 19;// (提示是私密的)
        toy.name = "付延余";
    }


    // 类中定义了私密的field(属性，变量),外部访问不到，
    // 这个时候就需要使用method来间接操作私密变量了。

}

class Toy{
    public String name;
    private int age;
}
