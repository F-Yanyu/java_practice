package org.example.project.Annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class ProcessingAnnotation {
    public static void main(String[] args) {
        /**
         * @处理注解
         *
         * SOURCE类型的注解主要由编译器使用，因此我们一般只使用，不编写。
         * CLASS类型的注解主要由底层工具库使用，涉及到class的加载，一般我们很少用到
         * 只有RUNTIME类型的注解不但要使用，还经常需要编写。
         * 因此，我们只讨论如何读取RUNTIME类型的注解。
         *
         *
         * Java提供的使用反射API读取Annotation的方法包括：
         * 判断某个注解是否存在于Class、Field、Method或Constructor：
         *      Class.isAnnotationPresent(Class)
         *      Field.isAnnotationPresent(Class)
         *      Method.isAnnotationPresent(Class)
         *      Constructor.isAnnotationPresent(Class)
         * 例如：
         *      // 判断@Report是否存在于Person类:
         *      Person.class.inAnnotationPresent(Report.class);
         *
         * 使用反射API读取Annotation：
         *      Class.getAnnotation(Class)
         *      Field.getAnnotation(Class)
         *      Method.getAnnotation(Class)
         *      Constructor.getAnnotation(Class)
         * 例如：
         *      // 获取Person定义的@Report注解:
         *      Report report = Person.class.getAnnotation(Report.class);
         *      int type = report.type();
         *      String level = report.level();
         *
         * 使用反射API读取Annotation有两种方法。
         * 方法一是先判断Annotation是否存在，如果存在，就直接读取：
         *      Class cls = Person.class;
         *      if (cls.isAnnotationPresent(Report.class)) {
         *          Report report = cls.getAnnotation(Report.class);
         *          ...
         *      }
         * 第二种方法是直接读取Annotation，如果Annotation不存在，将返回null：
         *      Class cls = Person.class;
         *      Report report = cls.getAnnotation(Report.class);
         *      if (report != null) {
         *          ...
         *      }
         *
         * 但要读取方法参数的Annotation就比较麻烦一点，因为方法参数本身可以看成一个数组，
         *      而每个参数又可以定义多个注解，所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。例如，对于以下方法定义的注解：
         *      public void hello(@NotNull @Range(max=5) String name, @NotNull String prefix) {
         *      }
         *
         * 要读取方法参数的注解，我们先用反射获取Method实例，然后读取方法参数的所有注解：
         *      / 获取Method实例:
         *      Method m = ...
         *      // 获取所有参数的Annotation:
         *      Annotation[][] annos = m.getParameterAnnotations();
         *      // 第一个参数（索引为0）的所有Annotation:
         *      Annotation[] annosOfName = annos[0];
         *      for (Annotation anno : annosOfName) {
         *          if (anno instanceof Range r) { // @Range注解
         *              r.max();
         *          }
         *          if (anno instanceof NotNull n) { // @NotNull注解
         *              //
         *          }
         *      }
         *
         * @使用注解
         * 我们来看一个@Range注解，我们希望用它来定义一个String字段的规则：字段长度满足@Range的参数定义：
         *      @Retention(RetentionPolicy.RUNTIME)
         *      @Target(ElementType.FIELD)
         *      public @interface Range {
         *          int min() default 0;
         *          int max() default 255;
         *      }
         *
         * 在某个JavaBean中，我们可以使用该注解：
         *      public class Person {
         *          @Range(min=1, max=20)
         *          public String name;
         *
         *          @Range(max=10)
         *          public String city;
         *      }
         * 但是，定义了注解，本身对程序逻辑没有任何影响。我们必须自己编写代码来使用注解。这里，我们编写一个Person实例的检查方法，它可以检查Person实例的String字段长度是否满足@Range的定义：
         *      void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
         *          // 遍历所有Field:
         *          for (Field field : person.getClass().getFields()) {
         *              // 获取Field定义的@Range:
         *              Range range = field.getAnnotation(Range.class);
         *              // 如果@Range存在:
         *              if (range != null) {
         *                  // 获取Field的值:
         *                  Object value = field.get(person);
         *                  // 如果值是String:
         *                  if (value instanceof String s) {
         *                      // 判断值是否满足@Range的min/max:
         *                      if (s.length() < range.min() || s.length() > range.max()) {
         *                          throw new IllegalArgumentException("Invalid field: " + field.getName());
         *                      }
         *                  }
         *              }
         *          }
         *      }
         * 这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑。
         */

        PersonOfProcessingAnnotation person = new PersonOfProcessingAnnotation("Alice","New York");

        try {
            check(person);
            System.out.println("Person is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Person is invalid: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // 我们自己编写的注释检查代码
    static void check(PersonOfProcessingAnnotation person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String s) {
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min() default 0;

    int max() default 255;
}

class PersonOfProcessingAnnotation {
    @Range(min = 1, max = 20)
    public String name;
    @Range(max = 10)
    public String city;

    public PersonOfProcessingAnnotation(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
