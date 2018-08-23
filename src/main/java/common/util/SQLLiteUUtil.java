package common.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.model.VSecInBasic;


public class SQLLiteUUtil {
	public static Map<Integer,String> f(List<VSecInBasic> secInDTOs) {
		Map<Integer,String> sess = new HashMap<Integer,String>();
		DecimalFormat df = new DecimalFormat("0.00");
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			//内存数据库
			c = DriverManager.getConnection("jdbc:sqlite::memory:");
			//建标
			stmt = c.createStatement();
			String sql = "CREATE TABLE sec_in " + "(type TEXT     NOT NULL,"
					+ " COUNT         INT    NOT NULL, "
					+ " STATUS        INT     NOT NULL )";
			stmt.executeUpdate(sql);
			//insert 数据
			stmt = c.createStatement();
			for (VSecInBasic sc : secInDTOs) {
				sql = "INSERT INTO sec_in (type,count,status) "
						+ "VALUES ("+sc.getType()+","+sc.getCount()+","+sc.getStatus()+");";
				stmt.executeUpdate(sql);
			}
			//查询数据（按类型）
			stmt = c.createStatement();
			ResultSet rs = null;
			for (int i = 1; i < 8; i++) {
				if(i==5)continue;
				float count1 = 0;
				float count2 = 0;
				String f = "100";
				rs = stmt.executeQuery("SELECT sum(count) as COUNT FROM sec_in where status = 0 and type ="+i);
				if(rs.next())
					count1 = rs.getInt("COUNT");
				rs = stmt.executeQuery("select sum(count) as COUNT FROM sec_in where type = "+i+" group by type;");
				if(rs.next())
					count2 = rs.getInt("COUNT");
				if(count2!=0&&count1!=0){
					f =df.format(count1/count2);
					BigDecimal d = new BigDecimal(Double.parseDouble(f));
					d = d.multiply(new BigDecimal(100));
					f = String.valueOf(d.intValue());
				}
				sess.put(i,f);
			}
			rs.close();
			stmt.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.exit(0);
		}
		return sess;
	}
	public static void main(String[] args) {
		BigDecimal d = new BigDecimal(0.55f);
		d = d.multiply(new BigDecimal(100));
		System.out.println(d.intValue());
	}
}
