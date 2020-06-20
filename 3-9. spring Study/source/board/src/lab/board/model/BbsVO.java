package lab.board.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

public class BbsVO {
	private int bid;
	private String subject;
	private String writer;
	private String password;
	private String idate;
	private String contents;
	private String email;
	private String ip;
	private String fileYN;
	private int rcount;
	private int vcount;	
	protected Vector<CommentVO> comments;
	private ArrayList<FileInfoVO> files;
		
	public BbsVO() {
		comments = new Vector<CommentVO>();
		files = new ArrayList<FileInfoVO>();
	}
	
	public void addComment(CommentVO a) {
		comments.add(a);
	}
	
	public void addFiles(FileInfoVO s) {
		files.add(s);
	}	
	
	public ArrayList<FileInfoVO> getFiles() {
		return files;
	}
	
	public void setFiles(ArrayList<FileInfoVO> files) {
		this.files = files;		
	}
	
	public Vector<CommentVO> getComments() {
		return comments;
	}
	
	public void setComments(Vector<CommentVO> comments) {
		this.comments = comments;
	}	
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFileYN() {
		return fileYN;
	}

	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getVcount() {
		return vcount;
	}

	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	
	
	

}
