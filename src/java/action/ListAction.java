/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dal.BookDAO;
import java.util.ArrayList;
import model.Book;

/**
 *
 * @author lenovo
 */
public class ListAction extends ActionSupport{
    private long categoryID;
    private ArrayList<Book> books;

    
    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    public String show() {
        return SUCCESS;
    }
    public String getByCategory() {
        BookDAO bookDB = new BookDAO();
        books = bookDB.getAllByCategory(categoryID);
        if (!books.isEmpty()) {
            return SUCCESS;
        }
        return ERROR;
    }
    
    
}
