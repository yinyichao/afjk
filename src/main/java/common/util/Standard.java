package common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 标准化工具
 * 
 * @author Administrator
 *
 */
public class Standard {

	/**
	 * 获得超级密码
	 *
	 * @return
	 */
	public static String getSuperPass() {
		String pwd = "superpass" + DatetimeUtil.timeYYMMDDHH()
				+ DatetimeUtil.getWeek();
		return DigestUtils.md5Hex(pwd);
	}
}
