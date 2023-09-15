// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your cod\\\\\\\\\\\\\\\\\
import java.util.Scanner;
import java.util.concurrent.*;

public class Klass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Scanner scanner = new Scanner(System.in);
        int taskCount = 0;

        while (true) {
            System.out.print("Введите количество секунд (для завершения введите отрицательное число): ");
            int seconds = scanner.nextInt();

            if (seconds < 0) {
                break;
            }

            Future<String> futureResult = executorService.submit(new SleepingTask(seconds));
            taskCount++;

            if (futureResult.isDone()) {
                System.out.println(futureResult.get());
            }
        }

        executorService.shutdown();
        scanner.close();

        System.out.println("Количество обработанных задач каждым потоком:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("Поток " + (i % 3 + 1) + ": " + ((i / 3) + 1));
        }
    }

    public static class SleepingTask implements Callable<String> {
        private final int seconds;

        public SleepingTask(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(seconds * 1000);
            return "Я спал " + seconds + " секунд";
        }
    }}