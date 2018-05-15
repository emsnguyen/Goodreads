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
<title>Author Page</title>
<style>
    img {
        width: 200px;
        height: 200px;
    }
</style>
<!--adding ajax support-->
<sx:head/> 

<body>
    <jsp:include page="Header.jsp"/>
    <s:a href="logout">Đăng xuất</s:a>
    <s:text name="list.category.book"/>
    <table border="1">
        <thead>
            <tr>
                
                <th>
                    <s:text name="label.bookName"/>
                </th>
                <th>
                    <s:text name="label.bookDescription"/>
                </th>
                <th>
                    <s:text name="label.bookCover"/>
                </th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="books">
            <tr>
                    <td>
                        <s:url namespace="/book" action="show" var="url">
                            <s:param name="bookID" value="%{ID}"/></s:url>
                        <a href="<s:property value="#url"/>">
                            <s:property value="name"/>
                        </a>
                    </td>
                    <td>
                        <s:property value="description"/>
                    </td>
                    <td>
                        <img src="<s:url value="bookCover/%{ID}.jpg"/>" alt=""/>
                    </td>
            </tr>
            </s:iterator>
        </tbody>
    </table>

    <jsp:include page="Footer.jsp"/>
</body>
