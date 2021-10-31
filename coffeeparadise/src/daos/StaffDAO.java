package daos;

import java.util.ArrayList;

import models.Product;
import models.Staff;
import utils.DBConnectionUtil;
import utils.StringUtil;

public class StaffDAO extends AbstractDAO{
	public Staff login(String email, String pass) {
		Staff staff = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from staff INNER JOIN permisiondetail ON staff.per_id = permisiondetail.per_id INNER JOIN permision AS p ON p.per_id = permisiondetail.per_id where staff_email = ? and staff_pass = ?");
			pst.setString(1, email);pst.setString(2, StringUtil.md5(pass));
			rs = pst.executeQuery();
			while(rs.next()) {
				staff = new Staff(rs.getInt("staff_id"), 
										  rs.getString("staff_email"), 
										  rs.getString("staff_pass"), 
										  rs.getString("staff_name"), 
										  rs.getString("staff_image"),
										  rs.getInt("per_id"),
										  rs.getString("per_name"),
										  rs.getInt("check"),
										  rs.getString("action"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return staff;
	}
	public ArrayList<Staff> listDecentralization(){
		Staff staff = new Staff();
		ArrayList<Staff> listStaff = new ArrayList<Staff>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT staff.*,permision.per_name FROM staff INNER JOIN permision ON staff.per_id = permision.per_id WHERE staff.per_id = 1 OR staff.per_id = 2 OR staff.per_id = 3");
			while(rs.next()) {
				staff = new Staff(rs.getInt("staff_id"), 
										  rs.getString("staff_image"),
										  rs.getString("staff_name"), 
										  rs.getString("staff_email"), 
										  rs.getString("staff_pass"), 
										  rs.getString("staff_phone"), 
										  rs.getDouble("staff_salary"), 
										  rs.getString("staff_calendar"), 
										  rs.getInt("per_id"),
										  rs.getString("per_name"));
				listStaff.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return listStaff;
	}
	public ArrayList<Staff> listStaff(){
		Staff staff = null;
		ArrayList<Staff> listStaff = new ArrayList<Staff>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM staff WHERE per_id = 4");
			while(rs.next()) {
				staff = new Staff(rs.getInt("staff_id"),
										   rs.getString("staff_image"), 
										   rs.getString("staff_name"),
										   rs.getString("staff_email"),
										   rs.getString("staff_pass"),
										   rs.getString("staff_phone"),
										   rs.getDouble("staff_salary"),
										   rs.getString("staff_calendar"));
				listStaff.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(st, con);}
		return listStaff;
	}
	public Staff findStaffByStaffId(int staff_id){
		Staff staff = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from staff where staff_id = ?");
			pst.setInt(1, staff_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				staff = new Staff(rs.getInt("staff_id"),
										   rs.getString("staff_image"), 
										   rs.getString("staff_name"),
										   rs.getString("staff_email"),
										   rs.getString("staff_pass"),
										   rs.getString("staff_phone"),
										   rs.getDouble("staff_salary"),
										   rs.getString("staff_calendar"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return staff;
	}
	public int updateStaff(int staff_id,String staff_image,String staff_name,String staff_email,String staff_pass,String staff_phone,double staff_salary,String staff_calendar) {
		int result=  0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE staff SET staff_image = ?,staff_name = ?,staff_email = ?,staff_pass = ?,staff_phone = ?,staff_salary = ?,staff_calendar = ? WHERE staff_id = ?");
			pst.setString(1, staff_image);
			pst.setString(2, staff_name);
			pst.setString(3, staff_email);
			pst.setString(4, staff_pass);
			pst.setString(5, staff_phone);
			pst.setDouble(6, staff_salary);
			pst.setString(7, staff_calendar);
			pst.setInt(8, staff_id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public Staff findStaffDetailByStaffId(int staff_id) {
		Staff staff = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from staff where staff_id = ?");
			pst.setInt(1, staff_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				staff = new Staff(rs.getInt("staff_id"),
										   rs.getString("staff_image"), 
										   rs.getString("staff_name"),
										   rs.getString("staff_email"),
										   rs.getString("staff_pass"),
										   rs.getString("staff_phone"),
										   rs.getDouble("staff_salary"),
										   rs.getString("staff_calendar"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return staff;
	}
	public int delProduct (int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("DELETE FROM staff WHERE staff_id = ?");
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
}
