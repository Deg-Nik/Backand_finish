/**
 * @author : Nikolai Degtiarev
 * created : 30.01.26
 *
 *
 **/
/**
 * Пример создания потока путем наследования от класса Thread.
 * Этот класс определяет собственную задачу, которую будет выполнять поток.
 */
public class MyThread extends Thread {
    private String threadName;  // Имя потока для идентификации.

    /**
     * Конструктор для создания экземпляра потока с заданным именем.
     * @param name Имя, присваиваемое потоку.
     */
    public MyThread(String name) {
        this.threadName = name;
        setName(name);      // Устанавливаем имя потока, которое полезно при отладке.
    }

    /**
     * Метод run() содержит код, который будет выполняться в потоке.
     * Этот метод вызывается после вызова start().
     */
    @Override
    public void run() {
        System.out.println(threadName + " started!");

        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + ": counter = " + i);
            try {
                // Симуляция выполнения некоторой работы.
                // Приостанавливает выполнение потока на 500 миллисекунд.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Это исключение выбрасывается, если другой поток прерывает текущий поток.
                System.out.println(threadName + " interrupted");
                // Вывод стека вызовов для отладки.
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " finished.");
    }
}


