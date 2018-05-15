/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.Review;
import model.User;

/**
 *
 * @author lenovo
 */
public class CommentDAO extends BaseDAO<Comment> {

    @Override
    public ArrayList<Comment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment get(long index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Comment t) {
        try {
            String sql = "INSERT INTO [Comment]\n"
                    + "           ([UserID]\n"
                    + "           ,[Content]\n"
                    + "           ,[Date]\n"
                    + "           ,[ReviewID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, t.getUser().getID());
            ps.setString(2, t.getContent());
            ps.setDate(3, new java.sql.Date(t.getDate().getTime()));
            ps.setLong(4, t.getReview().getID());
            int retVal = ps.executeUpdate();
            if (retVal > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Comment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Comment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Comment> getAllByReviewID(long reviewID) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[Content]\n"
                    + "      ,[Date]\n"
                    + "      ,[ReviewID]\n"
                    + "  FROM [Comment] \n"
                    + "  WHERE ReviewID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, reviewID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setID(rs.getLong(1));
                User u = new UserDAO().get(rs.getLong(2));
                c.setUser(u);
                c.setContent(rs.getString(3));
                c.setDate(rs.getDate(4));
                Review r = new ReviewDAO().get(rs.getLong(5));
                c.setReview(r);
                comments.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

}
