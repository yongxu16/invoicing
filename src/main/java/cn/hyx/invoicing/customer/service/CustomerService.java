package cn.hyx.invoicing.customer.service;

import java.util.List;
import java.util.Map;

import org.agle4j.framework.annotation.Service;
import org.agle4j.framework.annotation.Transaction;
import org.agle4j.framework.bean.FileParam;
import org.agle4j.framework.helper.ConfigHelper;
import org.agle4j.framework.helper.DatabaseHelper;
import org.agle4j.framework.helper.UploadHelper;
import org.agle4j.framework.utils.StringUtil;

import cn.hyx.invoicing.customer.entity.Customer;

/**
 * Created by hyx on 2015/12/4.
 */
@Service
public class CustomerService {

	/**
	 * 获取客户列表
	 * @param id
	 * @return
	 */
    public List<Customer> getCustomerList() {
    	String sql = "select * from customer" ;
        return DatabaseHelper.queryEntityList(Customer.class, sql) ;
    }
    
    /**
     * 获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(String id) {
    	String sql = "select * from customer where id = ?" ;
    	return DatabaseHelper.queryEntity(Customer.class, sql, id) ; 
    }
    
    /**
     * 创建客户
     * @param vo
     * @return
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
    	fieldMap.put("id", StringUtil.getUUID()) ;
    	boolean result =  DatabaseHelper.insertEntity(Customer.class, fieldMap) ;
    	if (result) {
			UploadHelper.uploadFile(ConfigHelper.getAppUploadPath(), fileParam);
		}
    	return result ;
    }
    
    /**
     * 更新客户
     * @param vo
     * @return
     */
    @Transaction
    public boolean updateCustomer(String id, Map<String, Object> fieldMap) {
    	return DatabaseHelper.updateEntity(Customer.class, id, fieldMap) ;
    }
    
    /**
     * 删除客户
     * @param id
     * @return
     */
    @Transaction
    public boolean deleteCustomer(String id) {
    	return DatabaseHelper.deleteEntity(Customer.class, id) ;
    }
}
