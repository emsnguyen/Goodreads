<%-- 
    Document   : RedirectPage
    Created on : May 8, 2018, 11:10:49 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect Page</title>
    </head>
    <body>
        <c:redirect url="${session.backurl}"/>
        <br/>
    </body>
</html>
