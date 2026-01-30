package runnable;

/**
 * @author : Nikolai Degtiarev
 * created : 29.01.26
 *
 *
 **/


/**
 * Класс, реализующий интерфейс Runnable.
 * Экземпляры этого класса представляют собой "задачи", которые могут
 * выполняться в отдельном потоке.
 */
public class TaskProcessor implements Runnable {
    private String taskName;    // Имя задачи для идентификации.
    private int iterations;     // Количество итераций, которое должна выполнить задача.

    /**
     * Конструктор для создания задачи.
     * @param taskName Имя задачи.
     * @param iterations Количество повторений.
     */
    public TaskProcessor(String taskName, int iterations) {
        this.taskName = taskName;
        this.iterations = iterations;
    }

    /**
     * Метод run(), который содержит логику выполнения задачи.
     * Этот код будет выполняться в потоке, которому передали этот объект Runnable.
     */
    @Override
    public void run() {
        // Выводим имя потока, в котором выполняется задача.
        System.out.println(taskName + " started on thread: " + Thread.currentThread().getName());

        for (int i = 0; i <= iterations; i++) {
            System.out.println(taskName + " - iteration " + i);

            try {
                // Приостановка потока для симуляции работы.
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // Если поток прерван, восстанавливаем флаг прерывания.
                Thread.currentThread().interrupt();
                System.out.println(taskName + " was interrupted");
                // Прекращаем выполнение задачи, если она была прервана.
                return;
            }
        }

        System.out.println(taskName + " finished");
    }
}

