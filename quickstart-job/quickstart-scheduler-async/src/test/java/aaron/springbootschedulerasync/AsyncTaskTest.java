package aaron.springbootschedulerasync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aaron.springbootschedulerasync.config.AsyncConfig;
import aaron.springbootschedulerasync.task.AsyncTask;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AsyncConfig.class) // 要声明@EnableASync
public class AsyncTaskTest {

	@Autowired
	AsyncTask asyncTask;

	@Test
	public void AsyncTest() throws InterruptedException {
		if (asyncTask != null) {
			asyncTask.doSomeHeavyBackgroundTask(4000);
			asyncTask.printLog();
			Thread.sleep(5000);
		}
	}
}
