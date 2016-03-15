package cn.hyx.invoicing.system;

import org.agle4j.framework.annotation.Action;
import org.agle4j.framework.annotation.Controller;
import org.agle4j.framework.bean.Param;
import org.agle4j.framework.bean.View;
import org.agle4j.plugin.security.SecurityHelper;
import org.agle4j.plugin.security.exception.AuthcException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 处理系统请求
 * 
 * @author hanyx
 * @since
 */
@Controller
public class SystemController {

	private static final Logger LOGGER = LogManager.getLogger(SystemController.class);

	/**
	 * 进入首页界面
	 */
	@Action("get:/")
	public View index() {
		return new View("index.jsp");
	}

	/**
	 * 进入登录界面
	 */
	@Action("get:/login")
	public View login() {
		return new View("login.jsp");
	}

	/**
	 * 提交登录表单
	 */
	@Action("post:/login")
	public View loginSubmit(Param param) {
		String username = param.getString("username");
		String password = param.getString("password");
		try {
			SecurityHelper.login(username, password, true);
		} catch (AuthcException e) {
			LOGGER.error("login failuer", e);
			return new View("/login");
		}
		return new View("/customer");
	}

	/**
	 * 提交注销请求
	 */
	@Action("get:/logout")
	public View logout() {
		SecurityHelper.logout();
		return new View("/");
	}

}
