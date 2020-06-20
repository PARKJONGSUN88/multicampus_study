package lab.board.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class ProductDAO {
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();			
			prop.load(new FileInputStream("C:/Users/student/workspace/board/WebContent/WEB-INF/db.properties"));
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

	public ArrayList<ProductVO> getProductList() {
		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select * from product ";
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql);			
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProductId(rs.getString("productid"));
				product.setPname(rs.getString("pname"));
				product.setDescription(rs.getString("description"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setCategory(rs.getString("category"));
				product.setCondition(rs.getString("condition"));
				product.setFilename(rs.getString("filename"));
				product.setUnitPrice(rs.getInt("unitprice"));
				product.setUnitsInStock(rs.getLong("unitsInStock"));				
				products.add(product);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(con, stmt, rs);
		}
		return products;
	}
	//상품하나조회
	public ProductVO getProduct(String productid) {
		ProductVO pro = null;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "select * from product where productid = ? ";
		ResultSet rs = null;
		try {
			con =dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1,  productid);
			rs = stat.executeQuery();
			while(rs.next()) {
				pro = new ProductVO();
				pro.setProductId(rs.getString("productid"));
				pro.setPname(rs.getString("pname"));
				pro.setUnitPrice(rs.getInt("unitprice"));
				pro.setDescription(rs.getString("description"));
				pro.setManufacturer(rs.getString("manufacturer"));
				pro.setCategory(rs.getString("category"));
				pro.setUnitsInStock(rs.getLong("unitsInStock"));
				pro.setCondition(rs.getString("condition"));
				pro.setFilename(rs.getString("filename"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(con, stat, rs);
		}
		return pro;
	}
	
	
}

