/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author lenovo
 */
public class AuthorizationInterceptor implements Interceptor {

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        System.out.println("inside authorization interceptor");
        ActionContext context = ai.getInvocationContext();

        //for login and register actions ignore checking
        if (context.getName().equalsIgnoreCase("login") || context.getName().equalsIgnoreCase("register")) {
            return ai.invoke();
        }
        SessionMap<String, Object> map = (SessionMap<String, Object>) ai.getInvocationContext().getSession();
        map.put("savedUrl", context.getName());
        if (map == null) {
            return "login";
        }
        Object user = map.get("username");
        if (user == null || user.equals("") || map.isEmpty() || map == null) {
            return "login";
        }

        return ai.invoke();
    }

}
