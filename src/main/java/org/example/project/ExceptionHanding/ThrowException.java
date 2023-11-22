package org.example.project.ExceptionHanding;

public class ThrowException {
    public static void main(String[] args) throws Exception {
        /**
         * @抛出异常
         * 当某个方法抛出了异常时，如果当前方法没有捕获异常，异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止：
         *
         */

        /**
         * @printStackTrace()
         * 通过printStackTrace()可以打印出方法的调用栈，从下往上看.
         * 每层调用均给出了源代码的行号，可直接定位。
         */
//        try {
//            process1();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /**
         * @抛出异常
         * - 为了能追踪到完整的异常栈，在构造异常的时候，把原始的Exception实例传进去，
         *      新的Exception就可以持有原始Exception信息。
         * - 代码中获取原始异常可以使用Throwable.getCause()方法。如果返回null，说明已经是“根异常”了。
         * - 在catch中抛出异常，不会影响finally的执行。JVM会先执行finally，然后抛出异常。
         */


        /**
         * @异常屏蔽
         * - 如果在执行finally语句时抛出异常，那么，catch语句的异常将不会抛出，因为只能抛出一个异常，没有被抛出的
         *      异常被叫做”被屏蔽“的异常（Suppressed Exception）。
         * - 在极少数情况下，我们需要获取所有的异常，可以使用”origin“变量保存原始异常，然后通过"Throwable.addSuppressed()",把
         *      异常添加进去，最后在finally抛出。
         *
         * - 通过Throwable.getSuppressed()可以获取所有的Suppressed Exception。
         */
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if(origin != null){
                e.addSuppressed(origin);
            }
            throw e;
        }

        /**
         * @小结
         * - 调用printStackTrace()可以打印异常的传播栈，对于调试非常有用。
         * - 捕获异常并再次抛出新的异常，应该包括原始异常信息。
         * - 通常不要在finally中抛出异常。如果在finally中抛出异常，应该原始异常加入到原有异常中。
         * 调用方式可通过Throwable.getSuppressed()获取所有添加的Suppressed Exception.
         */

    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null);
    }
}
