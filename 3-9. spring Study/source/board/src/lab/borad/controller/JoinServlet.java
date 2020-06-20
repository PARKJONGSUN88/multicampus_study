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

import lab.board.model.UserMgrDAO;
import lab.board.model.UserVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public JoinServlet() {
        super();       
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("./member.jsp");
    }	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");		
		
		UserVO vo = new UserVO();
		String userid = request.getParameter("userid");		
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String phone = request.getParameter("phone");			
		String email = request.getParameter("email")+"@";
		if(request.getParameter("email_dns")=="") {
			email += request.getParameter("email_dns");
		}else {
			email += request.getParameter("emailaddr");
		}
		
		String job;
		switch(request.getParameter("job")) {
		case "39" : job = "학생"; break;
		case "40" : job = "컴퓨터/인터넷"; break;
		case "41" : job = "언론"; break;
		case "42" : job = "공무원"; break;
		case "43" : job = "군인"; break;
		case "44" : job = "서비스업"; break;
		case "45" : job = "교육"; break;
		case "46" : job = "금융"; break;
		case "47" : job = "유통업"; break;
		case "48" : job = "예술"; break;
		case "49" : job = "의료"; break;
		default : job = "무직"; break;
		}	
		
		String address = request.getParameter("address");
		UserMgrDAO dao = new UserMgrDAO();
		ServletContext sc =request.getServletContext();
		RequestDispatcher rd = null;
		if(dao.joinProc(vo)>0) {
			response.sendRedirect("./login.do");
		} else {
			out.print("<script>");
			out.print("alert(\"회원가입 실패\");");
			out.print("location.href=\"./member.jsp\"");
			out.print("</script>");
		}
	}
		
}
