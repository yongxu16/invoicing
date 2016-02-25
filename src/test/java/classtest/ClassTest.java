package classtest;

import java.util.Arrays;

import org.agle4j.framework.annotation.Controller;
import org.agle4j.framework.annotation.Service;
import org.junit.Test;

import proxy.BookServiceImpl;
import proxy.IBookService;
import cn.hyx.invoicing.customer.controler.CustmoerController;
import cn.hyx.invoicing.customer.entity.Customer;

public class ClassTest {

	/**
	 * 是否是父类（或接口）的所有子类（或实现类）
	 */
	@Test
	public void isAssignableFromTest() {
		boolean bool1 = IBookService.class.isAssignableFrom(BookServiceImpl.class) ; // true
		boolean bool2 = BookServiceImpl.class.isAssignableFrom(IBookService.class) ; // false
		boolean bool3 = BookServiceImpl.class.isAssignableFrom(Customer.class) ;
		System.out.println(bool1);
		System.out.println(bool2);
		System.out.println(bool3);
	}
	
	/**
	 * 判断带有某注解的所有类
	 */
	@Test
	public void isAnnotationPresent() {
		boolean bool1 = CustmoerController.class.isAnnotationPresent(Controller.class) ; // true
		boolean bool2 = CustmoerController.class.isAnnotationPresent(Service.class) ; // false
		
		System.out.println(bool1);
		System.out.println(bool2);
	}
	
	@Test
	public void testArgs() {
		say();
		say("hello");
		say("hello world !");
	}
	
	private void say(String...strings) {
		System.out.println("say: " +Arrays.toString(strings));
	}
}
