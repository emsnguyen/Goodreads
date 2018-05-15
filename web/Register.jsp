<%-- 
    Document   : Register
    Created on : Apr 23, 2018, 4:16:05 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng kí</title>
    </head>
    <body>
        <h1>Đăng kí</h1>
        <s:form action="register" method="POST">
            <s:i18n name="Register" >
                <s:textfield name="username" key="label.username" size="20" requiredLabel="true"></s:textfield>
            <s:textfield name="email" key="label.email" size="20" requiredLabel="true"></s:textfield>
            <s:textfield name="password" key="label.password" size="20" requiredLabel="true"></s:textfield>
            <%--<s:fielderror/>--%>
            <s:submit key="label.register" align="center"></s:submit>
            </s:i18n>
        </s:form>
    </body>
</html>
