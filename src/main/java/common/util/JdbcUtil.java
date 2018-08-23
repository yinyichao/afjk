package common.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JDBC 工具类
 * 
 * @author jxl
 *
 */
public class JdbcUtil {

	/**
	 * 反射实体类转换为INSERT语句
	 * 
	 * @param obj
	 *            要保存的实体类
	 * @return INSERT语句
	 */
	@SuppressWarnings("rawtypes")
	public static String createInsert(Object obj) {
		StringBuilder _coloums = new StringBuilder(), _values = new StringBuilder();
		String sql = null;
		try {
			if (null == obj)
				return null;
			Class objCls = obj.getClass();
			Method[] methods = objCls.getMethods();
			String tableName = getTableName(objCls);

			if (methods != null && methods.length > 0) {
				for (Method method : methods) {
					if (method.getName().startsWith("get")
							&& !"getClass".equals(method.getName())) {
						String _name = method.getName().substring(3);
						Object _value = method.invoke(obj, new Object[] {});

						if (_value != null) {
							_name = (_name.substring(0, 1).toLowerCase())
									+ _name.substring(1);
							StringBuffer _newName = new StringBuffer();
							// 分解字符串
							char[] _nameChars = _name.toCharArray();

							for (char c : _nameChars) {
								if (Character.isUpperCase(c)) {
									_newName.append("_"
											+ Character.toLowerCase(c));
								} else {
									_newName.append(c);
								}
							}

							_coloums.append(_newName).append(",");
							_values.append(getValueType(_value));

						}
					}
				}
				if (_coloums.length() > 0 && _values.length() > 0) {
					sql = "INSERT INTO " + tableName + " ("
							+ _coloums.substring(0, _coloums.length() - 1)
							+ ") VALUES("
							+ _values.substring(0, _values.length() - 1) + ")";
				}
			}

		} catch (Exception e) {
			sql = null;
			e.printStackTrace();
		}
		return sql;
	}

	/**
	 * 反射实体类转换为UPDATE语句
	 * 
	 * @param idColoum
	 *            主键实体类中的字段
	 * @param obj
	 *            要更新的实体类
	 * @return UPDATE语句
	 */
	@SuppressWarnings("rawtypes")
	public static String createUpdate(String[] idColoum, Object obj) {
		String sql = null;
		StringBuilder _set = new StringBuilder(), _where = new StringBuilder();

		try {
			if (obj == null)
				return null;
			Class objCls = obj.getClass();
			Method[] methods = objCls.getMethods();
			String tableName = getTableName(objCls);

			if (methods != null && methods.length > 0) {
				for (Method method : methods) {
					if (method.getName().startsWith("get")
							&& !"getClass".equals(method.getName())) {

						String _name = method.getName().substring(3);
						Object _value = method.invoke(obj, new Object[] {});

						if (_value != null) {
							boolean isPK = false;
							if (null != idColoum) {
								for (String _ids : idColoum) {
									if (_ids.equalsIgnoreCase(_name)) {
										isPK = true;
									}
								}
							}

							_name = (_name.substring(0, 1).toLowerCase())
									+ _name.substring(1);
							StringBuffer _newName = new StringBuffer();
							// 分解字符串
							char[] _nameChars = _name.toCharArray();

							for (char c : _nameChars) {
								if (Character.isUpperCase(c)) {
									_newName.append("_"
											+ Character.toLowerCase(c));
								} else {
									_newName.append(c);
								}
							}

							if (isPK) {
								if (_where.length() == 0)
									_where.append(" WHERE ")
											.append(_newName)
											.append("=")
											.append(getValueType(_value)
													.toString()
													.replace(",", ""));
								else
									_where.append(" AND ")
											.append(_newName)
											.append("=")
											.append(getValueType(_value)
													.toString()
													.replace(",", ""));

							} else {
								_set.append(_newName).append("=")
										.append(getValueType(_value));
							}
						}

					}
				}
				if (_set.length() > 0) {
					sql = "UPDATE " + tableName + " SET "
							+ _set.substring(0, _set.length() - 1);

					if (_where.length() > 0) {
						sql += " " + _where;
					}
				}
			}

		} catch (Exception e) {
			sql = null;
			e.printStackTrace();
		}

		return sql;
	}

	/**
	 * 反射实体类转换为UPDATE语句
	 * 
	 * @param idColoum
	 *            主键实体类中的字段
	 * @param obj
	 *            要更新的实体类
	 * @return UPDATE语句
	 */
	public static String createUpdate(String idColoum, Object obj) {
		return createUpdate(new String[] { idColoum }, obj);
	}

	@SuppressWarnings("rawtypes")
	private static String getTableName(Class objCls) {
		StringBuilder tableName = new StringBuilder();
		char[] tableNameChar = objCls.getSimpleName().toCharArray();
		for (int i = 0; i < tableNameChar.length; i++) {
			char c = tableNameChar[i];
			if (i == 0) {
				tableName.append(Character.toLowerCase(c));
				continue;
			}
			if (Character.isUpperCase(c)) {
				tableName.append("_" + Character.toLowerCase(c));
			} else {
				tableName.append(c);
			}
		}
		return tableName.toString();
	}

	private static StringBuilder getValueType(Object _value) {
		StringBuilder _values = new StringBuilder();
		if (_value instanceof String) {
			_values.append("'").append(_value).append("',");
		} else if (_value instanceof Integer || _value instanceof Double
				|| _value instanceof Float || _value instanceof BigDecimal) {
			_values.append(_value).append(",");
		} else if (_value instanceof Date || _value instanceof Timestamp) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			_values.append("'").append(sdf.format(_value)).append("',");
		}
		return _values;
	}

}
