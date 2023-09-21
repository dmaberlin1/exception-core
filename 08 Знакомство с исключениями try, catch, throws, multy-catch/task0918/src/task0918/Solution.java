package task0918;

/* 
Все свои, даже исключения
Есть четыре класса MyException, MyException2, MyException3, MyException4.
Унаследуй классы так, чтобы у тебя появилось любые два checked исключения и любые два unchecked исключения.

Подсказка:
Изучи внимательно классы Exception1, Exception2, Exception3 из второй задачи этого блока.


Requirements:
1. В классе Solution должно быть 4 вложенных класса: MyException, MyException2, MyException3 и MyException4.
2. Все вложенные классы должны быть унаследованы от классов исключений.
3. Два класса из четырех должны быть checked исключениями.
4. Два класса из четырех должны быть unchecked исключениями.*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends IOException {
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }

        public MyException(String message, Throwable cause) {
            super(message, cause);
        }

        public MyException(Throwable cause) {
            super(cause);
        }
    }

    static class MyException2 extends IOException {
        /**
         * Constructs an {@code IOException} with {@code null}
         * as its error detail message.
         */
        public MyException2() {
        }

        /**
         * Constructs an {@code IOException} with the specified detail message.
         *
         * @param message The detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method)
         */
        public MyException2(String message) {
            super(message);
        }

        /**
         * Constructs an {@code IOException} with the specified detail message
         * and cause.
         *
         * <p> Note that the detail message associated with {@code cause} is
         * <i>not</i> automatically incorporated into this exception's detail
         * message.
         *
         * @param message The detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method)
         * @param cause   The cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A null value is permitted,
         *                and indicates that the cause is nonexistent or unknown.)
         * @since 1.6
         */
        public MyException2(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs an {@code IOException} with the specified cause and a
         * detail message of {@code (cause==null ? null : cause.toString())}
         * (which typically contains the class and detail message of {@code cause}).
         * This constructor is useful for IO exceptions that are little more
         * than wrappers for other throwables.
         *
         * @param cause The cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A null value is permitted,
         *              and indicates that the cause is nonexistent or unknown.)
         * @since 1.6
         */
        public MyException2(Throwable cause) {
            super(cause);
        }
    }

    static class MyException3 extends RuntimeException{
        public MyException3() {
        }

        public MyException3(String message) {
            super(message);
        }

        public MyException3(String message, Throwable cause) {
            super(message, cause);
        }

        public MyException3(Throwable cause) {
            super(cause);
        }

        public MyException3(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    static class MyException4 extends RuntimeException{
        public MyException4() {
        }

        public MyException4(String message) {
            super(message);
        }

        public MyException4(String message, Throwable cause) {
            super(message, cause);
        }

        public MyException4(Throwable cause) {
            super(cause);
        }

        public MyException4(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}

