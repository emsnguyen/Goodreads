/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class RegisterAction extends ActionSupport implements ModelDriven, SessionAware {
    private User user = new User();
    private Map session;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public void validate() {
//        addActionError("Something went wrong. cannot be empty");
//        if (user.getUsername().trim().length()==0) {
//            addFieldError("username", getText("username.required"));
//        }
//        if (user.getEmail().trim().length()==0) {
//            addFieldError("email", getText("email.required"));
//        }
//        if (user.getPassword().trim().length()==0) {
//            addFieldError("password", getText("password.required"));
//        }
    }
    @Override
    public String execute() {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            addFieldError("username", getText("username.existed"));
            return ERROR;
        }
        session.put("username", user.getUsername());
        //insert new user to database
        
        return SUCCESS;

    }

    @Override
    public Object getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
