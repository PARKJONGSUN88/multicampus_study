package lab.board.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class BbsDAO {
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workspace2/board/WebContent/WEB-INF/db.properties"));
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
	
	public int getPageCount(int numPerPage) {
		//전체 글 개수 조회해서 페이지 개수 계산해서 리턴
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select count(*) from bbs";
		int max = 0;
		try {
			con = dbCon();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				max = rs.getInt(1);				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stat, null);
		}
		int pageCount=(int) Math.ceil(max/(double)numPerPage);
		pageCount = Math.max(pageCount, 1);
		return pageCount;
	}

	public int insertBbs(BbsVO form) {
		//게시글 저장
		StringBuffer sql = null;
		int cnt = -1;
		PreparedStatement stmt = null;
		Connection con = null;		
		sql = new StringBuffer();
		sql.append(" insert into bbs (bid, subject, writer, ")
		   .append(" password, idate, fileYN, contents, email, ip )")
		   .append(" values(?, ?, ?, ?, sysdate, ")
		   .append(" ?, ?, ?, ?) ");		
		try {
			con=dbCon();
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, form.getBid());
			stmt.setString(2, form.getSubject());
			stmt.setString(3, form.getWriter());
			stmt.setString(4, form.getPassword());
			stmt.setString(5, form.getFileYN());
			String contents = form.getContents();
			stmt.setString(6, contents);			
			stmt.setString(7, form.getEmail());
			stmt.setString(8, form.getIp());
			cnt = stmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, null);
		}
		return cnt;		
	}
	
	public BbsVO getArticle(int bid) {
		//글번호 PK로 게시글 내용 조회 리턴
		Connection con = null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    BbsVO bbs = null;
	    StringBuffer sql = new StringBuffer();
	    sql.append("select bid, subject, writer, password, idate, ")
	    	.append(" contents, email, fileyn, ip, rcount, vcount ")
	    	.append(" from bbs ")
	    	.append(" where bid = ? ");
	    try {
	    	con = dbCon();
	    	stmt = con.prepareStatement(sql.toString(),
	    		ResultSet.TYPE_FORWARD_ONLY,
	    		ResultSet.CONCUR_UPDATABLE	);
	    	stmt.setInt(1, bid);
	    	rs = stmt.executeQuery();
	    	
	    	while(rs.next()) {
	    		bbs = new BbsVO();
	    		bbs.setBid(rs.getInt("bid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setWriter(rs.getString("writer"));
				bbs.setPassword(rs.getString("password"));
				bbs.setIdate(rs.getString("idate"));
				
				bbs.setFileYN(rs.getString("fileyn"));
				bbs.setContents(rs.getString("contents"));
				bbs.setEmail(rs.getString("email"));
				
				bbs.setIp(rs.getString("ip"));
				int rcount = rs.getInt("rcount");
				rs.updateLong("rcount", rcount+1);
				rs.updateRow();
				bbs.setRcount(rcount+1);
				bbs.setVcount(rs.getInt("vcount"));
    		}	  
	    	
	    StringBuffer sql2 = new StringBuffer();
	    sql2.append("select cmid, writer, idate, contents, ")
	    	.append(" password, ip from bbs_comment ")
	    	.append(" where rbid = ? ");
	    	stmt = con.prepareStatement(sql2.toString());
	    	stmt.setInt(1, bid);
	    	rs = stmt.executeQuery();
	    	while(rs.next()) {
	    		CommentVO ba = new CommentVO();
	    		ba.setCmid(rs.getInt("cmid"));
	    		ba.setRbid(bid);
	    		ba.setWriter(rs.getString("writer"));
	    		ba.setIdate(rs.getDate("idate"));
	    		ba.setContents(rs.getString("contents"));
	    		ba.setIp(rs.getString("ip"));
	    		bbs.addComment(ba);
	    	}	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	dbClose(con, stmt, rs);
	    }
	    return bbs;	    
	}
	
	public int updateBbs(BbsVO bbs) {
		//글번호 조건으로 제목과 내용을 수정
		String sql = null;
		int cnt = -1;
		PreparedStatement stmt = null;
		Connection con = null;		
		sql = " update bbs set subject=?, contents=? where bid=? ";		   
		try {
			con=dbCon();
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1, bbs.getSubject());
			stmt.setString(2, bbs.getContents());
			stmt.setInt(3,  bbs.getBid());
			cnt = stmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, null);
		}
		return cnt;		
		
	}
	
	public int deleteBbs(int bid) {
		//글번호 조건으로 제목과 내용을 삭제
		String sql = null, sql2 = null;
		int cnt = 0;
		PreparedStatement stmt = null;
		Connection con = null;		
		sql = " delete from bbs where bid=? ";
		sql2 = " delete from bbs_comment where rbid=? ";
		try {
			con=dbCon();
			stmt=con.prepareStatement(sql2);			
			stmt.setInt(1, bid);
			cnt += stmt.executeUpdate();
			
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, bid);
			cnt += stmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				dbClose(con, stmt, null);
			}
		return cnt;	
		
	}	
	
	
	public int deleteComment(int bid) {
		//글번호 조건으로 제목과 내용을 삭제
		String sql = null;
		int cnt = 0;
		PreparedStatement stmt = null;
		Connection con = null;		
		sql = " delete from bbs_comment where cmid=? ";
		try {
			con=dbCon();
			stmt=con.prepareStatement(sql);			
			stmt.setInt(1, bid);
			cnt += stmt.executeUpdate();
			
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, bid);
			cnt += stmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				dbClose(con, stmt, null);
			}
		return cnt;	
		
	}	
	
	
	
	
	public ArrayList<BbsVO> getBbsList(int page, int numPerPage){
		//페이지 번호에 해당하는 게시글 10개 검색해서 리턴
		Connection con = null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    StringBuffer sql = new StringBuffer();
		ArrayList<BbsVO> articles = new ArrayList();
		int start = (page-1) * numPerPage; 
		int end = page * numPerPage;
		sql.append("select num, bid, subject, writer, idate, rcount ");
		sql.append(" from (select rownum num, bid, subject, writer, idate, rcount ");
		sql.append(" from (select bid, subject, writer, idate, rcount ");
		sql.append(" from bbs ");
		sql.append(" order by bid ) ");
		sql.append(" order by num desc ) ");
		sql.append(" where num > ? and num<= ? ");					
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1,  start);
			stmt.setInt(2,  end);			
			rs = stmt.executeQuery();
			while(rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setBid(rs.getInt("bid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setWriter(rs.getString("writer"));
				bbs.setIdate(rs.getString("idate"));
				bbs.setRcount(rs.getInt("rcount"));
				articles.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, rs);
		}
		return articles;
	}	
	
	
	public ArrayList<BbsVO> getBbsList(String key, String word, int page, int numPerPage){
		//검색조건에 해당하는 게시글 10개 검색해서 리턴
		Connection con = null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    StringBuffer sql = new StringBuffer();
		ArrayList<BbsVO> articles = new ArrayList<BbsVO>();
		int start = (page-1) * numPerPage; 
		int end = page * numPerPage;
		sql.append("select num, bid, subject, writer, idate, rcount ");
		sql.append(" from (select rownum num, bid, subject, writer, idate, rcount ");
		sql.append(" from (select bid, subject, writer, idate, rcount ");
		sql.append(" from bbs ");
		sql.append(" where "+ key + "like '" + "%" + word + "%' ");
		sql.append(" order by bid ) ");
		sql.append(" order by num desc ) ");
		sql.append(" where num > ? and num<= ? ");					
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1,  start);
			stmt.setInt(2,  end);			
			rs = stmt.executeQuery();
			while(rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setBid(rs.getInt("bid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setWriter(rs.getString("writer"));
				bbs.setIdate(rs.getString("idate"));
				bbs.setRcount(rs.getInt("rcount"));
				articles.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, rs);
		}
		return articles;
	}	
	
	
	public String getBbsPassword(int bid) {
		//글번호 PK로 게시글 패스워드 조회 리턴
		Connection con = null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    BbsVO bbs = null;
	    String pwd = null;
	    String sql = "select password from bbs where bid = ? ";
	    try {
	    	con = dbCon();
	    	stmt = con.prepareStatement(sql);	    	
	    	stmt.setInt(1, bid);
	    	rs = stmt.executeQuery();
	    	if(rs.next()) {
	    		pwd = rs.getString("password");
	    	}	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	dbClose(con, stmt, rs);
	    }
	   return pwd;	    
	}
	
	public String getCommentPassword(int cmid) {
		//글번호 PK로 댓글 패스워드 조회 리턴
		Connection con = null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    CommentVO bbs = null;
	    String pwd = null;
	    String sql = "select password from bbs_comment where cmid = ? ";
	    try {
	    	con = dbCon();
	    	stmt = con.prepareStatement(sql);	    	
	    	stmt.setInt(1, cmid);
	    	rs = stmt.executeQuery();
	    	if(rs.next()) {
	    		pwd = rs.getString("password");
	    	}	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	dbClose(con, stmt, rs);
	    }
	   return pwd;	    
	}	
	
	public int insertBbsComment(CommentVO comment, int bid) {
		//게시글 저장
		StringBuffer sql = null;
		int cnt = 0;
		PreparedStatement stmt = null;
		Connection con = null;		
		sql = new StringBuffer();
		sql.append(" insert into bbs_comment (cmid, rbid, writer, ")
		   .append(" idate, contents, password, ip )")
		   .append(" values( comment_seq.nextval, ?, ?, sysdate, ")
		   .append(" ?, ?, ? ) ");		
		try {
			con=dbCon();
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, bid);
			stmt.setString(2, comment.getWriter());			
			stmt.setString(3, comment.getContents());
			stmt.setString(4, comment.getPassword());
			stmt.setString(5, comment.getIp());
			cnt = stmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, null);
		}
		return cnt;		
	}	
	
	public int getBid() {
		int bid = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select bbs_seq.nextval from dual ";
		try {
			con =dbCon();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				bid = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, rs);
		}
		return bid;
	}
	
	public int saveFile(FileInfoVO fileinfo) {
		//upload file 정보 저장
		StringBuffer sql = null;
		int cnt = -1;
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		sql = new StringBuffer();
		sql.append("insert into bbs_file(fid, filename, filetype, savedfile) ");
		sql.append(" values (bbsfile_seq.nextval, ?, ?, ?) ");
		int rbid = 0;
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, fileinfo.getFilename());
			stmt.setString(2, fileinfo.getFiletype());
			stmt.setString(3, fileinfo.getSavedFile());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con, stmt, rs);
		}
		return cnt;
	}
	
	
}