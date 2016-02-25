package stringtest;

import org.junit.Test;

import cn.hyx.invoicing.customer.entity.Customer;

public class StringDemo {

	@Test
	public void testStringChar29() {
		String str = String.valueOf((char)29) ;
		String str1 = "hello" + str + "world" ;
		System.out.println(str);
		System.out.println("abc"+str+new Customer());
		
	}
}
