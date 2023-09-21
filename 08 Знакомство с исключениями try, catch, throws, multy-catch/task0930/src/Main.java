import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Логирование состояний и ошибок в работе программы.
 * Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 * Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 *
 *
 * INFO — обычно это информационные сообщения, о том, что происходит,
 * что-то вроде истории по датам: 1915 — произошло то-то, 1916 — ещё что-то.
 * DEBUG — более подробного описывает события конкретного момента.
 * Например, подробности какой-либо битвы в истории — это уровень debug." Полководец Такойтович выдвинулся со своей армией в сторону села Сёловича".
 * ERROR — сюда обычно пишут ошибки, которые происходят.
 * Ты, наверно, замечал, когда оборачиваешь что-то в try-catch, в блоке catch подставляется e.printStacktrace().
 * Он выводит запись только в консоль. С помощью логера можно отправить эту запись в логер (ха-ха), ну ты понял.
 * WARN — сюда пишут предупреждения. Например, лампочка перегрева в машине.
 * Это просто предупреждение, и лучше что-то поменять, но это ещё не поломка.
 * Вот когда машина сломается, тогда логировать будем с уровнем ERROR.
 *
 *
 *
 * Касаемо вопроса по-поводу уровней логгирования. То негласные договоренности такие:
 * Уровень INFO - просто информирование о неком событии
 * Уровень DEBUG - используется при отладке
 * Уровень WARN - сообщение об ошибке или нестандартной ситуации, которая потенциально опасна
 * Уровень ERROR - сообщение об ошибке, после которой работа программы все еще возможна
 * Уровень FATAL - сообщение об ошибке, после которой нормальная работа программы невозможна.
 * Обычно после этого работа программы прекращается.
 */
public class Main {
    static Logger LOGGER;
    static {

        try (FileInputStream ins=new FileInputStream("08 Знакомство с исключениями try, catch, throws, multy-catch/task0930/src/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER=Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        logging();
    }

    public static void logging() {
        try {
            numToZero();
            LOGGER.log(Level.INFO,"Начало main, создаем лист с типизацией Integers");
            List<Integer> ints = new ArrayList<Integer>();
            LOGGER.log(Level.INFO,"присваиваем лист Integers листу без типипзации");
            List empty = ints;
            LOGGER.log(Level.INFO,"присваиваем лист без типипзации листу строк");
            List<String> string = empty;
            LOGGER.log(Level.WARNING,"добавляем строку \"бла бла\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла бла");
            LOGGER.log(Level.WARNING,"добавляем строку \"бла 23\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла 23");
            LOGGER.log(Level.WARNING,"добавляем строку \"бла 34\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла 34");


            LOGGER.log(Level.INFO,"выводим все элементы листа с типизацией Integers в консоль");
            for (Object anInt : ints) {
                System.out.println(anInt);
            }

            LOGGER.log(Level.INFO,"Размер равен " + ints.size());
            LOGGER.log(Level.INFO,"Получим первый элемент");
            Integer integer = ints.get(0);
            LOGGER.log(Level.INFO,"выведем его в консоль");
            System.out.println(integer);

        }catch (Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
        }
    }



    private static void numToZero(Integer num) throws ArithmeticException {
        try {
            System.out.println("делим число на ноль");
            System.out.println(num / 0);
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    private static void numToZero() throws ArithmeticException {
        {
            try {
                System.out.println("делим число на ноль");
                System.out.println(544 / 0);
            } catch (ArithmeticException e) {
                throw e;
            }
        }
    }
}