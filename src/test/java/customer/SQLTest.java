package customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class SQLTest {

	public static void main(String[] args) throws Exception{
		File file = new File("E:\\last-demo.sql") ;
		InputStream is = new FileInputStream(file) ;
		
		List<String> sqlList = IOUtils.readLines(is, "UTF-8") ;
		FileWriter fw = new FileWriter("E:\\temp-demo.sql");
		for(String sql :sqlList) {
			if(sql.contains("COMMENT '")) {
				String newSql = sql ;
				int _index = sql.lastIndexOf("COMMENT '");
				String dot = sql.substring(sql.length() - 1,sql.length());
				String _testsql1 = sql.substring(_index,dot.equals(",") ? sql.length() - 1 : sql.length());
				String newSql1 = newSql.replace(_testsql1, "") ;
				fw.write(newSql1 + "\n");
				fw.flush();
			} else {
				fw.write(sql + "\n");
				fw.flush();
			}
		}
		
	}
}
