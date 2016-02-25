package customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class SQLTest2 {

	public static void main(String[] args) {
		File file = new File("E:\\cbod-core.sql");
		FileWriter fw = null;
		try {
			InputStream is = new FileInputStream(file);

			List<String> sqlList = IOUtils.readLines(is, "UTF-8");
			fw = new FileWriter("E:\\temp-core.sql");
			for (String sql : sqlList) {
				if (sql.startsWith("INSERT INTO")) {
					String testSql = sql;
					String testSql1 = testSql.substring(0, testSql.indexOf("`"));
					String testSql2 = testSql.substring(testSql.indexOf("`") + 1, testSql.length());
					String testSql3 = testSql2.substring(0, testSql2.indexOf("`")).toUpperCase();
					testSql2 = testSql2.replace(testSql2.substring(0, testSql2.indexOf("`")), testSql3);
					String newSql = testSql1 + "`" + testSql2;
					fw.write(newSql + "\n");
					fw.flush();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
			}
		}

	}
}
