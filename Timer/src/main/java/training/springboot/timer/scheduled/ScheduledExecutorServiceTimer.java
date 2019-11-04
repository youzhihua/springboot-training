package training.springboot.timer.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 实现的定时器
 */
public class ScheduledExecutorServiceTimer {

    public static void main(String[] args) {
        //新建一个scheduledExecutorService，线程池初始化大小为5
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        /**
         * 参数1：runnable,自定义的run方法是定时任务要执行的方法
         * 参数2：initialDelay,初始化后，延迟多久执行
         * 参数3：period,定时任务的执行周期
         * 参数4：timeUnit，initialDelay和period的时间单位，有毫秒、秒、分钟等等
         */
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is ScheduledExecutorService timer, current time is " + System.currentTimeMillis());
            }
        },10000,3000, TimeUnit.MILLISECONDS);
    }

}
