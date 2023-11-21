package org.example.project.javaCoreClass;

public class RecordClass {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);


        /*
         这样我们可以写出更简洁的代码；
         */
        var z = Point.of();
        var s = Point.of(123, 456);

        /**
         * @小结
         * 从Java 14开始，提供新的record关键字，可以非常方便地定义Data Class：
         * 使用record定义的是不变类；
         * 可以编写Compact Constructor对参数进行验证；
         * 可以定义静态方法。
         */
    }
}
record Point(int x, int y) {
    /*
    给Point的构造方法加上检查逻辑：
     */
    public Point{
        if(x < 0 || y < 0){
            throw new IllegalArgumentException();
        }
    }
    /*
    添加静态方法：通常是of(),用来创建Point:
     */
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}

/*
 以上定义相当于
 final class Point extends Record {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public String toString() {
        return String.format("Point[x=%s, y=%s]", x, y);
    }

    public boolean equals(Object o) {
        ...
    }
    public int hashCode() {
        ...
    }
}
 */