package models;

public class User {
	private int user_id;
	private String user_fullname;
	private String user_email;
	private String user_pass;
	private int status;
	public User() {
		super();
	}
	public User(int user_id, String user_fullname, String user_email, String user_pass) {
		super();
		this.user_id = user_id;
		this.user_fullname = user_fullname;
		this.user_email = user_email;
		this.user_pass = user_pass;
	}
	public User(int user_id, String user_fullname, String user_email, String user_pass,int status) {
		super();
		this.user_id = user_id;
		this.user_fullname = user_fullname;
		this.user_email = user_email;
		this.user_pass = user_pass;
		this.status = status;
	}
	public User(int user_id) {
		super();
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
