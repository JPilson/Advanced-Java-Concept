package Threading;

public class Threading {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        MyThreading myThreading = new MyThreading();

        Thread incrementerThread = new Thread(new Incrementer(counter, "Thread 1", 160));
        Thread incrementerThread2 = new Thread(new Incrementer(counter, "Thread 2", 100));
        Thread  thread = new Thread(() -> {

        });
        incrementerThread2.start();
        incrementerThread.start();
//        thread.start();
        for (int i = 0; i<10;i++){
            System.out.println("Main:"+i);
        }

    }
}
