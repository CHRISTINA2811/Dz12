package task11;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public class Klass {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите количество секунд (для завершения введите отрицательное число): ");
            int seconds = scanner.nextInt();

            if (seconds < 0) {
                break;
            }

            executor.execute(() -> {
                try {
                    Thread.sleep(seconds * 1000);
                    System.out.println("Я спал " + seconds + " секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        scanner.close();
        System.exit(0);
    }
}

