import java.util.TreeMap;

/**
 * @author : Nikolai Degtiarev
 * created : 29.01.26
 *
 *
 **/
/**
 * Демонстрация создания потоков с использованием лямбда-выражений в Java.
 * Лямбда-выражения предоставляют краткий синтаксис для реализации функциональных интерфейсов,
 * таких как Runnable.
 */
public class LambdaThreadDemo {
    public static void main(String[] args) {
        // Создание и запуск первого потока с использованием лямбда-выражения.
        // Этот поток выполняет цикл, выводящий числа от 0 до 6 с паузой.
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                System.out.println("Lambda task: " + i);
                try {
                    // Приостановка потока на 400 миллисекунд.
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    // Восстановление прерванного статуса потока.
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread1.start(); // Запуск потока.

        // Создание и запуск второго потока с именем "Lambda-Worker".
        // Этот поток выводит сообщение и может содержать другую логику.
        String message = "Hello from Lambda";
        Thread thread2 = new Thread(() -> {
            System.out.println("Processing: " + message);
            // Здесь может быть дополнительная логика обработки.
        }, "Lambda-Worker");
        thread2.start(); // Запуск второго потока.
    }
}
