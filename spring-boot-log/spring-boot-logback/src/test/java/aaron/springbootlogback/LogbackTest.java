package aaron.springbootlogback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LogbackTest {
	private final static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");

	@Test
	public void infoTest() {
		Date now = new Date();
		logger.info("Now is:" + df.format(now));
	}

	@Test
	public void debugTest() {
		Date now = new Date();
		logger.debug("Now is:" + df.format(now));
	}
}
