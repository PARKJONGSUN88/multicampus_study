package lab.borad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;


@WebServlet("/productView.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public ProductViewAction() {
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
		PrintWriter out = response.getWriter();
		
		ProductDAO dao = new ProductDAO();
		String pid = request.getParameter("productid");
			
		ProductVO p = null;
		p = dao.getProduct(pid);
				
		
		request.setAttribute("product_list", p);
		
		rd = sc.getRequestDispatcher("/product_view.jsp");
		rd.forward(request, response);				
	}

}
