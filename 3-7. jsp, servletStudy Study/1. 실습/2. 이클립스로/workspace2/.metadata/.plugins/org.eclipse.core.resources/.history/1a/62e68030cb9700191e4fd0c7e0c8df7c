package lab.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;


public class HelloServlet extends HttpServlet {
	public void init(){ //override하지 않으면 부모의 init()수행
		//서블릿이 요청되어서 컨테이너 메모리에 생성될때 한번만 수행
		System.out.println("inint():first");
	}
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//서블릿이 요청시마다 반복적으로 수행
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>HelloServlet</title></head>");
		out.print("<body>");
		out.print("Good Day!<br>");
		out.print("</body></html>");		
	
	}	
	public void destroy() {
		//서블릿이 컨테이너로부터 소멸되때 한번만 수행
		System.out.println("destroy()");
	}
}