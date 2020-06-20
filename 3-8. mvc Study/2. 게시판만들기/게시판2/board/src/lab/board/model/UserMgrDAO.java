package lab.board.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class UserMgrDAO {
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workspace2/web2/WebContent/WEB-INF/db.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"), prop.getProperty("pwd")
			);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void dbClose(Connection con, Statement stat, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserVO loginProc(String uid, String upwd) {
		UserVO user = null;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "select * from userinfo where userid = ? and userpwd = ?";
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, uid);
			stat.setString(2, upwd);
			rs = stat.executeQuery();
			while(rs.next()) {
				user = new UserVO();
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				user.setPhone(rs.getString("phone"));
				user.setUserpwd(rs.getString("userpwd"));				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stat, rs);
		}
		return user;
	}	
	
	
	public int joinProc(UserVO user) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "insert into userinfo(userid, userpwd, username, email, address, phone, job) values(?,?,?,?,?,?,?)";
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, user.getUserid());
			stat.setString(2, user.getUserpwd());
			stat.setString(3, user.getUsername());			
			stat.setString(4, user.getEmail());
			stat.setString(5, user.getAddress());
			stat.setString(6, user.getPhone());
			stat.setString(7, user.getJob());
			rows = stat.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stat, null);
		}
		return rows;
	}
}
		