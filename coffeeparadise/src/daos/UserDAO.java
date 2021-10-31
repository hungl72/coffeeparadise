package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Bill;
import models.User;
import utils.DBConnectionUtil;
import utils.DefineUtil;
import utils.StringUtil;

public class UserDAO extends AbstractDAO{
	public User login(String name, String pass) {
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from users where user_email = ? and user_pass = ?");
			pst.setString(1, name);pst.setString(2, StringUtil.md5(pass));
			rs = pst.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("user_fullname"), rs.getString("user_email"), rs.getString("user_pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return user;
	}
	public int signup(String name,String email ,String pass) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into users (user_fullname,user_email,user_pass) values (?,?,?)");
			pst.setString(1, name);pst.setString(2, email);pst.setString(3, StringUtil.md5(pass));
			result = pst.executeUpdate();
			if(result > 0) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public ArrayList<User> listUser(){
		ArrayList<User> listUser = new ArrayList<User>();
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from users");
			while(rs.next()) {
				user = new User(rs.getInt("user_id"), 
											rs.getString("user_fullname"), 
											rs.getString("user_email"), 
											rs.getString("user_pass"));
				listUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listUser;
	}
	public ArrayList<User> findAll() {
		ArrayList<User> listUser = new ArrayList<User>();
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from users");
			while(rs.next()) {
				user = new User(rs.getInt("user_id"), 
											rs.getString("user_fullname"), 
											rs.getString("user_email"), 
											rs.getString("user_pass"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listUser;
	}
	public ArrayList<User> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM users ORDER BY user_id DESC LIMIT ?,?";
		ArrayList<User> listUser = new ArrayList<User>();
		User user = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_id"), 
											rs.getString("user_fullname"), 
											rs.getString("user_email"), 
											rs.getString("user_pass"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listUser;
	}
	public void updateStatusLogout(int id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE users SET status = 0 WHERE user_id = ?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateStatusLogin(int id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE users SET status = 1 WHERE user_id = ?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
	}
}
