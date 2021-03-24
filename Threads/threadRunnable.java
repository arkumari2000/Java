public class threadRunnable implements Runnable{
    public void run(){
        System.out.println("one thread is running successfully");
    }
    public static void main(String[] args){
        threadRunnable thread1 = new threadRunnable();
        threadRunnable thread2 = new threadRunnable();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();
    }
}
