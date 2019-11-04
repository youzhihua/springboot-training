package training.springboot.timer.springtask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
/**
 *  Spring Task 定时器配置类
 */
@Configuration
public class SpringTaskConfig {

    /**
     * 自定义TaskScheduler，并指定TaskScheduler的线程池大小
     * @return
     */
    @Bean
    public TaskScheduler myTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        return threadPoolTaskScheduler;
    }

}
