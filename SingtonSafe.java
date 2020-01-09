package lesson3;

public class SingtonSafe {
    public static  synchronized void   test() {
        //代码y
        System.out.println("OK");//锁的是当前类
    }
    public synchronized  void test2(){
        //代码行z
        System.out.println("OK");//锁的对象是this
    }
    private static SingtonSafe SINGTON_SAFE =null;
    private SingtonSafe(){


    }
    public  static synchronized SingtonSafe getInstance(){
        if(SINGTON_SAFE==null){
            SINGTON_SAFE=new SingtonSafe();
        }
        return SINGTON_SAFE;

    }
}
