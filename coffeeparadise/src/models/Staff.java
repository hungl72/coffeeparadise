package models;

public class Staff {
	private int staff_id;
	private String staff_image;
	private String staff_name;
	private String staff_email;
	private String staff_pass;
	private String staff_phone;
	private double staff_salary;
	private String staff_calendar;
	private int per_id;
	private String per_name;
	private int check;
	private String action;
	public Staff() {
		super();
	}
	public Staff(int staff_id, String staff_image,String staff_name, String staff_email, String staff_pass, String staff_phone,
			double staff_salary, String staff_calendar, int per_id, String per_name) {
		super();
		this.staff_id = staff_id;
		this.staff_image = staff_image;
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.staff_pass = staff_pass;
		this.staff_phone = staff_phone;
		this.staff_salary = staff_salary;
		this.staff_calendar = staff_calendar; 
		this.per_id = per_id;
		this.per_name = per_name;
	}
	public Staff(int staff_id, String staff_email, String staff_pass, String staff_name, String staff_image, int per_id,String per_name,int check, String action) {
		super();
		this.staff_id = staff_id;
		this.staff_email = staff_email;
		this.staff_pass = staff_pass;
		this.staff_name = staff_name;
		this.staff_image = staff_image;
		this.per_id = per_id;
		this.per_name = per_name;
		this.check = check;
		this.action = action;
	}
	public Staff(int staff_id, String staff_image, String staff_name, String staff_email, String staff_pass, String staff_phone, double staff_salary, String staff_calendar) {
		super();
		this.staff_id = staff_id;
		this.staff_image = staff_image;
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.staff_pass = staff_pass;
		this.staff_phone = staff_phone;
		this.staff_salary = staff_salary;
		this.staff_calendar = staff_calendar;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public String getStaff_image() {
		return staff_image;
	}
	public void setStaff_image(String staff_image) {
		this.staff_image = staff_image;
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
	public String getStaff_pass() {
		return staff_pass;
	}
	public void setStaff_pass(String staff_pass) {
		this.staff_pass = staff_pass;
	}
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}
	public double getStaff_salary() {
		return staff_salary;
	}
	public void setStaff_salary(double staff_salary) {
		this.staff_salary = staff_salary;
	}
	public String getStaff_calendar() {
		return staff_calendar;
	}
	public void setStaff_calendar(String staff_calendar) {
		this.staff_calendar = staff_calendar;
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
	
}
