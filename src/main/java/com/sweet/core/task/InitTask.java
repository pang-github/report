package com.sweet.core.task;


import com.sweet.modular.taskQuartz.entity.TaskQuartz;
import com.sweet.modular.taskQuartz.service.TaskQuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


//@Component
@Slf4j
public class InitTask implements ApplicationRunner {

	@Autowired
    private Scheduler scheduler;

	@Autowired
	private TaskQuartzService quartzService;

	@Override
    public void run(ApplicationArguments var) throws Exception{

    		log.info("初始化测试任务");
    		TaskQuartz quartz = new TaskQuartz();
            quartz.setJobGroup("test");
            quartz.setJobName("测试");
    		quartz.setDescription("测试任务,每59秒后台打印数据");
    		quartz.setJobClassName("com.sweet.core.task.job.DemoJob");
    		quartz.setCronExpression("0/10 * * * * ?");

   	        Class cls = Class.forName(quartz.getJobClassName()) ;
   	        cls.newInstance();
   	        //构建job信息
   	        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(), quartz.getJobGroup()).withDescription(quartz.getDescription()).build();
   	        //添加JobDataMap数据
   	        job.getJobDataMap().put("blog", "https://rstyro.github.io/blog/");


   	        // 触发时间点
   	        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
   	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
   	                .startNow().withSchedule(cronScheduleBuilder).build();
   	        //交由Scheduler安排触发
   	        scheduler.scheduleJob(job, trigger);
            TriggerKey triggerKey = TriggerKey.triggerKey(quartz.getJobName(), quartz.getJobGroup());
            Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
            quartz.setJobStatus(JobStatus.RUN.getStatus());
//			quartzService.save(new Quartz());

    }

}