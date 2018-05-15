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
import model.Author;
import model.List;

/**
 *
 * @author lenovo
 */
public class ListDAO extends BaseDAO<List> {

    @Override
    public ArrayList<List> getAll() {
        ArrayList<List> lists = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[CreatorID]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "      ,[Date]\n"
                    + "  FROM [List]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List l = new List();
                l.setID(rs.getLong(1));
                l.setName(rs.getString(2));
                l.setCreatorID(rs.getLong(3));
                l.setPoints(rs.getLong(4));
                l.setTotalVotes(rs.getLong(5));
                l.setDate(rs.getDate(6));
                lists.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public List get(long index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(List t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(List t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(List t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<List> getAllByBookID(long bookID) {
        ArrayList<List> lists = new ArrayList<>();
        try {
            String sql = "SELECT [ListID]\n"
                    + "  FROM [List_Book] WHERE BookID = ?";;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, bookID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long listID = rs.getLong(1);
                List l = this.get(listID);
                lists.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

}
