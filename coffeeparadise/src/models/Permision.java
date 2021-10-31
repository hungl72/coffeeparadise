package models;

public class Permision {
	private int per_id;
	private String per_name;
	private int check;
	private String action;
	private int staff_id;
	private String staff_name;
	private String staff_email;
	private String staff_image;
	public Permision() {
		super();
	}
	public Permision(int per_id, String per_name) {
		super();
		this.per_id = per_id;
		this.per_name = per_name;
	}
	public Permision(int per_id, String per_name, int check, String action) {
		super();
		this.per_id = per_id;
		this.per_name = per_name;
		this.check = check;
		this.action = action;
	}
	public Permision(int staff_id,String staff_image,String staff_name,String staff_email, String per_name) {
		super();
		this.staff_id = staff_id;
		this.staff_image = staff_image;
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.per_name = per_name;
	}
	public Permision(int staff_id,String staff_image, String staff_name,String staff_email, String per_name,int check, String action) {
		super();
		this.staff_id = staff_id;
		this.staff_image = staff_image;
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.per_name = per_name;
		this.check = check;
		this.action = action;
	}
	public Permision(int per_id, String action, int check, int staff_id) {
		super();
		this.per_id = per_id;
		this.action = action;
		this.check = check;
		this.staff_id = staff_id;
	}
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_email() {
		return staff_email;
	}
	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}
	public String getStaff_image() {
		return staff_image;
	}
	public void setStaff_image(String staff_image) {
		this.staff_image = staff_image;
	}
	
}
