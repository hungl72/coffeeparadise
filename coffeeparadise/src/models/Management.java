package models;

public class Management {
	private int bill_id;
	private String list_product;
	private int amount;
	private double money;
	private String date;
	private String time;
	private int state;
	public Management() {
		super();
	}
	public Management(int bill_id, String list_product, int amount, double money, String date, String time, int state) {
		super();
		this.bill_id = bill_id;
		this.list_product = list_product;
		this.amount = amount;
		this.money = money;
		this.date = date;
		this.time = time;
		this.state = state;
	}
	public Management(int bill_id, String list_product, int amount, double money, String date, int state) {
		super();
		this.bill_id = bill_id;
		this.list_product = list_product;
		this.amount = amount;
		this.money = money;
		this.date = date;
		this.state = state;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getList_product() {
		return list_product;
	}
	public void setList_product(String list_product) {
		this.list_product = list_product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
