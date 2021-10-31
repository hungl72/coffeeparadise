package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Product;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class ProductDAO extends AbstractDAO{
	public ArrayList<Product> listProduct(){
		ArrayList<Product> listProduct = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"), 
													rs.getString("product_description"), 
													rs.getString("product_image"), 
													rs.getDouble("product_price"), 
													rs.getInt("categories_id"), 
													rs.getString("categories_name"), 
													rs.getInt("views"),
													rs.getString("product_description_detail"),
													rs.getDouble("promotion"));
				listProduct.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}
	public Product findProductDetailByProductId(int product_id){
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM product WHERE product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"), 
													rs.getString("product_description"), 
													rs.getString("product_image"), 
													rs.getDouble("product_price"), 
													rs.getInt("categories_id"), 
													rs.getString("categories_name"), 
													rs.getInt("views"),
													rs.getString("product_description_detail"),
													rs.getDouble("promotion"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return product;
	}
	public ArrayList<Product> listProductByCategories(int categories_id){
		ArrayList<Product> listProduct = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from product where categories_id = ?");
			pst.setInt(1, categories_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"), 
													rs.getString("product_description"), 
													rs.getString("product_image"), 
													rs.getDouble("product_price"), 
													rs.getInt("categories_id"), 
													rs.getInt("views"));
				listProduct.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProduct;
	}
	public Product findProductByProductId(int product_id){
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from product where product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"), 
													rs.getString("product_description"), 
													rs.getString("product_image"), 
													rs.getDouble("product_price"), 
													rs.getInt("categories_id"), 
													rs.getString("categories_name"),
													rs.getInt("views"),
													rs.getString("product_description_detail"),
													rs.getDouble("promotion"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return product;
	}
	public ArrayList<Product> listProductNew(){
		ArrayList<Product> listProductNew = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM product ORDER BY product_id DESC LIMIT 3");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
						rs.getString("product_name"), 
						rs.getString("product_description"), 
						rs.getString("product_image"), 
						rs.getDouble("product_price"), 
						rs.getInt("categories_id"), 
						rs.getInt("views"),
						rs.getString("product_description_detail"),
						rs.getDouble("promotion"));
				listProductNew.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listProductNew;
	}
	public void updateView(int product_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE product SET views = views + 1 where product_id = ?");
			pst.setInt(1, product_id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {DBConnectionUtil.close(rs, pst, con);}
	}
	public ArrayList<Product> listViews(){
		ArrayList<Product> listViews = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM product ORDER BY views DESC LIMIT 3");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
						rs.getString("product_name"), 
						rs.getString("product_description"), 
						rs.getString("product_image"), 
						rs.getDouble("product_price"), 
						rs.getInt("categories_id"), 
						rs.getInt("views"),
						rs.getString("product_description_detail"),
						rs.getDouble("promotion"));
				listViews.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listViews;
	}
	public ArrayList<Product> findProductByName(String name){
		ArrayList<Product> listProduct = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM product WHERE product_name LIKE ?");
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"), 
													rs.getString("product_description"), 
													rs.getString("product_image"));
				listProduct.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProduct;
	}
	public ArrayList<Product> findAll() {
		ArrayList<Product> listProduct = new ArrayList<Product>();
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
						rs.getString("product_name"), 
						rs.getString("product_description"), 
						rs.getString("product_image"), 
						rs.getDouble("product_price"), 
						rs.getInt("categories_id"), 
						rs.getInt("views"),
						rs.getString("product_description_detail"),
						rs.getDouble("promotion"));
				listProduct.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}
	public Product findNameProductByProductId(int product_id) {
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT product.product_name FROM categories INNER JOIN product ON categories.categories_id = product.categories_id WHERE product.product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString("product_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return product;
	}
	public ArrayList<Product> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM product ORDER BY product_id DESC LIMIT ?,?";
		ArrayList<Product> listProduct = new ArrayList<Product>();
		Product product = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
						rs.getString("product_name"), 
						rs.getString("product_description"), 
						rs.getString("product_image"), 
						rs.getDouble("product_price"), 
						rs.getInt("categories_id"), 
						rs.getString("categories_name"),
						rs.getInt("views"),
						rs.getString("product_description_detail"),
						rs.getDouble("promotion"));
				listProduct.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listProduct;
	}
	public int insertProduct(String picture,String name,int categories_id,String categories_name,String description,double price,double promotion,String descriptiondetail) {
		int result=  0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("INSERT INTO product (product_name,product_description,product_image,product_price,categories_id,categories_name,views,product_description_detail,promotion) VALUES (?,?,?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setString(3, picture);
			pst.setDouble(4, price);
			pst.setInt(5, categories_id);
			pst.setString(6, categories_name);
			pst.setInt(7, 0);
			pst.setString(8, descriptiondetail);
			pst.setDouble(9, promotion);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int updateProduct(String picture,String name,int categories_id,String categories_name,String description,double price,double promotion,String descriptiondetail,int product_id) {
		int result=  0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE product SET product_name = ?,product_description = ?,product_image = ?,product_price = ?,categories_id = ?,categories_name = ?,product_description_detail = ?,promotion = ? WHERE product_id = ?");
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setString(3, picture);
			pst.setDouble(4, price);
			pst.setInt(5, categories_id);
			pst.setString(6, categories_name);
			pst.setString(7, descriptiondetail);
			pst.setDouble(8, promotion);
			pst.setInt(9, product_id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int delProduct (int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("DELETE FROM product WHERE product_id = ?");
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
}
