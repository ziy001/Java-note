package ziy.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午8:24 2020/12/7
 * @description TODO:
 * @className Main
 */
public class Main {
    public static void main(String[] args) throws SchedulerException {
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //创建一个JobDetail进行任务封装
        JobDetail jobDetail = JobBuilder.newJob(OneJob.class)
                .build();
        //创建触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger - 1", "group - 1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(60)
                        .repeatForever())
                .startNow()
                .build();
        //将任务与任务调度进行关联
        scheduler.scheduleJob(jobDetail, trigger);
        //开始调度
        scheduler.start();
    }
}
