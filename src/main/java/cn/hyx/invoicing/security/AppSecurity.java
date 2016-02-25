package cn.hyx.invoicing.security;

import java.util.Set;

import org.agle4j.framework.helper.DatabaseHelper;
import org.agle4j.plugin.security.AgileSecurity;

/**
 * 应用安全控制
 * 
 * @author hanyx
 * @since
 */
public class AppSecurity implements AgileSecurity {

	public String getPassword(String username) {
		String sql = "select password from user where user_name = ?";
		return DatabaseHelper.query(sql, username);
	}

	public Set<String> getRoleNameSet(String username) {
		String sql = "select t3.role_name from user t1 inner join user_role t2 on t1.id = t2.user_id inner join role t3 on t3.id = t2.role_id where t1.user_name = ?";
		return DatabaseHelper.querySet(sql, username);
	}

	public Set<String> getPermissionNameSet(String roleName) {
		String sql = "select t3.permission_name from role t1 inner join role_permission t2 on t1.id = t2.role_id inner join permission t3 on t2.permission_id = t3.id where t1.role_name = ?";
		return DatabaseHelper.querySet(sql, roleName);
	}

}
