<%-- 
    Document   : login
    Created on : Apr 23, 2018, 3:00:16 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
    </head>
    <body>
        <div id="fb-root"></div>
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = 'https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.0&appId=219194265511076&autoLogAppEvents=1';
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
        <div class="fb-login-button" data-max-rows="1" data-size="large" 
             data-button-type="continue_with" data-show-faces="false" 
             data-auto-logout-link="false" data-use-continue-as="false"></div>
        <h1>Đăng nhập</h1>
        <s:form action="login" namespace="/">
            <s:textfield name="username" key="label.username" size="20"></s:textfield>
            <s:textfield name="password" key="label.password" size="20"></s:textfield>
            <s:submit key="label.login" align="center"></s:submit>
        </s:form>
    </body>
</html>
