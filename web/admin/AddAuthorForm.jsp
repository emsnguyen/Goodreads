<%-- 
    Document   : AddBookForm
    Created on : Apr 28, 2018, 7:50:37 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>
            Thêm tác giả mới
        </h1>
        <s:form action="AddAuthor" namespace="/secure">
            <s:textfield key="name" requiredLabel="true"></s:textfield>
            <s:textarea cols="50" rows="20" key="description" requiredLabel="true"/>
            <s:submit value="Thêm tác giả mới"/>
        </s:form>
    </body>
</html>