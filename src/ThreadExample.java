/**
 * @author : Nikolai Degtiarev
 * created : 29.01.26
 *
 *
 **/
/**
 * Главный класс для демонстрации работы кастомных потоков MyTread.
 * Он создает и запускает два экземпляра MyTread.
 */
public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread started!");

        // Создание двух экземпляров нашего кастомного класса потока.
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");

        // Запуск обоих потоков. Метод start() вызывает run() для каждого потока.
        // Потоки будут выполняться параллельно.
        thread1.start();
        thread2.start();

        // Это сообщение выведется сразу после запуска потоков,
        // не дожидаясь их завершения.
        System.out.println("Main thread finished!");
    }
}

