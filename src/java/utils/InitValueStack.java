/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.opensymphony.xwork2.ActionSupport;
import dal.AuthorDAO;
import dal.BookDAO;
import dal.CategoryDAO;
import dal.ListDAO;
import dal.UserDAO;
import java.util.ArrayList;
import java.util.Map;
import model.Author;
import model.Book;
import model.BookRanking;
import model.Category;
import model.List;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class InitValueStack extends ActionSupport implements SessionAware {
    private ArrayList<Author> authors;
    private ArrayList<Category> categories;
    private ArrayList<Book> books;
    private ArrayList<List> lists;
    private ArrayList<User> users;
    private ArrayList<Integer> ranking;

    public ArrayList<Integer> getRanking() {
        ranking = new ArrayList<>();
        ranking.add(BookRanking.BAD);
        ranking.add(BookRanking.VERY_BAD);
        ranking.add(BookRanking.NEUTRAL);
        ranking.add(BookRanking.GOOD);
        ranking.add(BookRanking.VERY_GOOD);
        ranking.add(BookRanking.UNKNOWN);
        return ranking;
    }

    public void setRanking(ArrayList<Integer> ranking) {
        this.ranking = ranking;
    }
    
    public ArrayList<List> getLists() {
        return lists;
    }

    public void setLists(ArrayList<List> lists) {
        this.lists = lists;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    
    Map<String, Object> map;
    @Override
    public String execute() {
        System.out.println("hello from execute InitValueStack");
        AuthorDAO authorDB = new AuthorDAO();
        authors = authorDB.getAll();
        categories = new CategoryDAO().getAll();
        books = new BookDAO().getAll();
        users = new UserDAO().getAll();
        lists = new ListDAO().getAll();
        map.put("books", books);
        map.put("categories", categories);
        map.put("authors", authors);
        map.put("lists", lists);
        map.put("users", users);
        return SUCCESS;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
}
