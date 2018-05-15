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
        <title>Goodreads</title>
        <s:head/>
    </head>
    <body>
        <h1>
            Thêm thể loại mới
        </h1>
        <s:form action="AddCategory" namespace="/secure">
            <s:textfield key="name" requiredLabel="true"></s:textfield>
            <s:submit value="Thêm thể loại mới"/>
        </s:form>
    </body>
</html>