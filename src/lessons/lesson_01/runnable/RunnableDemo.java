package lessons.lesson_01.runnable;

/**
 * @author : Nikolai Degtiarev
 * created : 29.01.26
 *
 *
 **/


/**
 * Демонстрация создания потоков с использованием интерфейса Runnable.
 * Это предпочтительный способ создания потоков, так как он позволяет
 * классу наследовать другой класс, кроме Thread.
 */
public class RunnableDemo {
    public static void main(String[] args) {
        // Способ 1: Создание объекта Thread и передача ему экземпляра Runnable.
        // Потоку будет присвоено имя по умолчанию (например, "Thread-0").
        Thread thread1 = new Thread(new TaskProcessor("Data-Processing", 5));
        thread1.start(); // Запуск потока.

        // Способ 2: Создание потока с явно заданным именем.
        // Это полезно для отладки и мониторинга.
        Thread thread2 = new Thread(
                new TaskProcessor("File-Upload", 3),
                "Upload-Thread" // Имя этого потока.
        );
        thread2.start(); // Запуск второго потока.
    }
}
