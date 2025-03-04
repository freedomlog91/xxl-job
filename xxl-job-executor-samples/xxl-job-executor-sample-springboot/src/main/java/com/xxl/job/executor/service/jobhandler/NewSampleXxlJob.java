package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.enums.JobStatusEnum;
import com.xxl.job.core.handler.annotation.NewXxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: free
 * @Date: 2023/4/20 16:12
 */
@Component
@Slf4j
public class NewSampleXxlJob {

    @NewXxlJob(value = "newDemoJobHandler" ,status = JobStatusEnum.STOP,desc = "新注解定时任务测试" ,cron = "0/10 * * * * ?")
    public void newDemoJobHandler() throws Exception {
        log.info("新注册定时任务执行开始==============");
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }

    @NewXxlJob(value = "TaskJob",cron="0 0/10 * * * ?",desc = "TaskJob测试定时任务")
    public void hello2(String executorParam){
        log.info("整合xxl-job 打印日志:{}",executorParam);
    }
}
