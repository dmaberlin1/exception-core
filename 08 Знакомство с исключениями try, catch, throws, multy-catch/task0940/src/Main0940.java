import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Трай с ресурсами
 * Для примера и упрощения, вам уже даны 2 класса имплементирующие интерфейс AutoCloseable
 * Любой класс, который имплементит данный интерфейс или интерфейс Closeable, является ресурсом.
 * Так же ресурсами в JAVA являются практически всё IO/NIO и классы требующие закрытия (напр. при работе с БД)
 *
 * Задача:
 * 1. Используя конструкцию "Трай с ресурсами", ОДНОВРЕМЕННО вызвать оба этих класса и посмотреть на то, каким образом
 * ресурсы будут сначала открыты, отработаны, а затем закрыты.
 * 2. Заменить вывод сообщений в консоль, на логирование уровня INFO
 */
public class Main0940 {
    static Logger LOGGER;
    static {

        try (FileInputStream ins=new FileInputStream("08 Знакомство с исключениями try, catch, throws, multy-catch/task0930/src/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER= Logger.getLogger(Main0940.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
    public static   void main(String[] args) throws Exception {
      runMyResource();
    }
    public static void runMyResource() throws Exception {
        try (AutoCloseableResourcesFirst autoCloseableResourcesFirst=new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond autoCloseableResourcesSecond=new AutoCloseableResourcesSecond()){
            autoCloseableResourcesFirst.doSomething();
            autoCloseableResourcesFirst.close();
            autoCloseableResourcesSecond.doSomething();
            autoCloseableResourcesSecond.close();
        }
    }

}




class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
//        System.out.println("Вызов конструктора -> AutoCloseableResources_First");
        Main0940.LOGGER.log(Level.INFO,"Вызов конструктора -> AutoCloseableResources_First");

    }

    public void doSomething() {
//        System.out.println("Какой то метод -> AutoCloseableResources_First");
        Main0940.LOGGER.log(Level.INFO,"Какой то метод -> AutoCloseableResources_First");

    }

    @Override
    public void close() throws Exception {
//        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
        Main0940.LOGGER.log(Level.INFO,"ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");

    }
}


class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
//        System.out.println("Вызов конструктора -> AutoCloseableResources_Second");
        Main0940.LOGGER.log(Level.INFO,"Вызов конструктора -> AutoCloseableResources_Second");

    }

    public void doSomething() {
//        System.out.println("Какой то метод -> AutoCloseableResources_Second");
        Main0940.LOGGER.log(Level.INFO,"Какой то метод -> AutoCloseableResources_Second");

    }

    @Override
    public void close() throws Exception {
//        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
        Main0940.LOGGER.log(Level.INFO,"ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");

    }
}