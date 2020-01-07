package leeson1;

public class CreatRunnableTest {
    public static void main(String[] args) {
        Thread t=new Thread(
        new MyRunnable(),"MyRunable");
        t.start();
        System.out.println("main方法中："+Thread.currentThread().getName());
    }
}
class MyRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println("MyRunable方法中："+Thread.currentThread().getName());
    }
}