package customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class MergeSQLTest {

	public static void main(String[] args) throws Exception{
		
		File file = new File("D:\\workspaces\\cbod1\\cbod-core\\dbscript") ;
		
		File file2 = new File("D:" + File.separator + "workspaces" + File.separator + "cbod1") ;
		
		Collection<File> fileCollection = FileUtils.listFiles(file, new String[]{"sql"}, true) ;
		FileWriter fw = new FileWriter("E:\\cbod-core-data.sql");
		for(File file1 : fileCollection) {
			
			if(file1.exists() && file1.isFile()) {
				InputStream is = new FileInputStream(file1) ;
				List<String> sqlList = IOUtils.readLines(is, "UTF-8") ;
				
				for(String sql :sqlList) {
					if(StringUtils.contains(sql, "INSERT INTO")) {
						fw.write(sql + "\n");
						fw.flush();
					}
				}
			}

		}
		
		fw.close();
	}
}
