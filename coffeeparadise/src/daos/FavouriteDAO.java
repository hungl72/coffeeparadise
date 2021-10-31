package daos;

import java.util.ArrayList;

import models.Favourite;
import models.Product;
import utils.DBConnectionUtil;

public class FavouriteDAO extends AbstractDAO{
	public void addFavourite(String favourite_name,double favourite_price,double favourite_promotion,String favourite_image,int product_id,int user_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into favourite (favourite_name,favourite_price,favourite_promotion,favourite_image,product_id,user_id) values (?,?,?,?,?,?)");
			pst.setString(1, favourite_name);
			pst.setDouble(2, favourite_price);
			pst.setDouble(3,favourite_promotion);
			pst.setString(4, favourite_image);
			pst.setInt(5, product_id);
			pst.setInt(6, user_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public Product findProduct(int product_id) {
		Product product = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT product_id,product_image,product_name,product_price,promotion FROM product WHERE product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getInt("product_id"),
						rs.getString("product_name"), 
						rs.getString("product_image"), 
						rs.getDouble("product_price"), 
						rs.getDouble("promotion"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return product;
	}
	public ArrayList<Favourite> findProductByUserId(int user_id) {
		ArrayList<Favourite> listFavourite = new ArrayList<Favourite>();
		Favourite favourite = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT DISTINCT favourite_name,favourite_price,favourite_promotion,favourite_image,product_id,user_id FROM favourite WHERE user_id = ?");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				favourite = new Favourite(rs.getString("favourite_name"),
														rs.getDouble("favourite_price"), 
														rs.getDouble("favourite_promotion"), 
														rs.getString("favourite_image"), 
														rs.getInt("product_id"));
				listFavourite.add(favourite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return listFavourite;
	}
	public int delProductByUserId(int user_id,String favourite_name) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("DELETE FROM favourite WHERE user_id = ? AND favourite_name = ?");
			pst.setInt(1, user_id);
			pst.setString(2, favourite_name);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}

}
