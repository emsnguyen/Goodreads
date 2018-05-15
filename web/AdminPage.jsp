<%-- 
    Document   : Home
    Created on : Apr 23, 2018, 4:14:23 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<!--adding ajax support-->
<sx:head/> 

<body>
    <h1>goodreads.vn</h1>
    <jsp:include page="Header.jsp"/>
    <s:a href="admin/AddBookForm.jsp">Thêm sách mới</s:a>
    <s:a href="admin/AddAuthorForm.jsp">Thêm tác giả mới</s:a>
    <s:a href="admin/AddCategoryForm.jsp">Thêm thể loại mới</s:a>
    <s:a href="logout">Đăng xuất</s:a>
    <s:form action="search">
        <sx:autocompleter label="Tìm sách" name="book" list="books"/>
        <s:submit value="submit" name="submit" />
    </s:form>

    <jsp:include page="Footer.jsp"/>
</body>

