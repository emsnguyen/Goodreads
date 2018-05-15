/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class LogoutAction extends ActionSupport implements SessionAware {
    Map<String, Object> map;
    @Override
    public String execute() {
        map.clear();
        return SUCCESS;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
    
}
