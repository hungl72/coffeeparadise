package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Comment;
import models.Message;
import models.User;
import utils.DBConnectionUtil;

public class MessageDAO extends AbstractDAO{
	public void insertMessage(String message_sent,String message_time_sent,String name,int id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into message (message_sent,message_time_sent,name,id_user) values(?,?,?,?)");
			pst.setString(1, message_sent);pst.setString(2, message_time_sent);pst.setString(3, name);pst.setInt(4, id);
			int result = pst.executeUpdate();
			if(result > 0) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
	}
	public ArrayList<Message> findAll(int id) {
		ArrayList<Message> listMessage = new ArrayList<Message>();
		Message message = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM message where id_user = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getInt("message_id"),
														  rs.getString("message_sent"),
														  rs.getString("message_time_sent"),
														  rs.getString("name"));
				listMessage.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return listMessage;
	}
	public ArrayList<Message> updateMessage(int id) {
		ArrayList<Message> listMessage = new ArrayList<Message>();
		Message message = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM message ORDER BY id DESC LIMIT ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getInt("message_id"),
														  rs.getString("message_sent"),
														  rs.getString("message_time_sent"),
														  rs.getInt("id"),
														  rs.getString("name"));
				listMessage.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return listMessage;
	}
	public Message lastMessage(int id) {
		Message message = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT DISTINCT * FROM message WHERE id_user = ? AND name NOT IN ('Administrator', 'Admin', 'Moderator','Staff') ORDER BY message_id DESC LIMIT 1");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getInt("message_id"),
														  rs.getString("message_sent"),
														  rs.getString("message_time_sent"),
														  rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return message;
	}
	public ArrayList<Integer> numberUser(){
		ArrayList<Integer> numberUser = new ArrayList<Integer>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT DISTINCT id_user FROM message");
			while(rs.next()) {
				numberUser.add(rs.getInt("id_user"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return numberUser;
	}
	public ArrayList<String> nameUser(){
		ArrayList<String> nameUser = new ArrayList<String>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT DISTINCT name FROM message WHERE name NOT IN ( 'Administrator', 'Admin', 'Moderator','Staff' )");
			while(rs.next()) {
				nameUser.add(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return nameUser;
	}
	public ArrayList<User> checkStatus(){
		ArrayList<User> listCheckStatus = new ArrayList<User>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users WHERE status = 1");
			while(rs.next()) {
				listCheckStatus.add(new User(rs.getInt("user_id"),rs.getString("user_fullname"), rs.getString("user_email"), rs.getString("user_pass"), rs.getInt("status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return listCheckStatus;
	}
	public User listOnline(){
		User listOnline = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(status) AS status FROM users WHERE status = 1");
			while(rs.next()) {
				listOnline = new User(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return listOnline;
	}
	public User listOffline(){
		User listOffline = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(status) AS status FROM users WHERE status = 0");
			while(rs.next()) {
				listOffline = new User(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return listOffline;
	}
}
