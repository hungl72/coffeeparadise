package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Bill;
import models.Categories;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class CategoriesDAO extends AbstractDAO{
	public ArrayList<Categories> listCategories(){
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories");
			while(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),rs.getString("categories_name"));
				listCategories.add(categories);
			}
		} catch (Exception e) {
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listCategories;
	}
	public ArrayList<Categories> findAll() {
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories");
			while (rs.next()) {
				categories = new Categories(rs.getInt("categories_id"), 
														   rs.getString("categories_name"));
				listCategories.add(categories);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listCategories;
	}
	public ArrayList<Categories> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories ORDER BY categories_id DESC LIMIT ?,?";
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				categories = new Categories(rs.getInt("categories_id"), 
														   rs.getString("categories_name"));
				listCategories.add(categories);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listCategories;
	}
	public int insertCategories (String name) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("INSERT INTO categories (categories_name) VALUES (?)");
			pst.setString(1, name);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public int delCategories (int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("DELETE FROM categories WHERE categories_id = ?");
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public Categories categories (int id) {
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM categories WHERE categories_id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),
														  rs.getString("categories_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return categories;
	}
	public int updateCategories (int id,String name) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE categories SET categories_name = ? WHERE categories_id = ?");
			pst.setString(1, name);
			pst.setInt(2, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
}
