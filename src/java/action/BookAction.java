package action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import dal.BookDAO;
import dal.CategoryDAO;
import dal.CommentDAO;
import dal.ListDAO;
import dal.ReviewDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Author;
import model.Book;
import model.Category;
import model.Comment;
import model.List;
import model.Review;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class BookAction implements SessionAware {
    private ArrayList<Category> categories;
    private long bookID;
    private Map<String, Object> map;
    private ArrayList<Review> reviews;
    private ArrayList<Comment> comments;
    private ArrayList<List> lists;
    private Map<Review, ArrayList<Comment>> mapReviewComment;
    private Map<Review, ArrayList<Long>> mapReviewRating;
    private Book book;
    private Author author;

    public ArrayList<List> getLists() {
        return lists;
    }

    public void setLists(ArrayList<List> lists) {
        this.lists = lists;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public String add() {
        return ERROR;
    }
    public String show() {
        //get my ranking for this book
        BookDAO bookDB = new BookDAO();
        //get book info
        book = bookDB.get(bookID);
        if (book != null) {
            //get author and categories
            categories = new CategoryDAO().getAllCateOfBook(bookID);
            
            //get all reviews
            reviews = new ReviewDAO().getAllByBookID(bookID);
            
            //a map to get the rating of each reviewer for this book (shown in the review)
            
            
            //get all comments if a review exists
            if (!reviews.isEmpty()) {
                mapReviewComment = new HashMap<>();
                for (Review r : reviews) {
                    comments = new CommentDAO().getAllByReviewID(r.getID());
                    mapReviewComment.put(r, comments);
                }
            }
            
            // get all lists containing this book
            lists = new ListDAO().getAllByBookID(bookID);
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Map<Review, ArrayList<Comment>> getMapReviewComment() {
        return mapReviewComment;
    }

    public void setMapReviewComment(Map<Review, ArrayList<Comment>> mapReviewComment) {
        this.mapReviewComment = mapReviewComment;
    }
}
