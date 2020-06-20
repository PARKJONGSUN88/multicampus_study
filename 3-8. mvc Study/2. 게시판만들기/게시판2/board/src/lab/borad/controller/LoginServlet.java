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
import javax.servlet.http.HttpSession;

import lab.board.model.UserMgrDAO;
import lab.board.model.UserVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("./login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("userid");
		String upwd = request.getParameter("userpwd");
		String page = request.getParameter("page");
		UserMgrDAO dao = new UserMgrDAO();
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = null;
		UserVO user = null;
		HttpSession session = null;
		user = dao.loginProc(uid, upwd);
		if(user != null) {
			session = request.getSession();
			session.setAttribute("user", user);
			if(page != null) {
				response.sendRedirect("./list.do?page="+page);
			}else {
				response.sendRedirect("./list.do");
			}			
		}else {
			out.print("<script>");
			out.print("alert(\"아이디가 존재하지 않거나 \n패스워드 오류\");");
			out.print("location.href=\"./login.do\";");
			out.print("</script>");
		}		
	}

}