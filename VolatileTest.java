package lesson3;

public class VolatileTest {
    private static volatile int N;
    public static synchronized void increment(){
        //1.从主内存获取N
        //2.N=N+1
        //3.把N写回主内存
        N++;
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <100 ; j++) {
                        increment();
                        if(N==100){
                            System.out.println("=="+N);
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(N);
    }
}
