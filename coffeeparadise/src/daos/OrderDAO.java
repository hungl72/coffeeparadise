package daos;

import utils.DBConnectionUtil;

public class OrderDAO extends AbstractDAO{
	public int addOrder(String order_image, String order_name, int order_amount, double order_price,
			double order_money, String order_user, int order_user_id, String order_date, int staff_id, int bill_id,
			int status) {
				int result = 0;
				con = DBConnectionUtil.getConnection();
				try {
					pst = con.prepareStatement("insert into order (order_image,order_name,order_amount,order_price,order_money,order_user,order_user_id,order_date,staff_id,bill_id,status) values (?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, order_image);
					pst.setString(2, order_name);
					pst.setInt(3, order_amount);
					pst.setDouble(4, order_price);
					pst.setDouble(5, order_money);
					pst.setString(6, order_user);
					pst.setInt(7, order_user_id);
					pst.setString(8, order_date);
					pst.setInt(9, staff_id);
					pst.setInt(10, bill_id);
					pst.setInt(11, status);
					result = pst.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}	finally {DBConnectionUtil.close(pst, con);}
				return result;
			}
}
