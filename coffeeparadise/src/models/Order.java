package models;

public class Order {
	private int order_id;
	private String order_image;
	private String order_name;
	private int order_amount;
	private double order_price;
	private double order_money;
	private String order_user;
	private int order_user_id;
	private String order_date;
	private int staff_id;
	private int bill_id;
	private int status;
	public Order() {
		super();
	}
	public Order(int order_id, String order_image, String order_name, int order_amount, double order_price,
			double order_money, String order_user, int order_user_id, String order_date, int staff_id, int bill_id,
			int status) {
		super();
		this.order_id = order_id;
		this.order_image = order_image;
		this.order_name = order_name;
		this.order_amount = order_amount;
		this.order_price = order_price;
		this.order_money = order_money;
		this.order_user = order_user;
		this.order_user_id = order_user_id;
		this.order_date = order_date;
		this.staff_id = staff_id;
		this.bill_id = bill_id;
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_image() {
		return order_image;
	}
	public void setOrder_image(String order_image) {
		this.order_image = order_image;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public double getOrder_money() {
		return order_money;
	}
	public void setOrder_money(double order_money) {
		this.order_money = order_money;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public int getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
