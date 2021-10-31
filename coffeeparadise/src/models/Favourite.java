package models;

public class Favourite {
	private int favourite_id;
	private String favourite_name;
	private double favourite_price;
	private double favourite_promotion;
	private String favourite_image;
	private int product_id;
	private int user_id;
	public Favourite() {
		super();
	}
	public Favourite(int favourite_id, String favourite_name, double favourite_price, double favourite_promotion,
			String favourite_image, int product_id, int user_id) {
		super();
		this.favourite_id = favourite_id;
		this.favourite_name = favourite_name;
		this.favourite_price = favourite_price;
		this.favourite_promotion = favourite_promotion;
		this.favourite_image = favourite_image;
		this.product_id = product_id;
		this.user_id = user_id;
	}
	public Favourite(String favourite_name, double favourite_price, double favourite_promotion,
			String favourite_image, int product_id) {
		super();
		this.favourite_name = favourite_name;
		this.favourite_price = favourite_price;
		this.favourite_promotion = favourite_promotion;
		this.favourite_image = favourite_image;
		this.product_id = product_id;
	}
	public int getFavourite_id() {
		return favourite_id;
	}
	public void setFavourite_id(int favourite_id) {
		this.favourite_id = favourite_id;
	}
	public String getFavourite_name() {
		return favourite_name;
	}
	public void setFavourite_name(String favourite_name) {
		this.favourite_name = favourite_name;
	}
	public double getFavourite_price() {
		return favourite_price;
	}
	public void setFavourite_price(double favourite_price) {
		this.favourite_price = favourite_price;
	}
	public double getFavourite_promotion() {
		return favourite_promotion;
	}
	public void setFavourite_promotion(double favourite_promotion) {
		this.favourite_promotion = favourite_promotion;
	}
	public String getFavourite_image() {
		return favourite_image;
	}
	public void setFavourite_image(String favourite_image) {
		this.favourite_image = favourite_image;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
