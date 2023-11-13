package org.example.project.processControl;

public class DoWhileClass {
    public static void main(String[] args) {
        // do while循环会至少循环一次。
        // 1到100的求和
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            i++;
        } while (i<100);

        System.out.println("sum:"+sum);
    }
}
