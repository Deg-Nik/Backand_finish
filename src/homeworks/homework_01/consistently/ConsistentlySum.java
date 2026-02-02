package homeworks.homework_01.consistently;

import homeworks.homework_01.Result;

/**
 * @author : Nikolai Degtiarev
 * created : 30.01.26
 *
 *
 **/
public class ConsistentlySum {
    public static Result calculate() {

        // Cоздаем начало отсчета времени
        long start = System.currentTimeMillis();

        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;
        }
        // Cоздаем конец отсчета времени
        long end = System.currentTimeMillis();

        return new Result(sum, end - start);
    }
}
