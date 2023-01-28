package Threading;

public class Counter {
    private int count = 0;

    public synchronized void increment(int value) {
        count = count + value;
    }
    public synchronized int getCount(){
        return count;
    }
}
