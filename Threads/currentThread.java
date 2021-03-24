public class currentThread extends Thread {
    public void run(){
        System.out.println("The current runnning thread is:"+currentThread());
    }
    public static void main(String[] args){
        currentThread thread1 = new currentThread();
        currentThread thread2 = new currentThread();

        thread1.start();
        thread2.start();
    }
}
