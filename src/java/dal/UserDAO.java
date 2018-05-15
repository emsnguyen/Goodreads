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
import model.User;

/**
 *
 * @author lenovo
 */
public class UserDAO extends BaseDAO<User> {

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Email]\n"
                    + "      ,[Password]\n"
                    + "      ,[Description]\n"
                    + "      ,[Points]\n"
                    + "  FROM [User]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setID(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDescription(rs.getString(5));
                u.setPoints(rs.getLong(6));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User get(String username, String password) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Email]\n"
                    + "      ,[Password]\n"
                    + "      ,[Description]\n"
                    + "      ,[Points]\n"
                    + "  FROM [User]\n"
                    + "  WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setID(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDescription(rs.getString(5));
                u.setPoints(rs.getLong(6));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User get(long index) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Email]\n"
                    + "      ,[Password]\n"
                    + "      ,[Description]\n"
                    + "      ,[Points]\n"
                    + "  FROM [User]\n"
                    + "  WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setID(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDescription(rs.getString(5));
                u.setPoints(rs.getLong(6));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
