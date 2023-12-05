package org.example.project.IO;

public class Serialization {
    public static void main(String[] args) {
        /**
         * 一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口，它的定义如下：
         *      public interface Serializable {
         *      }
         * Serializable接口没有定义任何方法，它是一个空接口。我们把这样的空接口称为“标记接口”（Marker Interface），实现了标记接口的类仅仅是给自身贴了个“标记”，并没有增加任何方法。
         *
         * @序列化
         * 把一个Java对象变为byte[]数组，需要使用ObjectOutputStream。它负责把一个Java对象写入一个字节流：
         * ByteArrayOutputStream buffer = new ByteArrayOutputStream();
         *         try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
         *             // 写入int:
         *             output.writeInt(12345);
         *             // 写入String:
         *             output.writeUTF("Hello");
         *             // 写入Object:
         *             output.writeObject(Double.valueOf(123.456));
         *         }
         *         System.out.println(Arrays.toString(buffer.toByteArray()));
         * ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object。
         *
         * @反序列化
         * 和ObjectOutputStream相反，ObjectInputStream负责从一个字节流读取Java对象：
         *      try (ObjectInputStream input = new ObjectInputStream(...)) {
         *          int n = input.readInt();
         *          String s = input.readUTF();
         *          Double d = (Double) input.readObject();
         *      }
         * 除了能读取基本类型和String类型外，调用readObject()可以直接返回一个Object对象。要把它变成一个特定类型，必须强制转型。
         *   readObject()可能抛出的异常有：
         *      - ClassNotFoundException：没有找到对应的Class；
         *      - InvalidClassException：Class不匹配。
         * 要特别注意反序列化的几个重要特点：
         * 反序列化时，由JVM直接构造出Java对象，不调用构造方法，构造方法内部的代码，在反序列化时根本不可能执行。
         *
         * @安全性
         * 因为Java的序列化机制可以导致一个实例能直接从byte[]数组创建，而不经过构造方法，因此，它存在一定的安全隐患。一个精心构造的byte[]数组被反序列化后可以执行特定的Java代码，从而导致严重的安全漏洞。
         *
         * 实际上，Java本身提供的基于对象的序列化和反序列化机制既存在安全性问题，也存在兼容性问题。更好的序列化方法是通过JSON这样的通用数据结构来实现，只输出基本类型（包括String）的内容，而不存储任何与代码相关的信息。
         *
         *
         * @小结
         * 可序列化的Java对象必须实现java.io.Serializable接口，类似Serializable这样的空接口被称为“标记接口”（Marker Interface）；
         * 反序列化时不调用构造方法，可设置serialVersionUID作为版本号（非必需）；
         * Java的序列化机制仅适用于Java，如果需要与其它语言交换数据，必须使用通用的序列化方法，例如JSON。
         */
    }
}
