package ziy.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.TimeUnit;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午4:36 2020/12/8
 * @description TODO:
 * @className OneJob
 */
public class OneJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("=== 开始运行作业 ===");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=== 结束运行作业 ===");
    }
}
