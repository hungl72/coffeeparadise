package daos;

import java.util.ArrayList;

import models.Permision;
import utils.DBConnectionUtil;
import utils.StringUtil;

public class PermisionDAO extends AbstractDAO{
	public ArrayList<Permision> listStaff(){
		Permision permision = null;
		ArrayList<Permision> listPermision = new ArrayList<Permision>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM permision WHERE per_name IN ('Admin', 'Moderator', 'Staff')");
			while(rs.next()) {
				permision = new Permision(rs.getInt("per_id"),
														  rs.getString("per_name"));
				listPermision.add(permision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listPermision;
	}
	public int insertStaff(String picture,String name,String email,String pass,String phone,Double salary,String calendar,int per_id) {
		int result=  0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("INSERT INTO staff (staff_image,staff_name,staff_email,staff_pass,staff_phone,staff_salary,staff_calendar,per_id) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, picture);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, StringUtil.md5("pass"));
			pst.setString(5, phone);
			pst.setDouble(6, salary);
			pst.setString(7, calendar);
			pst.setInt(8, per_id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public ArrayList<Permision> listPermision(int per_id){
		Permision permision = null;
		ArrayList<Permision> listPermision = new ArrayList<Permision>();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT DISTINCT permisiondetail.per_id,action,permisiondetail.check,permisiondetail.staff_id FROM staff INNER JOIN permisiondetail ON staff.per_id = permisiondetail.per_id WHERE staff.per_id = ?");
			pst.setInt(1, per_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				permision = new Permision(rs.getInt("per_id"), 
															rs.getString("action"), 
															rs.getInt("check"), 
															rs.getInt("staff_id"));
				listPermision.add(permision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return listPermision;
	}
	public void updateCheck(int check,String action,int staff_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE permisiondetail SET permisiondetail.check = ? WHERE permisiondetail.staff_id = ? AND permisiondetail.action = ?");
			pst.setInt(1, check);
			pst.setInt(2, staff_id);
			pst.setString(3, action);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public ArrayList<Permision> listUserAction(int user_id){
		Permision permision = null;
		ArrayList<Permision> listUserAction = new ArrayList<Permision>();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select s.staff_id,s.staff_image,s.staff_name,s.staff_email,pe.per_name,p.check,p.action from permisiondetail as p join staff as s on s.per_id = p.per_id join permision as pe on pe.per_id = p.per_id where s.staff_id = ?");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				permision = new Permision(rs.getInt("staff_id"), 
															rs.getString("staff_image"),
															rs.getString("staff_name"), 
															rs.getString("staff_email"), 
															rs.getString("per_name"),
															rs.getInt("check"),
															rs.getString("action"));
				listUserAction.add(permision);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUserAction;
	}
	public ArrayList<Permision> listUser(){
		Permision permision = null;
		ArrayList<Permision> listUser = new ArrayList<Permision>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select DISTINCT s.staff_id,s.staff_image,s.staff_name,s.staff_email,pe.per_name from permisiondetail as p join staff as s on s.per_id = p.per_id join permision as pe on pe.per_id = p.per_id and NOT p.staff_id = 4");
			while(rs.next()) {
				permision = new Permision(rs.getInt("staff_id"), 
															rs.getString("staff_image"),
															rs.getString("staff_name"), 
															rs.getString("staff_email"), 
															rs.getString("per_name"));
				listUser.add(permision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}
	public int checkAddDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select s.staff_name,pd.action,pd.check from staff AS s JOIN permisiondetail as pd on s.per_id= pd.per_id where s.staff_id = ? AND pd.action = 'ADD'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int checkEditDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select s.staff_name,pd.action,pd.check from staff AS s JOIN permisiondetail as pd on s.per_id= pd.per_id where s.staff_id = ? AND pd.action = 'EDIT'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int checkDelDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select s.staff_name,pd.action,pd.check from staff AS s JOIN permisiondetail as pd on s.per_id= pd.per_id where s.staff_id = ? AND pd.action = 'DEL'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
}
