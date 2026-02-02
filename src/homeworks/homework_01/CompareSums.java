package homeworks.homework_01;

import homeworks.homework_01.consistently.ConsistentlySum;
import homeworks.homework_01.parallel.ParallelSum;

/**
 * @author : Nikolai Degtiarev
 * created : 02.02.26
 *
 *
 **/
public class CompareSums {
    public static void main(String[] args) throws InterruptedException {
        Result consistently = ConsistentlySum.calculate();
        Result parallel = ParallelSum.calculate();

        System.out.println("=== Сравнение способов ===");
        System.out.println("Последовательно: сумма = " + consistently.sum + ", время выполнения = " + consistently.time + " мс");
        System.out.println("Параллельно: сумма = " + parallel.sum + ", время выполнения = " + parallel.time + " мс");
    }
}
