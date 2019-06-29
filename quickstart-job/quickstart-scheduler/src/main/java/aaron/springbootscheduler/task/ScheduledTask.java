package aaron.springbootscheduler.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");

	/*
	 * 固定周期（延时）
	 */
	@Scheduled(initialDelay = 3 * 1000, fixedDelay = 1 * 1000)
	public void fixedDelayTask() throws InterruptedException {
		long threadId = Thread.currentThread().getId();
		Thread.sleep(2000l);
		Date now = new Date();
		System.out.println("threadId:" + threadId + "--fixedDelayTask--Now is:" + df.format(now));
	}

	/*
	 * 固定频率
	 */
//	@Scheduled(initialDelay = 3 * 1000, fixedRate = 1 * 1000)
//	public void fixedRateTask() throws InterruptedException {
//		Thread.sleep(2000l);
//		Date now = new Date();
//
//		System.out.println("threadId:" + Thread.currentThread().getId() + "--fixedRateTask--Now is:" + df.format(now));
//	}
//
//	@Scheduled(cron = "3/1 * * * * ? ")
//	public void cornTask() throws InterruptedException {
//		Thread.sleep(2000l);
//		Date now = new Date();
//		System.out.println("threadId:"+Thread.currentThread().getId()+"--cornTask--Now is:" + df.format(now));
//	}
}
