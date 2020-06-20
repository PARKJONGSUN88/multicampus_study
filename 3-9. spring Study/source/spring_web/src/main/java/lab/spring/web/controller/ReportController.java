package lab.spring.web.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lab.spring.web.model.ReportCommand;

@Controller
public class ReportController {

	@RequestMapping("/report/report.do")
	public String form() {
		return "report/reportForm";
	}
	
	@RequestMapping("/report/submitReport1.do")
	public String submitReport1( 
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);	
		if(report.getSize()==0)
			throw new NullPointerException("업로드된 파일 없음");
		return "report/reportComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		if(!report.isEmpty()) {
			String filename = report.getOriginalFilename();
			String imgExt = filename.substring(filename.lastIndexOf(".")
					+ 1, filename.length());
			try {
				if (imgExt.equalsIgnoreCase("JPG")
						|| imgExt.equalsIgnoreCase("JPEG")
						|| imgExt.equalsIgnoreCase("GIF")
						|| imgExt.equalsIgnoreCase("PNG")) {
				byte[] bytes = report.getBytes();
				File OutFile = new File("c://upload/" + "_" + filename);
				FileOutputStream fos = new FileOutputStream(
								OutFile);
				fos.write(bytes);
				fos.close();
				} else {
					System.err.println("File type error! ");
				}
				System.out.println(studentNumber + "제출된 보고서: "
							+ report.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public String handleException(NullPointerException exception) {
		return "common/error";
	}
	
	@RequestMapping("/report/submitReport2.do")
	public String submitReport2(MultipartHttpServletRequest request) {
		String sno = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");			
		printInfo(sno, report);
		return "report/reportComplete";
	}
	
	@RequestMapping("/report/submitReport3.do")
	public String submitReport3(ReportCommand reportCommand) {		
		printInfo(reportCommand.getStudentNumber(),
				reportCommand.getReport());
		return "report/reportComplete";
	}
}
