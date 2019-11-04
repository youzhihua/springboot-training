package training.springboot.timer.javatimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Java timer实现定时器
 */
public class JavaTimer {
    /*public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            //用于自定义定时器执行的方法
            @Override
            public void run() {
                System.out.println("this is java timer, current time is " + System.currentTimeMillis());
            }
        };

        Timer timer = new Timer();
        *//**
         * timerTask:自定义的TimerTask
         * delay:程序运行后，延时多久启动，单位ms
         * period:每次任务执行间隔，单位ms
         *//*
        timer.schedule(timerTask,10000,1000);
    }*/
}
