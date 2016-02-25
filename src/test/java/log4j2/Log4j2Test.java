package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {

	private static final Logger LOG = LogManager.getLogger(Log4j2Test.class) ;
	
	@Test
	public void testLog() {
		LOG.info("--- {} --- {} ", "java", "world");
	}
	
	@Test
	public void stringTest() {
		String str = String.format("name : %s", "hanyx") ;
		System.out.println(str);
	}
	
	@Test
	public void levelTest() {
		LOG.trace("--- {} --- {} ", "java", "world");
		LOG.info("--- {} --- {} ", "java", "world");
		LOG.debug("--- {} --- {} ", "java", "world");
		LOG.error("--- {} --- {} ", "java", "world");
	}
}
