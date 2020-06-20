package lab.borad.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.CommentVO;


@WebServlet("/comment.do")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		ServletContext sc = getServletContext();		
		BbsDAO dao = new BbsDAO();		
		String page = null;
		page = request.getParameter("page");		
		int bid = Integer.parseInt(request.getParameter("bid"));
		CommentVO comment = new CommentVO();
		CommentVO form = null;
		form = new CommentVO();
		comment.setRbid(bid);
		comment.setWriter(request.getParameter("writer"));			
		comment.setContents(request.getParameter("contents"));
		comment.setPassword(request.getParameter("password"));
		comment.setIp(request.getRemoteAddr());
		
		if(dao.insertBbsComment(comment, bid) > 0) {
			response.sendRedirect("./view.do?bid="+bid+"&page="+page);
		}			
	}
		


}
