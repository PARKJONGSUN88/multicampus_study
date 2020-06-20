package lab.borad.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.FileInfoVO;


@WebServlet("/write.do")
@MultipartConfig(location="c:/uploadtest", maxFileSize = 1024 * 1024* 5, maxRequestSize = 1024* 1024* 5* 5)
public class BbsWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String UPLOAD_DIRECTORY = "c:/uploadtest";
	
	public BbsWriteAction() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();		
		PrintWriter out = response.getWriter();
		if(session.getAttribute("user")==null) {
			out.print("<script>");
			out.print("alert(\"로그인 후 글 작성할 수 있습니다.\");");
			out.print("location.href=\"./login.do\"");
			out.print("</script>");			
		}else {
			response.sendRedirect("./bbs_write.jsp");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		BbsDAO dao = new BbsDAO();
		BbsVO form = null;
		String page = null;
		String fileName = null;
		String savedFile = null;
		String fileType = null;
		FileInfoVO fileVo= null;
		int bid = -1;		
		
		page = request.getParameter("page");
		form = new BbsVO();
		
		File uploadDir = new File(UPLOAD_DIRECTORY);
		if(!uploadDir.isDirectory()) {
			uploadDir.mkdir();			
		}
		
		bid = dao.getBid();
		/*file upload 처리*/
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			if(part.getContentType() != null) {
				fileName = part.getSubmittedFileName();
				fileType = fileName.substring(fileName.lastIndexOf(".")+1);
				if(fileName!=null) {
					form.setFileYN("Y");
					savedFile = fileName.substring(0, fileName.lastIndexOf("."))
							+"_"+System.currentTimeMillis()+
							fileName.substring(fileName.lastIndexOf("."));
					part.write(savedFile);
					fileVo = new FileInfoVO();
					fileVo.setFilename(fileName);
					fileVo.setFiletype(fileType);
					fileVo.setSavedFile(savedFile);					
					fileVo.setRbid(bid);
					dao.saveFile(fileVo);
				}
			}
		}
		form.setBid(bid);		
		form.setWriter(request.getParameter("writer"));
		form.setPassword(request.getParameter("password"));
		form.setSubject(request.getParameter("subject"));
		form.setEmail(request.getParameter("email"));
		form.setContents(request.getParameter("contents"));
		form.setIp(request.getRemoteAddr());
		
		if(dao.insertBbs(form) > 0) {
			response.sendRedirect("./list.do");
		}			
	}
	
	
	
}
