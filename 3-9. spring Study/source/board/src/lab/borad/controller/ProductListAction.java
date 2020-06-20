package lab.borad.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;


@WebServlet("/products.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public ProductListAction() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> list = null;
		String page = null;
		
		list = dao.getProductList();		
		request.setAttribute("products", list);
		
		rd = sc.getRequestDispatcher("/product_list.jsp");
		rd.forward(request, response);
	}

}
