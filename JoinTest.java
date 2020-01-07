package leeson1;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
       Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
       t.start();
       //t.join();
        // 当前线程(代码行线程：main)阻塞等待,直到t线程执行完毕
        t.join(300);
        //当前线程(代码行线程：main)阻塞等待,直到t线程执行完毕,或者给定时间已经到了（两者的最小值）
        System.out.println("main");
    }
}
