package common.util;

import java.util.ResourceBundle;

public class ConfigUtil {
	private static ResourceBundle resourceBundle = null;

	static {
		resourceBundle = ResourceBundle.getBundle("common/config/config");
	}

	/**
	 * 得到配置文件中的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		if (resourceBundle.containsKey(key)) {
			return resourceBundle.getString(key);
		}
		return null;
	}
	
	public static final Integer PageSize = 20;
}
