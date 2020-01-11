package lesson4;
/*
* 有3个线程，分别只能打印A,B,C
* 要求：
* 打印结果是ABC，循环打印10次
*
* */

import org.omg.PortableInterceptor.INACTIVE;

public class SequencePrint {
    private static volatile String INDEX="A";

    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Object o3=new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <10 ; i++) {
                        synchronized (o1){
                            while (!INDEX.equals("A")){
                                o1.wait();
                            }
                            System.out.print("A");
                            INDEX="B";
                            o2.notify();

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <10 ; i++) {
                        synchronized (o2){
                            while (!INDEX.equals("B")){
                                o2.wait();
                            }
                            System.out.print("B");
                            INDEX="C";
                            o3.notify();

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <10 ; i++) {
                        synchronized (o3){
                            while (!INDEX.equals("C")){
                                o3.wait();
                            }
                            System.out.println("C");
                            INDEX="A";
                            o1.notify();

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
