package util;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class PropertiesUtil {
	 
	public static String getPropValues(String propertieName) {
		String result = "";
		ResourceBundle rb = ResourceBundle.getBundle("loginService");
		Enumeration <String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			if(propertieName.toUpperCase().equals(key.toUpperCase()))
				result = rb.getString(key);
		}
		return result;
	}
}