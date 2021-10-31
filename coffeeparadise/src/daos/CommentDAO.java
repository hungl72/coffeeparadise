package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Bill;
import models.Categories;
import models.Comment;
import models.User;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class CommentDAO extends AbstractDAO{
	public void insertComment(String user,String detail,String time,String product_name,int product_id) {
		List<Comment> list = new ArrayList<>();
		con = DBConnectionUtil.getConnection();
		String sql = "insert into comments (comment_user,comment_detail,comment_time,product_name,product_id) values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user);pst.setString(2, detail);pst.setString(3, time);pst.setString(4, product_name);pst.setInt(5, product_id);
			int result = pst.executeUpdate();
			if(result > 0) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
	}
	public ArrayList<Comment> findAllComment() {
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		Comment comment = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM comments");
			while (rs.next()) {
				comment = new Comment(rs.getString("comment_user"),
						rs.getString("comment_detail"),
						rs.getString("comment_time"),
						rs.getInt("product_id"),
						rs.getString("product_name"));
				listComment.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listComment;
	}
	public ArrayList<Comment> findAll(int product_id) {
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		Comment comment = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM comments WHERE product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				comment = new Comment(rs.getString("comment_user"),
						rs.getString("comment_detail"),
						rs.getString("comment_time"),
						rs.getInt("product_id"),
						rs.getString("product_name"));
				listComment.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, st, con);}
		return listComment;
	}
	public ArrayList<Comment> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM comments ORDER BY comment_id DESC LIMIT ?,?";
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		Comment comment = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				comment = new Comment(rs.getString("comment_user"),
						rs.getString("comment_detail"),
						rs.getString("comment_time"),
						rs.getInt("product_id"),
						rs.getString("product_name"));
				listComment.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listComment;
	}
	public List<Comment> findAllComments() {
		Comment comment = null;
		List<Comment> listComment = new ArrayList<Comment>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from comments";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				comment = new Comment(rs.getInt("comment_id"),
						rs.getString("comment_user"), 
						rs.getString("comment_detail"), 
						rs.getString("comment_time"), 
						rs.getInt("product_id"),
						rs.getString("product_name"));
				listComment.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, st, con);
		}
		return listComment;
	}
}
