package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Bill;
import models.Categories;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class BillDAO extends AbstractDAO{
	public int addBill(int bill_product_id, String bill_product_image, String bill_product_name,
	double bill_product_price,double bill_product_promotion, int bill_product_amount, double bill_product_money, String user_fullname,
	int user_id,String date,int staff_id,int status) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into bill (bill_product_id,bill_product_image,bill_product_name,bill_product_price,bill_product_promotion,bill_product_amount,bill_product_money,user_fullname,user_id,date,staff_id,status) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, bill_product_id);
			pst.setString(2, bill_product_image);
			pst.setString(3, bill_product_name);
			pst.setDouble(4, bill_product_price);
			pst.setDouble(5, bill_product_promotion);
			pst.setInt(6, bill_product_amount);
			pst.setDouble(7, bill_product_money);
			pst.setString(8, user_fullname);
			pst.setInt(9, user_id);
			pst.setString(10, date);
			pst.setInt(11, staff_id);
			pst.setInt(12, status);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public ArrayList<Bill> listBill(){
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		Bill bill = new Bill();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from bill");
			while(rs.next()) {
				bill = new Bill(rs.getInt("bill_id"),
										rs.getInt("bill_product_id"), 
										rs.getString("bill_product_image"), 
										rs.getString("bill_product_name"), 
										rs.getDouble("bill_product_price"), 
										rs.getDouble("bill_product_promotion"),
										rs.getInt("bill_product_amount"), 
										rs.getDouble("bill_product_money"), 
										rs.getString("user_fullname"), 
										rs.getInt("user_id"), 
										rs.getString("date"));
				listBill.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs , st, con);}
		return listBill;
	}
	public ArrayList<Bill> findAll() {
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		Bill bill = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from bill");
			while (rs.next()) {
				bill = new Bill(rs.getInt("bill_id"),
						rs.getInt("bill_product_id"), 
						rs.getString("bill_product_image"), 
						rs.getString("bill_product_name"), 
						rs.getDouble("bill_product_price"), 
						rs.getDouble("bill_product_promotion"),
						rs.getInt("bill_product_amount"), 
						rs.getDouble("bill_product_money"), 
						rs.getString("user_fullname"), 
						rs.getInt("user_id"), 
						rs.getString("date"));
					listBill.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listBill;
	}
	public ArrayList<Bill> findAllStaff(int staff_id) {
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		Bill bill = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from bill where staff_id = ?");
			pst.setInt(1, staff_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				bill = new Bill(rs.getInt("bill_id"),
						rs.getInt("bill_product_id"), 
						rs.getString("bill_product_image"), 
						rs.getString("bill_product_name"), 
						rs.getDouble("bill_product_price"), 
						rs.getDouble("bill_product_promotion"),
						rs.getInt("bill_product_amount"), 
						rs.getDouble("bill_product_money"), 
						rs.getString("user_fullname"), 
						rs.getInt("user_id"), 
						rs.getString("date"));
					listBill.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listBill;
	}
	public ArrayList<Bill> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM bill ORDER BY bill_id DESC LIMIT ?,?";
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		Bill bill = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				bill = new Bill(rs.getInt("bill_id"),
						rs.getInt("bill_product_id"), 
						rs.getString("bill_product_image"), 
						rs.getString("bill_product_name"), 
						rs.getDouble("bill_product_price"), 
						rs.getDouble("bill_product_promotion"),
						rs.getInt("bill_product_amount"), 
						rs.getDouble("bill_product_money"), 
						rs.getString("user_fullname"), 
						rs.getInt("user_id"), 
						rs.getString("date"),
						rs.getInt("status"));
					listBill.add(bill);
			};
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listBill;
	}
	public ArrayList<Bill> getItemPaginationByStaff(int offset,int staff_id) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM bill WHERE staff_id = ? ORDER BY bill_id DESC LIMIT ?,?";
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		Bill bill = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, staff_id);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				bill = new Bill(rs.getInt("bill_id"),
						rs.getInt("bill_product_id"), 
						rs.getString("bill_product_image"), 
						rs.getString("bill_product_name"), 
						rs.getDouble("bill_product_price"), 
						rs.getDouble("bill_product_promotion"),
						rs.getInt("bill_product_amount"), 
						rs.getDouble("bill_product_money"), 
						rs.getString("user_fullname"), 
						rs.getInt("user_id"), 
						rs.getString("date"),
						rs.getInt("status"));
					listBill.add(bill);
			};
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listBill;
	}
	public void updateCheck(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 1 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateCancell(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 8 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateCancel(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 3 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateUndo(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 0 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateRequest(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 6 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void updateRefuse(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 5 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void approvalOk(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = 2 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public void approvalCancel(int bill_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("UPDATE bill SET status = -1 WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(pst, con);}
	}
	public int waitingApproval() {
		int dem = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(status) FROM bill WHERE status = 0");
			if(rs.next()) {
				dem = rs.getInt("COUNT(status)");
			}else {
				dem = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return dem;
	}
	public int approved() {
		int dem = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(status) FROM bill WHERE status = 2");
			if(rs.next()) {
				dem = rs.getInt("COUNT(status)");
			}else {
				dem = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return dem;
	}
	public int shipComplete() {
		int dem = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(status) FROM bill WHERE status = 1");
			if(rs.next()) {
				dem = rs.getInt("COUNT(status)");
			}else {
				dem = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return dem;
	}
	public int checkStatus(int bill_id) {
		int status = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT status FROM bill WHERE bill_id = ?");
			pst.setInt(1, bill_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				status = rs.getInt("status");
			}
		} catch (Exception e) {
				e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return status;
	}
}
