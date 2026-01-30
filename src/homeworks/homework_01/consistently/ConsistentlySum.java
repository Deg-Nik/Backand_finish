package homeworks.homework_01.consistently;

/**
 * @author : Nikolai Degtiarev
 * created : 30.01.26
 *
 *
 **/
public class ConsistentlySum {
    public static void main(String[] args) {
        // Cоздаем начало отсчета времени
        long start = System.currentTimeMillis();

        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;
        }
        // Cоздаем конец отсчета времени
        long end = System.currentTimeMillis();

        System.out.println("Последовательный подсчет");
        System.out.println("Сумма чисел = " + sum);
        System.out.println("Время выполнения = " + (end - start) + " мс");
    }
}
