package common.util;

/**
 * UUID工具类
 * 
 * @author ZHU
 *
 */
public class UUIDUtil {
	/**
	 * 32位UUID
	 * @return
	 */
	public static String getUUID32() {
		java.util.UUID guid = java.util.UUID.randomUUID();
		String str = guid.toString();
		str = str.replace("-", "").toLowerCase();
		return str;
	}
}
