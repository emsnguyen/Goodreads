<%-- 
    Document   : AddBookForm
    Created on : Apr 28, 2018, 7:50:37 AM
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            Thêm sách mới
        </h1>
        
        <s:form action="AddBook" namespace="/secure">
            <s:textfield name="name" key="book.name" requiredLabel="true"></s:textfield>
            <s:textfield name="description" key="book.description"></s:textfield>
            <s:textfield name="publishedDate" key="book.publishedDate"/>
            <s:select list="{'Mr1', 'Mr2'}"
                      name="authorName"
                      key="label.authorName"
                      />
            <s:select list="{'Cat1', 'Cat2'}"
                      name="category"
                      key="label.category"
                      />
            <s:submit key="addBook.submit" value="Submit"/>
        </s:form>
    </body>
</html>