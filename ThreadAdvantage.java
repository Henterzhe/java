package leeson1;

public class ThreadAdvantage {
    private static  final long NUM =1000000000;
    //不是线程越多越好,一般使用CPU的核数效率比较高
    private  static final int COUNT2=Runtime.
            getRuntime().availableProcessors();
    private  static final int COUNT=2;
    public static void  serial(){
        for (int i = 0; i <NUM ; i++) {
            i++;
        }
    }
    public static void parallel(){
        for (int i = 0; i <COUNT ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                     serial();
                }
            }).start();
        }
    }
    public static void main(String[] args) {
        long start1=System.currentTimeMillis();
        for (int i = 0; i <COUNT ; i++) {
            serial();
        }
        long end1=System.currentTimeMillis();
        System.out.println("串行："+(end1-start1)+"毫秒");
        long start2=System.currentTimeMillis();
        parallel();
        //debug方式启动，等待活跃线程数为1，再向下执行
        while (Thread.activeCount()>1)
            Thread.yield();
        long end2=System.currentTimeMillis();
        System.out.println("并行："+(end2-start2)+"毫秒");

    }
}
