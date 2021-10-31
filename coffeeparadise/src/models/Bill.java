package models;

public class Bill {
	private int bill_id;
	private int bill_product_id;
	private String bill_product_image;
	private String bill_product_name;
	private double bill_product_price;
	private double bill_product_promotion;
	private int bill_product_amount;
	private double bill_product_money;
	private String user_fullname;
	private int user_id;
	private String date;
	private int status;
	public Bill() {
		super();
	}
	public Bill(int bill_id, int bill_product_id, String bill_product_image, String bill_product_name,
			double bill_product_price,double bill_product_promotion, int bill_product_amount, double bill_product_money, String user_fullname,
			int user_id, String date, int status) {
		super();
		this.bill_id = bill_id;
		this.bill_product_id = bill_product_id;
		this.bill_product_image = bill_product_image;
		this.bill_product_name = bill_product_name;
		this.bill_product_price = bill_product_price;
		this.bill_product_amount = bill_product_amount;
		this.bill_product_promotion = bill_product_promotion;
		this.bill_product_money = bill_product_money;
		this.user_fullname = user_fullname;
		this.user_id = user_id;
		this.date = date;
		this.status = status;
	}
	public Bill(int bill_id, int bill_product_id, String bill_product_image, String bill_product_name,
			double bill_product_price,double bill_product_promotion, int bill_product_amount, double bill_product_money, String user_fullname,
			int user_id, String date) {
		super();
		this.bill_id = bill_id;
		this.bill_product_id = bill_product_id;
		this.bill_product_image = bill_product_image;
		this.bill_product_name = bill_product_name;
		this.bill_product_price = bill_product_price;
		this.bill_product_promotion = bill_product_promotion;
		this.bill_product_amount = bill_product_amount;
		this.bill_product_money = bill_product_money;
		this.user_fullname = user_fullname;
		this.user_id = user_id;
		this.date = date;
	}
	public Bill(int bill_product_id, String bill_product_image, String bill_product_name,
			double bill_product_price, int bill_product_amount, double bill_product_money, String user_fullname,
			int user_id, String date) {
		super();
		this.bill_product_id = bill_product_id;
		this.bill_product_image = bill_product_image;
		this.bill_product_name = bill_product_name;
		this.bill_product_price = bill_product_price;
		this.bill_product_amount = bill_product_amount;
		this.bill_product_money = bill_product_money;
		this.user_fullname = user_fullname;
		this.user_id = user_id;
		this.date = date;
	}
	
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getBill_product_id() {
		return bill_product_id;
	}
	public void setBill_product_id(int bill_product_id) {
		this.bill_product_id = bill_product_id;
	}
	public String getBill_product_image() {
		return bill_product_image;
	}
	public void setBill_product_image(String bill_product_image) {
		this.bill_product_image = bill_product_image;
	}
	public String getBill_product_name() {
		return bill_product_name;
	}
	public void setBill_product_name(String bill_product_name) {
		this.bill_product_name = bill_product_name;
	}
	public double getBill_product_price() {
		return bill_product_price;
	}
	public void setBill_product_price(double bill_product_price) {
		this.bill_product_price = bill_product_price;
	}
	
	public double getBill_product_promotion() {
		return bill_product_promotion;
	}
	public void setBill_product_promotion(double bill_product_promotion) {
		this.bill_product_promotion = bill_product_promotion;
	}
	public int getBill_product_amount() {
		return bill_product_amount;
	}
	public void setBill_product_amount(int bill_product_amount) {
		this.bill_product_amount = bill_product_amount;
	}
	public double getBill_product_money() {
		return bill_product_money;
	}
	public void setBill_product_money(double bill_product_money) {
		this.bill_product_money = bill_product_money;
	}
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
