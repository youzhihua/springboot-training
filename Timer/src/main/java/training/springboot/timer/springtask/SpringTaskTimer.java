package training.springboot.timer.springtask;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 *  Spring Task 定时器实现类
 */
@Component
public class SpringTaskTimer {

    private static final Logger log = LoggerFactory.getLogger(SpringTaskTimer.class);

    /**
     * cron 表达式，每三秒执行一次
     */
    @Scheduled(cron = "0/3 * * * * *")
    public void testCronSchedule(){
        log.warn("this is spring task ,type is cron,current time is "+ System.currentTimeMillis());
    }

    /**
     * 固定间隔执行一次
     */
    @Async
    @Scheduled(fixedRate = 4000)
    public void testFixedRateSchedule() throws InterruptedException {
        Thread.sleep(1000);
        log.warn("this is spring task ,type is fixedRate,current time is "+ System.currentTimeMillis());
    }

    /**
     * 上次任务执行完成后，再间隔固定时间执行
     */
    @Scheduled(fixedDelay = 6000)
    public void testDelaySchedule() throws InterruptedException {
        Thread.sleep(1000);
        log.warn("this is spring task ,type is fixedDelay,current time is "+ System.currentTimeMillis());
    }
}
