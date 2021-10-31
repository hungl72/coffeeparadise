package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Bill;
import models.Contact;
import models.User;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class ContactDAO extends AbstractDAO{
	public int addContact(String name, String phone, String title, String content, String email) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("INSERT INTO contact (contact_name,contact_phone,contact_title,contact_content,contact_email) VALUES (?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, title);
			pst.setString(4, content);
			pst.setString(5, email);
			result = pst.executeUpdate();
		} catch (Exception e) {
		} finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public ArrayList<Contact> listContact(){
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		Contact contact = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from contact");
			while(rs.next()) {
				contact = new Contact(rs.getString("contact_name"), 
													 rs.getString("contact_phone"), 
													 rs.getString("contact_title"), 
													 rs.getString("contact_content"), 
													 rs.getString("contact_email"));
				listContact.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listContact;
	}
	public ArrayList<Contact> findAll() {
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		Contact contact = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from contact");
			while(rs.next()) {
				contact = new Contact(rs.getString("contact_name"), 
													 rs.getString("contact_phone"), 
													 rs.getString("contact_title"), 
													 rs.getString("contact_content"), 
													 rs.getString("contact_email"));
				listContact.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listContact;
	}
	public ArrayList<Contact> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM contact ORDER BY contact_id DESC LIMIT ?,?";
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		Contact contact = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				contact = new Contact(rs.getString("contact_name"), 
													 rs.getString("contact_phone"), 
													 rs.getString("contact_title"), 
													 rs.getString("contact_content"), 
													 rs.getString("contact_email"));
				listContact.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listContact;
	}
}
