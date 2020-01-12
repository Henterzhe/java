package lesson5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class MyTimerPool{
        // 优先级阻塞式队列，存放的元素需要实现Comparable接口
        // MyTimerTask是根据next下次执行时间比较的，优先获取next最小的
        private PriorityBlockingQueue<MyTimerTask> workQueue;
        // 执行的线程（类似固定线程池）
        private MyTimerThread[] threads;

        // 和线程池实现逻辑类似
        public MyTimerPool(int capacity, int size){
            this.threads = new MyTimerThread[capacity];
            workQueue = new PriorityBlockingQueue<>(size);
            for(int i=0; i<capacity; i++){
                threads[i] = new MyTimerThread(workQueue);
                threads[i].start();
            }
        }
        // 执行定时任务
        public void schedule(Runnable task, long delay, long period){
            workQueue.put(new MyTimerTask(task, delay, period));
            // 当前传入的任务，下次执行时间可能是最小的，所以
            // 需要通知线程，重新从阻塞队列中获取元素
            synchronized (workQueue){
                workQueue.notifyAll();
            }
        }

public static class MyTimerThread extends Thread{

    private PriorityBlockingQueue<MyTimerTask> workQueue;
    public MyTimerThread(PriorityBlockingQueue<MyTimerTask> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        try {
            while(true){
                // 阻塞式队列take()方法是阻塞式的，poll()是非阻塞式
                MyTimerTask myTimerTask = workQueue.take();
                long current = System.currentTimeMillis();
                long next = myTimerTask.next;
                if(current < next){
                    // 等待下次执行时间到了，或者被通知到
                    synchronized (workQueue){
                        workQueue.wait(next - current);
                        // put()方法是阻塞式的，offer()是非阻塞的
                        workQueue.put(myTimerTask);
                    }
                }else{
                    Date date = new Date(next);// 打印下次执行时间
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println("date="+df.format(date));

                    myTimerTask.task.run();
                    if(myTimerTask.period > 0){
                        myTimerTask.next += myTimerTask.period;
                        workQueue.put(myTimerTask);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public static class MyTimerTask implements Comparable<MyTimerTask>{

    private long next;// 下次执行时间
    private Runnable task;
    private long period;

    public MyTimerTask(Runnable task, long delay, long period) {
        this.next = System.currentTimeMillis() + delay;
        this.task = task;
        this.period = period;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return Long.compare(next, o.next);
    }
}

    public static void main(String[] args) {
        MyTimerPool pool = new MyTimerPool(3, 1000);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("明天要答辩");
            }
        }, 0, 1000);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("后天要放假");
            }
        }, 1500, 3000);

//        List<Person> list、Queue<Person> queue

//        Collections.sort(list);// Person类实现Comparable
//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return 0;
//            }
//        });
//        Arrays.sort();
    }
}

