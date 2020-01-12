package lesson5;

public class MyTimer {
    /**
     * 定时任务
     * @param task 任务类
     * @param delay 延迟时间，单位毫秒
     * @param period 间隔时间，单位毫秒
     */
    public void schedule(Runnable task, long delay, long period){
        new Thread(new MyTimerTask(task, delay, period)).start();
    }

    public static class MyTimerTask implements Runnable{

        private long next;// 下次执行时间
        private Runnable task;
        private long period;

        public MyTimerTask(Runnable task, long delay, long period) {
            this.task = task;
            this.next = System.currentTimeMillis() + delay;
            this.period = period;
        }

        @Override
        public void run() {
            try {
                while (true){
                    long current = System.currentTimeMillis();
                    if(current < next){
                        // 等待next-current
                        Thread.sleep(next-current);
                    }
                    // 当前时间比下次执行时间大，或相等，执行任务
                    task.run();
                    if(period > 0)
                        next += period;//间隔时间大于0，需要重复执行
                    else
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("mytimer");
            }
        }, 0, 1000);
    }

}
