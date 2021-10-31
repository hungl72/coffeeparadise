package models;

public class Product {
	private int product_id;
	private String product_name;
	private String product_description;
	private String product_image;
	private double product_price;
	private int categories_id;
	private String categories_name;
	private int views;
	private String product_description_detail;
	private double promotion;
	public Product() {
		super();
	}
	public Product(int product_id, String product_name, String product_description, String product_image,
			double product_price, int categories_id, String categories_name,int views) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
		this.product_price = product_price;
		this.categories_id = categories_id;
		this.categories_name = categories_name;
		this.views = views;
	}
	public Product(String product_name) {
		super();
		this.product_name = product_name;
	}
	public Product(int product_id, String product_name, String product_description, String product_image,
			double product_price, int categories_id, int views) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
		this.product_price = product_price;
		this.categories_id = categories_id;
		this.views = views;
	}
	public Product(int product_id, String product_name, String product_image,
			double product_price, double promotion) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.promotion = promotion;
	}
	public Product(int product_id, String product_name, String product_description, String product_image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
	}
	public Product(int product_id) {
		super();
		this.product_id = product_id;
	}
	public Product(int product_id, String product_name, String product_description, String product_image,
			double product_price, int categories_id, int views, String product_description_detail, double promotion) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
		this.product_price = product_price;
		this.categories_id = categories_id;
		this.views = views;
		this.product_description_detail = product_description_detail;
		this.promotion = promotion;
	}
	public Product(int product_id, String product_name, String product_description, String product_image,
			double product_price, int categories_id, String categories_name, int views, String product_description_detail, double promotion) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
		this.product_price = product_price;
		this.categories_id = categories_id;
		this.categories_name = categories_name;
		this.views = views;
		this.product_description_detail = product_description_detail;
		this.promotion = promotion;
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
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	
	public String getCategories_name() {
		return categories_name;
	}
	public void setCategories_name(String categories_name) {
		this.categories_name = categories_name;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getProduct_description_detail() {
		return product_description_detail;
	}
	public void setProduct_description_detail(String product_description_detail) {
		this.product_description_detail = product_description_detail;
	}
	public double getPromotion() {
		return promotion;
	}
	public void setPromotion(double promotion) {
		this.promotion = promotion;
	}
	
}
