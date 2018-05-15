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

/**
 *
 * @author lenovo
 */
public class AuthorDAO extends BaseDAO<Author> {

    @Override
    public ArrayList<Author> getAll() {
        ArrayList<Author> authors = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "  FROM [Author]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Author u = new Author();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                authors.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authors;
    }

    @Override
    public Author get(long index) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "  FROM [Author] WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Author u = new Author();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean insert(Author t) {
        try {
            String sql = "INSERT INTO [Author]\n"
                    + "           ([Name]\n"
                    + "           ,[Description])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
