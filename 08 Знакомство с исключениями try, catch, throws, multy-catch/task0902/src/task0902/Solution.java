package task0902;

/* 
И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.


Requirements:
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать имя метода, вызвавшего его.
4. Для получения имени вызвавшего метода, используй метод getMethodName.*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        return Thread.currentThread().getStackTrace();


    }

    public static StackTraceElement[] method2() {
        method3();
       return Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method3() {
        method4();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method4() {
        method5();
        return Thread.currentThread().getStackTrace();
    }

    //change return - String to void
    public static void method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement elem : stackTraceElements) {
            System.out.print(elem.getLineNumber()+" ");
            System.out.println(elem.getMethodName());
        }

    }
}
