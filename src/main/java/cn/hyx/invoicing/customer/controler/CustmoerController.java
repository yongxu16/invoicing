package cn.hyx.invoicing.customer.controler;

import java.util.List;
import java.util.Map;

import org.agle4j.framework.annotation.Action;
import org.agle4j.framework.annotation.Controller;
import org.agle4j.framework.annotation.Inject;
import org.agle4j.framework.bean.Data;
import org.agle4j.framework.bean.FileParam;
import org.agle4j.framework.bean.Param;
import org.agle4j.framework.bean.View;

import cn.hyx.invoicing.customer.entity.Customer;
import cn.hyx.invoicing.customer.service.CustomerService;

/**
 * 处理客户管理相关请求
 * @author hyx
 *
 */
@Controller
public class CustmoerController {

	@Inject
	private CustomerService customerService ;
	
	/**
	 * 进入 客户列表
	 */
	@Action("get:/customer")
	public View list() {
		List<Customer> customerList = customerService.getCustomerList() ;
		return new View("customer.jsp").addModel("customerList", customerList) ;
	}
	
	/**
	 * 显示客户基本信息
	 */
	@Action("get:/customer_show")
	public View show(Param param) {
		String id = param.getString("id") ;
		Customer customer = customerService.getCustomer(id) ;
		return new View("customer_show.jsp").addModel("customer", customer) ;
	}
	
	/**
	 * 进入 创建客户 界面
	 */
	@Action("get:/customer_create")
	public View create() {
		return new View("customer_create.jsp") ;
	}
	
	/**
	 * 处理 创建客户 请求
	 */
	@Action("post:/customer_create")
	public Data createSubmit(Param param) {
		Map<String, Object> fieldMap = param.getMap() ;
		FileParam fileparam = param.getFile("photo") ;
		boolean result = customerService.createCustomer(fieldMap, fileparam) ;
		return new Data(result) ;
	}
	
	/**
	 * 进入 编辑客户 界面
	 */
	@Action("get:/customer_edit")
	public View edit(Param param) {
		String id = param.getString("id") ;
		Customer customer = customerService.getCustomer(id) ;
		return new View("customer_edit.jsp").addModel("customer", customer) ;
	}
	
	/**
	 * 处理 编辑客户 请求
	 */
	@Action("put:/customer_edit")
	public Data editSubmit(Param param) {
		String id = param.getString("id") ;
		Map<String, Object> fieldMap = param.getMap() ;
		boolean result = customerService.updateCustomer(id, fieldMap) ;
		return new Data(result) ;
	}
	
	/**
	 * 处理 删除客户 请求
	 */
	@Action("delete:/customer_delete")
	public Data delete(Param param) {
		String id = param.getString("id") ;
		boolean result = customerService.deleteCustomer(id) ;
		return new Data(result) ;
	}
}
