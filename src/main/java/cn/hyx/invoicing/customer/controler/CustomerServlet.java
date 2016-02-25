package cn.hyx.invoicing.customer.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyx.invoicing.customer.entity.Customer;
import cn.hyx.invoicing.customer.service.CustomerService;

/**
 * Created by hyx on 2015/12/4.
 */
//@WebServlet("/customer")
//public class CustomerServlet extends HttpServlet {
public class CustomerServlet {
	
	private CustomerService customerService ;
	
	public void init() throws ServletException {
		customerService = new CustomerService() ;
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList = customerService.getCustomerList() ;
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(request, response);
    }
}
