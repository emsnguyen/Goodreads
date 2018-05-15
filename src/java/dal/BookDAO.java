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
import model.Book;

/**
 *
 * @author lenovo
 */
public class BookDAO extends BaseDAO<Book> {

    public ArrayList<Book> searchBook(String searchInfo) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[PublishedDate]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "  FROM [Book]\n"
                    + "  WHERE LOWER(Name) LIKE '%" + searchInfo.toLowerCase().trim() + "%' \n"
                    + "  OR LOWER(Description) LIKE '%" + searchInfo.toLowerCase().trim() + "%' \n";
            System.out.println("Query: " + sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book u = new Book();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                Author a = new AuthorDAO().get(rs.getLong(4));
                u.setAuthor(a);
                u.setPublishedDate(rs.getDate(5));
                u.setPoints(rs.getLong(6));
                u.setTotalVotes(rs.getLong(7));
                books.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public boolean insertBookCategory(long bookID, long categoryID) {
        try {
            String sql = "INSERT INTO [Book_Category]\n"
                    + "           ([BookID]\n"
                    + "           ,[CategoryID])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, bookID);
            ps.setLong(2, categoryID);
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Book> getAll() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[PublishedDate]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "  FROM [Book]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book u = new Book();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                Author a = new AuthorDAO().get(rs.getLong(4));
                u.setAuthor(a);
                u.setPublishedDate(rs.getDate(5));
                u.setPoints(rs.getLong(6));
                u.setTotalVotes(rs.getLong(7));
                books.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public ArrayList<Book> getAllByAuthor(long authorID) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[PublishedDate]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "  FROM [Book] WHERE AuthorID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, authorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book u = new Book();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                Author a = new AuthorDAO().get(rs.getLong(4));
                u.setAuthor(a);
                u.setPublishedDate(rs.getDate(5));
                u.setPoints(rs.getLong(6));
                u.setTotalVotes(rs.getLong(7));
                books.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public ArrayList<Book> getAllByCategory(long categoryID) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[PublishedDate]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "  FROM [Book] WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book u = new Book();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                Author a = new AuthorDAO().get(rs.getLong(4));
                u.setAuthor(a);
                u.setPublishedDate(rs.getDate(5));
                u.setPoints(rs.getLong(6));
                u.setTotalVotes(rs.getLong(7));
                books.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    @Override
    public Book get(long index) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[PublishedDate]\n"
                    + "      ,[Points]\n"
                    + "      ,[TotalVotes]\n"
                    + "  FROM [Book] where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book u = new Book();
                u.setID(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setDescription(rs.getString(3));
                Author a = new AuthorDAO().get(rs.getLong(4));
                u.setAuthor(a);
                u.setPublishedDate(rs.getDate(5));
                u.setPoints(rs.getLong(6));
                u.setTotalVotes(rs.getLong(7));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(Book t) {
        try {
            String sql = "INSERT INTO [Book]\n"
                    + "           ([Name]\n"
                    + "           ,[Description]\n"
                    + "           ,[AuthorID]\n"
                    + "           ,[PublishedDate]\n"
                    + "           ,[Points]\n"
                    + "           ,[TotalVotes])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            ps.setLong(3, t.getAuthor().getID());
            ps.setDate(4, new java.sql.Date(t.getPublishedDate().getTime()));
            ps.setLong(5, t.getPoints());
            ps.setLong(6, t.getTotalVotes());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
