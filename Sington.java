package lesson3;

public class Sington {
//    private  static  final Sington SINGTON =null;
//    private  Sington(){
////饿汉式
//    }
//    public  static  Sington getInstance(){
//
//        return SINGTON;
//    }
    private static Sington SINGTON=null;
    private Sington(){
        //懒汉式
    }
    public static Sington getInstance(){
        if(SINGTON==null)
            //1.分配内存空间
            //2.初始化对象
            //3.把这个对象赋值给变量引用
            SINGTON=new Sington();
        return  SINGTON;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sington s=Sington.getInstance();
                }
            }).start();
        }
    }

}
