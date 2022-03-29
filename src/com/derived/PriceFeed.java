package com.derived;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class PriceFeed
{
    public static void main(String[] args)
    {
        JobDetail job = JobBuilder.newJob(CoinGecko.class).build();
        Trigger t = TriggerBuilder.newTrigger().withIdentity("pricefeed")
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(5).repeatForever()).build();
        try
        {
            Scheduler s = StdSchedulerFactory.getDefaultScheduler();
            s.start();
            s.scheduleJob(job, t);
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }
    }
}
