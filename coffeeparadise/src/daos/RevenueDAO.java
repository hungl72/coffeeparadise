package daos;

import utils.DBConnectionUtil;

public class RevenueDAO extends AbstractDAO{
	public double revenue() {
		double revenue = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT SUM(bill_product_money) FROM bill WHERE CURRENT_DATE() - date = 0 AND status = 1");
			if(rs.next()) {
			revenue = rs.getDouble("SUM(bill_product_money)");
			}else {
				revenue = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return revenue;
	}
	public double revenueTo7Days() {
		double revenue = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT SUM(bill_product_money) FROM bill WHERE CURRENT_DATE() - date < 3 AND status = 1");
			if(rs.next()) {
			revenue = rs.getDouble("SUM(bill_product_money)");System.out.println("revenue"+revenue+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return revenue;
	}
}
