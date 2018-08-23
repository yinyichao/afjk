package common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {

	/**
	 * 将OBJ转成Post
	 * 
	 * @param obj
	 * @return
	 */
	public static String beanToPost(Object obj) {
		StringBuffer postData = new StringBuffer();
		try {
			Class objCls = obj.getClass();
			Method[] methods = objCls.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					Object val = method.invoke(obj);
					if (val != null && StringUtil.isNotEmpty(val.toString())) {
						String name = method.getName().replace("get", "");
						postData.append(
								name.substring(0, 1).toLowerCase()
										+ name.substring(1)).append("=")
								.append(val).append("&");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return postData.toString();
	}
	public static Object update(Object obj1,Object ob2){
		//UserInfo userInfo2 = userInfoService.find(userInfo.getId());
		Class clas1 = obj1.getClass();
		Class clas2 = ob2.getClass();
		Method[] method = clas2.getDeclaredMethods();
		try{
			for (Method met : method) {
				String mname = met.getName();
				if (mname.startsWith("get")) {
					Object obj = met.invoke(ob2);
					if (obj != null) {
						Method met2 = clas1.getMethod(
								mname.replace("get", "set"),
								met.getReturnType());
						met2.invoke(obj1, new Object[] { obj });
					}
				}
			}
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return obj1;
	}
}
