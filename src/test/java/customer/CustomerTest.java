package customer;

import org.agle4j.framework.helper.DatabaseHelper;
import org.junit.Before;

public class CustomerTest {

	@Before
	public void init() throws Exception{
		DatabaseHelper.executeSqlFile("sql/customer_init.sql");
	}
	
}
