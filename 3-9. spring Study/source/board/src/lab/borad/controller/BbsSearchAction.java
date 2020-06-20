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

@WebServlet("/search.do")
public class BbsSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int numPerBlock = 10;
    public static int numPerPage = 10;
	
    public BbsSearchAction() {
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
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> headers = null;
		String page = null, key = null, word = null;
		page = request.getParameter("page");
		key = request.getParameter("key");
		word = request.getParameter("word");
		System.out.println(page + key + word);
		int pageNo = 1;
		if(page == null) {
			pageNo = dao.getPageCount(numPerPage);
			headers = dao.getBbsList(key, word, pageNo, numPerPage);
		} else {
			pageNo = Integer.parseInt(page);
			headers = dao.getBbsList(key, word, pageNo, numPerPage);
		}
		Integer totalPage = new Integer(dao.getPageCount(numPerPage));
		request.setAttribute("headers", headers);
		request.setAttribute("pageNo", new Integer(pageNo));
		request.setAttribute("totalPage", totalPage);
		rd = sc.getRequestDispatcher("/bbs_list.jsp");
		rd.forward(request, response);
	}

}
