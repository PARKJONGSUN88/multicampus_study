package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.web.model.Product;
 
@WebServlet("/Price")
public class PriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		 
		Product products[] = new Product[3];
		for(int i=0;i<products.length;i++) {
			Product p = new Product();
		 p.setName(request.getParameter("snak"+(i+1)));		 
		 p.setQty(Integer.parseInt(request.getParameter("qty"+(i+1))));		  
		 p.setPrice(Integer.parseInt( request.getParameter("price"+(i+1))));
		 products[i] = p;
		}	 
	
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/priceResult.jsp");
		request.setAttribute("products", products);
		rd.forward(request, response);
	}

}