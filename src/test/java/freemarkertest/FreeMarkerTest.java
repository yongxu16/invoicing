package freemarkertest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.agle4j.framework.utils.FreeMarkerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import freemarkertest.bean.Notice;

public class FreeMarkerTest {

	private static final Logger LOGGER = LogManager.getLogger(FreeMarkerTest.class) ;
	public void testFreemarker() {
		Notice notice = new Notice();
		notice.setRecipient("张三");
		notice.setPublisher("系统管理员");
		notice.setContent("这是通知内容，请记住。\n不要问我是谁！");
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		notice.setDateTime(df.format(new Date()));
		
		Map<String, Notice> dataMap = new HashMap<>();
		dataMap.put("data", notice);
		
		String templateName = "Notice.ftl";
		String content = FreeMarkerUtil.buildContent(templateName, dataMap);
		
		LOGGER.debug(content);
	}
}
