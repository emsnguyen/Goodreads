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
import model.Review;

/**
 *
 * @author lenovo
 */
public class ReviewDAO extends BaseDAO<Review> {

    @Override
    public ArrayList<Review> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Review> getAllByBookID(long bookID) {
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[Content]\n"
                    + "      ,[Date]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "      ,[BookID]\n"
                    + "  FROM [Review] where BookID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, bookID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review r = new Review();
                r.setID(rs.getLong(1));
                r.setUserID(rs.getLong(2));
                r.setContent(rs.getString(3));
                r.setDate(rs.getDate(4));
                r.setPoints(rs.getLong(5));
                r.setTotalVotes(rs.getLong(6));
                r.setBookID(rs.getLong(7));
                reviews.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    }

    @Override
    public Review get(long index) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[Content]\n"
                    + "      ,[Date]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "      ,[BookID]\n"
                    + "  FROM [Review] \n"
                    + "  WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Review r = new Review();
                r.setID(index);
                r.setUserID(rs.getLong(2));
                r.setContent(rs.getString(3));
                r.setDate(rs.getDate(4));
                r.setPoints(rs.getLong(5));
                r.setTotalVotes(rs.getLong(6));
                r.setBookID(rs.getLong(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(Review t) {
        try {
            String sql = "INSERT INTO [Review]\n"
                    + "           ([UserID]\n"
                    + "           ,[Content]\n"
                    + "           ,[Date]\n"
                    + "           ,[Points]\n"
                    + "           ,[TotalVotes]\n"
                    + "           ,[BookID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, t.getUserID());
            ps.setString(2, t.getContent());
            ps.setDate(3, new java.sql.Date(t.getDate().getTime()));
            ps.setLong(4, t.getPoints());
            ps.setLong(5, t.getTotalVotes());
            ps.setLong(6, t.getBookID());
            int retVal = ps.executeUpdate();
            if (retVal > 0) {
                System.out.println("added a new reiew");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Review t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Review t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
