package lesson4;

public class SequencePrint2 {
    private static String[] INFOS ={"A","B","C"};
    private static int INDEX;
    public static void main(String[] args) {
        for (int i = 0; i <INFOS.length ; i++) {
            final int j=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (INFOS){
                            while (INDEX!=j){
                                INFOS.wait();
                            }
                            System.out.print(INFOS[j]);
                            if(j==INFOS.length-1){
                                System.out.println();
                            }
                            INDEX =(INDEX+1)%INFOS.length;
                            INFOS.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
