package leeson1;

import java.util.Date;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        //日期类：1970-01-01 00:00:00 到当前时间经历的毫秒数
//        Date date=new Date();
//        long current =date.getTime();
//        long c=System.currentTimeMillis();
        Thread.sleep(5000);//作用是在main线程
        Thread t=new   Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <100000 ; i++) {
                        System.out.println(i);
                        Thread.sleep(1000);//作用在new的线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 所有非守护线程都结束，进程才结束
       // t.setDaemon(true);
        t.start();
        Thread.sleep(3000);
        System.out.println("main");
    }
}
