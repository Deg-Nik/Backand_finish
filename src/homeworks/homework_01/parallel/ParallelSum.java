package homeworks.homework_01.parallel;

/**
 * @author : Nikolai Degtiarev
 * created : 30.01.26
 *
 *
 **/
public class ParallelSum {
    public static void main(String[] args) throws InterruptedException {
        // Начало отсчета времени
        long start = System.currentTimeMillis();

        // Создаем масив для хранения сумм двух потоков
        final long[] results = new long[2]; // long[2] - два потока

        Thread tread1 = new Thread(() -> {
            long sum = 0;
            for (int i = 1; i <= 500_000; i++) {
                sum += i;
            }
            results[0] = sum;
        });

        Thread tread2 = new Thread(() -> {
            long sum = 0;
            for (int i = 500_001; i <= 1_000_000; i++) {
                sum += i;
            }
            results[1] = sum;
        });

        // Запускаем потоки
        tread1.start();
        tread2.start();

        // Дожидаемся завершения потоков
        tread1.join();
        tread2.join();

        long total = results[0] + results[1];

        // окончание подсчета времени
        long end = System.currentTimeMillis();

        System.out.println("Параллельный подсчет");
        System.out.println("Cумма подсчета = " + total);
        System.out.println("Время подсчета = " + (end - start) + " мс");
    }
}
