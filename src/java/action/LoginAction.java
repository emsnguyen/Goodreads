/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dal.UserDAO;
import java.util.Map;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class LoginAction extends ActionSupport implements ModelDriven, SessionAware {
    User user = new User();
    Map<String, Object> map;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public void validate() {
//        addActionError("Something went wrong. cannot be empty");
        if (user.getUsername().trim().length()==0) {
            addFieldError("username", getText("username.required"));
        }
        if (user.getPassword().trim().length()==0) {
            addFieldError("password", getText("password.required"));
        }
        user = new UserDAO().get(user.getUsername(), user.getPassword());
        if (user == null) {
            addFieldError("password", getText("login.incorrect"));
        }
    }
    @Override
    public String execute() {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return "admin";
        }
        map.put("username", user.getUsername());
        map.put("userID", user.getID());
        String backurl = (String)map.get("backurl");
        System.out.println("backurl in login action: " + backurl);
        if (backurl != null) {
            System.out.println("LoginAction returning redirect");
            return "redirect";
        }
        return SUCCESS;
    }

    @Override
    public Object getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
}
