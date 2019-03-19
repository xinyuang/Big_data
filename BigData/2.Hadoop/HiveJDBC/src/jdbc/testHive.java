package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class testHive {
	public static void main(String[] args) {
		//select * from emp1;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			
			//ִSQL
			rs = st.executeQuery("select * from pokes");
			while(rs.next()){
				String ename = rs.getString("bar");
				System.out.println(ename);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JDBCUtils.release(conn, st, rs);
		}
	}
}
