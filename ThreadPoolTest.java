package lesson5;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {

        // 定制的线程池
        ExecutorService pool
                = new ThreadPoolExecutor(1,
                5, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue(Integer.MAX_VALUE),
                new ThreadPoolExecutor.AbortPolicy());

        // 单线程池
        ExecutorService single =  Executors.newSingleThreadExecutor();
        // 固定数量线程池
        ExecutorService fixed =  Executors.newFixedThreadPool(2);
        // 可缓存的线程池
        ExecutorService cached =  Executors.newCachedThreadPool();
        // 定时任务的线程池
        ExecutorService scheduled =  Executors.newScheduledThreadPool(3);
    }
}
