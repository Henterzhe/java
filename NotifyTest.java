package lesson3;

public class NotifyTest {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //（1）对NotifyTest.class对象加锁
                    synchronized (NotifyTest.class){
                        System.out.println("t1");

                        //（2）t1线程阻塞，释放NotifyTest.class对象锁
                        NotifyTest.class.wait();
                        System.out.println("t1 wait finish");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //（3）竞争NotifyTest.class对象锁
                    synchronized (NotifyTest.class){
                        //（4）通知NotifyTest.class对象，所有竞争该对象锁的线程都可以来竞争
                        //通知是在synchronized代码块退出以后再通知（NotifyTest.class.wait()+
                        //synchronized(NotfyTest.class)阻塞的线程，都可以来竞争
                        NotifyTest.class.notify();
                        System.out.println("t2");
                        Thread.sleep(1000);
                        NotifyTest.class.wait();
                        System.out.println("t2 wait finish");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
