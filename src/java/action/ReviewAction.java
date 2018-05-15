/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import dal.ReviewDAO;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Review;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class ReviewAction extends ActionSupport implements SessionAware {
    private String newReview;
    private long bookID;
    Map<String, Object> map;

    public long getBookID() {
        return bookID;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
    public String checkLogin() {
        System.out.println("log: " + LOG);
        HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String backurl = request.getHeader("referer");
        System.out.println("backurl: " + backurl);
        map.put("backurl", backurl);
        if (map.get("username") == null) {
            return "notLoggedIn";
        }
        long userID = (long) map.get("userID");
        Review r = new Review();
        r.setBookID(bookID);
        r.setContent(newReview);
        r.setDate(new Date());
        r.setPoints(0);
        r.setTotalVotes(0);
        r.setUserID(userID);
        System.out.println("bookID: " + bookID);
        ReviewDAO rvDB = new ReviewDAO();
        if (rvDB.insert(r)) {
            return SUCCESS;
        } 
        return ERROR;
    }
    public String add() {
        String loggedIn = checkLogin();
        if (loggedIn.equals("notLoggedIn")) {
            return loggedIn;
        }
        //if logged in then continue
        
        return SUCCESS;
    }
    public String list() {
        String loggedIn = checkLogin();
        if (loggedIn.equals("notLoggedIn")) {
            return loggedIn;
        }
        //if logged in then continue
        //list all the books I am reading
        return SUCCESS;
    }
    public String show() {
        return checkLogin();
    }

    public String getNewReview() {
        return newReview;
    }

    public void setNewReview(String newReview) {
        this.newReview = newReview;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
}
