package lessons.lesson_01.runnable;

/**
 * @author : Nikolai Degtiarev
 * created : 29.01.26
 *
 *
 **/
// Жизненный цикл потока
/*
NEW -> RUNNABLE -> RUNNING  -> TERMINATED
           |          |
           V          V
        BLOCKED     WAITING/TIMED_WAITING
 */

/*
// 1. Состояние NEW: поток создан, но не запущен
Thread thread = new Thread(() -> { code });
// 2. Состояние RUNNABLE: Поток готов к выполнению или выполняется
thread.start();
// 3. BLOCKED: поток ждет освобождения монитора (lock)
        synchronized (object) {
            // Если монитор занят -> BLOCKED
        }
// 4. WAITING: поток ждет действия от другого потока
object.wait();
// 5. TIMED_WAITING:
Thread.sleep(300);
// 6. TERMINATED: поток завершил выполнение
 */



public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        // Создаем новый поток с помощью лямбда-выражения.
        // Поток будет просто "спать" в течение 2000 миллисекунд (2 секунд).
        Thread thread = new Thread(() -> {
            try {
                // Приостанавливаем выполнение потока на 2000 миллисекунд.
                // Это переводит поток в состояние TIMED_WAITING.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Обрабатываем исключение, если поток будет прерван во время ожидания.
                e.printStackTrace();
            }
        });

        // Выводим состояние потока перед его запуском.
        // На этом этапе поток создан, но еще не запущен.
        System.out.println("Before start: " + thread.getState());   // NEW

        // Запускаем поток. Теперь планировщик потоков может начать его выполнение.
        thread.start();
        // Сразу после запуска состояние потока становится RUNNABLE.
        System.out.println("After start: " + thread.getState());    // RUNNABLE

        // Приостанавливаем основной поток на 100 миллисекунд,
        // чтобы дать запущенному потоку время перейти в состояние сна.
        Thread.sleep(100);
        // Проверяем состояние потока, пока он "спит".
        System.out.println("While sleeping: " + thread.getState()); // TIMED_WAITING

        // Ожидаем завершения выполнения дочернего потока.
        // Основной поток будет заблокирован, пока 'thread' не завершит свою работу.
        thread.join();  // Ждем завершение

        // Выводим состояние потока после его полного завершения.
        System.out.println("After completion " + thread.getState());  // TERMINATED
    }
}

