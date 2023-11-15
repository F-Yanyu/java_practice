package org.example.project.objectOriented;

public class ClassPractice {
    /*
            请定义一个City类，该class具有如下字段:
            name: 名称，String类型
            latitude: 纬度，double类型
            longitude: 经度，double类型
            实例化几个City并赋值，然后打印。
    */
    public static void main(String[] args){
        City city = new City();
        city.name = "上海";
        city.latitude = 11.221;
        city.longitude = 22.222;
        System.out.print(city.name+city.latitude+city.longitude);
        city.testMain("付延余");
        System.out.print(city.name+city.latitude+city.longitude);

    }
}

class City{
    public String name;
    public double latitude;
    public double longitude;

    public void testMain(String name){
        this.name = name;
    }
}



