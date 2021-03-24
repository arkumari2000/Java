public class threadPriority extends Thread{
    public void run(){
        System.out.println("the priority of"+Thread.currentThread().getName()+"current running thread is:"+Thread.currentThread().getPriority());
    }
    public static void main(String[] args){
        threadPriority t1 = new threadPriority();
        threadPriority t2 = new threadPriority();
        threadPriority t3 = new threadPriority();

        System.out.println("Before prioritizing:");
        System.out.println("the priority of t1 thread is:"+t1.getPriority());
        System.out.println("the priority of t2 thread is:"+t2.getPriority());
        System.out.println("the priority of t3 thread is:"+t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(8);
        t3.setPriority(4);

        t1.start();
        t2.start();
        t3.start();
    }
    
}
