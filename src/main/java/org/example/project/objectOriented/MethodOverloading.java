package org.example.project.objectOriented;

public class MethodOverloading {
    public static void main(String[] args){
        /**
         * @methodOverLoad方法重载
         * 在一个类中有多个相同名称的方法，只有参数不同，把这一组方法叫做方法重载。
         *
         * 重载方法的返回值类型应该相同。
         */

        // 下面拿String.indexOf();
        String s = "Test string";
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);


        /**
         * practice:
         *
         */

        PersonOfMethodOverLoad ming = new PersonOfMethodOverLoad();
        PersonOfMethodOverLoad hong = new PersonOfMethodOverLoad();
        ming.setName("Xiao Ming");
        // TODO: 给Person增加重载方法setName(String, String):
        hong.setName("Xiao", "Hong");
        System.out.println(ming.getName());
        System.out.println(hong.getName());
    }
}

class PersonOfMethodOverLoad {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name,String name1){
        this.name = name + name1;
    }
}

