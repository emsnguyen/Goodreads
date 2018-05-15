/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dal.AuthorDAO;
import dal.BookDAO;
import java.util.ArrayList;
import model.Author;
import model.Book;

/**
 *
 * @author lenovo
 */
public class AuthorAction extends ActionSupport {
    private long authorID;
    private Author author;
    private ArrayList<Book> books;
    public String show() {
        AuthorDAO authorDB = new AuthorDAO();
        author = authorDB.get(authorID);
        if (author != null) {
            books = new BookDAO().getAllByAuthor(authorID);
            return SUCCESS;
        }
        return ERROR;
    }
    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
