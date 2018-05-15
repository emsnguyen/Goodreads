/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dal.CommentDAO;
import dal.ReviewDAO;
import dal.UserDAO;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Comment; 
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author lenovo
 */
public class CommentAction extends ActionSupport {
    String newComment;
    long reviewID;

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }
    
    public String checkLogin() {
        HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String backurl = request.getHeader("referer");
        System.out.println("backurl: " + backurl);
        Map session = ActionContext.getContext().getSession();
        session.put("backurl", backurl);
        if (session.get("username") == null) {
            return "notLoggedIn";
        }
        System.out.println("reviewID: " + reviewID);
        long userID = (long) session.get("userID");
        Comment c = new Comment();
        c.setDate(new Date());
        c.setContent(newComment);
        c.setReview(new ReviewDAO().get(reviewID));
        c.setUser(new UserDAO().get(userID));
        CommentDAO cmtDB = new CommentDAO();
        if (cmtDB.insert(c)) {
            return SUCCESS;
        } 
        return ERROR;
    }
    public String add() {
        return checkLogin();
    }
}
