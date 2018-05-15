<%-- 
    Document   : CheckLogIn
    Created on : Apr 29, 2018, 10:51:15 AM
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="#session.username == ''">
        <c:redirect url="../Login.jsp"/>
        </s:if>
    </body>
</html>
