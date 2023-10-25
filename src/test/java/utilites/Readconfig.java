package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	
		public static 	Properties prop=null;
		public static  FileInputStream fis=null;;

		public Readconfig() {
		try {
			 fis= new FileInputStream("C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\jobrelated\\github\\javaprogram-naveen\\infosys\\Configurations\\config.properties1");
	 prop=new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public String getapplicationurl() {
			String url=prop.getProperty("url");
			return url;
		
		
		
		
		
			}
		public String getchropath() {
			String chromepath=prop.getProperty("chromepath");
			return chromepath;
		}
		public String getiepath() {
			String ie=prop.getProperty("iepath");
			return ie;
		}
		public String getfirefoxpath() {
			String firepath=prop.getProperty("firefoxpath");
			return firepath;

		}
		public String getdesiredbrowser() {
			String browsername=prop.getProperty("browser");
			return browsername;

		}
			
}
			
		
		
		
