package leeson1;

public class CreatThreatTest {
    public static void main(String[] args) {
        MyThread thread=new MyThread("我的线程");
        thread.start();//启动的子线程和主线程是同时执行的
        //一个线程只能启动依次
       // thread.run();//一直在run（）中循环，没有退出
        //while (true){ }
    }
}

class  MyThread extends  Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
  //      System.out.println(Thread.currentThread().getName());//获取到当前线程的名称
        while (true){ }
    }
}
