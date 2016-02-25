package cn.hyx.invoicing.aspect;


import java.lang.reflect.Method;

import org.agle4j.framework.annotation.Aspect;
import org.agle4j.framework.annotation.Controller;
import org.agle4j.framework.proxy.AspectProxy;
import org.agle4j.framework.utils.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 拦截 Controller 所有方法
 * @author hyx
 *
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

	private static final Logger LOG = LogManager.getLogger(ControllerAspect.class) ;
	
	private long begin ;
	
	@Override
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
		LOG.debug("--------- begin ---------");
		LOG.debug("class: {}", cls.getName());
		LOG.debug("method: {}", method.getName());
		begin = System.currentTimeMillis() ;
	}
	
	@Override
	public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
		long time = System.currentTimeMillis() - begin ;
		LOG.debug("result: {} ",JsonUtil.toJson(result));
		LOG.debug("time: {} 毫秒", time);
		LOG.debug("--------- after ---------");
	}
	
}
