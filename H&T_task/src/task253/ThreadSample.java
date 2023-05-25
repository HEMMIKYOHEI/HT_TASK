package task253;

public class ThreadSample extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("Thread ID:" + Thread.currentThread().getId() + " i = " + i);
        }
    }
}
