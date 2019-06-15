# Spring Boot Scheduler
===

Spring 官网有对注解的解释，地址[Spring Boot Scheduler](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html)

# fixedDelay

`Execute the annotated method with a fixed period in milliseconds between the end of the last invocation and the start of the next.`

解释：
上个任务结束，到下个任务开始的固定时间间隔（毫秒单位），无论任务执行花费多久，该间隔都不受影响

# fixedRate

`Execute the annotated method with a fixed period in milliseconds between invocations.`

解释：

每次调用的间隔时间固定，基本

# cron

[在线cron表达式生成](http://cron.qqe2.com/)

``` java
@Scheduled配置参数
cron
    second, minute, hour, day of month, month, day(s) of week
    @Scheduled(cron="0 * * * * *" ) 每分钟执行一次
    @Scheduled(cron="*/10 * * * * *") 每10秒执行一次
    @Scheduled(cron="*0 0 8-10 * * *") 8点，9点，10点各执行一次
    @Scheduled(cron="0 0/30 8-10 * * *") 8点，8点半，9点，9点半，10点，10点半各执行一次
    @Scheduled(cron="0 0 9-17 * * MON-FRI") 周一到周五的每天的9点到17点各执行一次
    @Scheduled(cron="0 0 0 1 1 ?") 元旦节午夜执行一次
zone    
    时区
    @Scheduled(cron="0 * * * * *", zone="Asia/Shanghai")
fixedDelay 
    当上一个任务完成，才会执行下一个
fixedDelayString
fixedRate
    不管上一个任务完没完成，时间一到，都会执行下一个
fixedRateString
initialDelay
initialDelayString
```

# 参考
* [SpringBoot Schedule 配置](https://www.cnblogs.com/slimer/p/6222485.html)
* [理解Spring定时任务的fixedRate和fixedDelay](https://www.cnblogs.com/javahr/p/8318642.html)