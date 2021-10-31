package daos;

import java.util.ArrayList;

import models.Management;
import utils.DBConnectionUtil;

public class ManagementDAO extends AbstractDAO{
	public ArrayList<Management> listOrder (int user_id){
		ArrayList<Management> listOrder = new ArrayList<Management>();
		Management management = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM bill WHERE user_id = ?");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				management = new Management(rs.getInt("bill_id"),
																	rs.getString("bill_product_name"),
																	rs.getInt("bill_product_amount"),
																	rs.getDouble("bill_product_money"),
																	rs.getString("date"),
																	//rs.getString("time"),
																	rs.getInt("status"));
					listOrder.add(management);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return listOrder;
	}
}
