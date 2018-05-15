/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dal.BookDAO;
import java.util.ArrayList;
import model.Book;

/**
 *
 * @author lenovo
 */
public class SearchAction extends ActionSupport {
    private ArrayList<Book> books;
    private String searchInfo;
    @Override
    public String execute() {
        if (searchInfo.trim().length()==0) {
            return INPUT;
        }
        books = new BookDAO().searchBook(searchInfo);
        if (books.isEmpty()) {
            addFieldError("noresult", getText("error.noresult"));
            return INPUT;
        }
        return SUCCESS;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(String searchInfo) {
        this.searchInfo = searchInfo;
    }

    
}
