package lab.board.model;

public class FileInfoVO {
	private int fid;
	private int rbid;
	private String filename;
	private String filetype;
	private String savedFile;
	public FileInfoVO() {
		super();
	}
	public FileInfoVO(int fid, int rbid, String filename, String filetype, String savedfile) {
		super();
		this.fid = fid;
		this.rbid = rbid;
		this.filename = filename;
		this.filetype = filetype;
		this.savedFile = savedfile;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getRbid() {
		return rbid;
	}
	public void setRbid(int rbid) {
		this.rbid = rbid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getSavedFile() {
		return savedFile;
	}
	public void setSavedFile(String savedFile) {
		this.savedFile = savedFile;
	}

}
