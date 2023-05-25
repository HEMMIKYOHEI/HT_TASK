package task253;

public class App {

	public static void main(String[] args) throws Exception {
       final int THREAD_NUM = 3;
        Thread[] threadArray = new Thread[THREAD_NUM];
 
        for ( int i = 0; i < THREAD_NUM; i++ ) {
            ThreadSample threadSample = new ThreadSample();
            threadArray[i] = threadSample;
            threadSample.start();
            // タイムラグを発生させるためにsleep
            Thread.sleep(1000);
        }
 
        try {
             for (Thread th : threadArray) {
                 th.join();
             }
             System.out.println("all thread end");
        } catch (InterruptedException e) {}
        }
}
