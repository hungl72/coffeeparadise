package models;

public class Comment {
	private int id;
	private String user;
	private String detail;
	private String time;
	private int product_id;
	private String product_name;
	public Comment() {
		
	}
	public Comment(int id, String user, String detail, String time,int product_id,String product_name) {
		super();
		this.id = id;
		this.user = user;
		this.detail = detail;
		this.time = time;
		this.product_id = product_id;
		this.product_name = product_name;
	}
	public Comment(String user, String detail, String time,int product_id,String product_name) {
		super();
		this.user = user;
		this.detail = detail;
		this.time = time;
		this.product_id = product_id;
		this.product_name = product_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

}
