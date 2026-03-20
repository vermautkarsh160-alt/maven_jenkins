package vtiger_extra;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class getDataFromProperties {
	    public static void main(String[] args) throws IOException {
	    	
	    	//Step 1: Get the java representational object of the physical file
	    	FileInputStream fis = new FileInputStream("./src/test/resources/commondata3.properties");
	    	
	    	//Step 2: Load all the keys by using load methods of the properties
	    	Properties pObj = new Properties();
	    	pObj.load(fis);
	    	
	    	//Step 3: Get the values by giving they keys in the getProperty(key)
	    	String BROWSER = pObj.getProperty("bro");
	    	String USERNAME = pObj.getProperty("un");
	    	String URL = pObj.getProperty("url");
	    	String PASSWORD = pObj.getProperty("pwd");
	    	
	    	System.out.println(BROWSER);
	    	System.out.println(USERNAME);
	        System.out.println(URL);
	        System.out.println(PASSWORD);
	    }
	}


