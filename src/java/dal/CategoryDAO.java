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
import model.Category;

/**
 *
 * @author lenovo
 */
public class CategoryDAO extends BaseDAO<Category> {

    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "  FROM [Category]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category u = new Category();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                categories.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category get(long index) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "  FROM [Category] WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category u = new Category();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(Category t) {
        try {
            String sql = "INSERT INTO [Category]\n"
                    + "           ([Name])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Category> getAllCateOfBook(long bookID) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT bc.[CategoryID], c.Name\n"
                    + "  FROM [Book_Category] bc, Category c\n"
                    + "  WHERE bc.CategoryID = c.ID\n"
                    + "  AND BookID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, bookID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category u = new Category();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                categories.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

}
