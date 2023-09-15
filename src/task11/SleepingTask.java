package task11;

import java.util.concurrent.Callable;

public  class SleepingTask implements Callable <String>{
    private final int seconds;

    public SleepingTask(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(seconds * 1000);
        return "Я спал " + seconds + " секунд";
    }
}
