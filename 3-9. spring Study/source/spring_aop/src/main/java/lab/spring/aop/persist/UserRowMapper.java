package lab.spring.aop.persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserVO> {
	
	public UserVO mapRow(ResultSet rs, int num) throws SQLException {
		UserVO vo = new UserVO();
		vo.setUserid(rs.getString("userid"));
		vo.setUsername(rs.getString("username"));
		vo.setUserpwd(rs.getString("userpwd"));
		vo.setPhone(rs.getString("phone"));
		vo.setAddress(rs.getString("address"));
		vo.setEmail(rs.getString("email"));
		vo.setJob(rs.getString("job"));
		return vo;		
	}

}
