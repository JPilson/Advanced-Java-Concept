package Threading;

public class Incrementer implements Runnable {
    private final Counter counter;
    private final String key;
    private final int limit;

    Incrementer(Counter counter, String key, int limit) {
        this.counter = counter;
        this.key = key;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.limit; i++) {
            counter.increment(i * 2);
            System.out.println("Job for " + key + " Incremented");
        }
    }
}
