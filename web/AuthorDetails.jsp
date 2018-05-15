<%-- 
    Document   : Home
    Created on : Apr 23, 2018, 4:14:23 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Author Page</title>
    <!--adding ajax support-->
    <sx:head/> 
    <style>
        img {
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
    <jsp:include page="Header.jsp"/>
    <s:text name="info.author"/>
    <table border="1">
        <tbody>
            <tr>
                <s:iterator value="author" var="author">
                    <td>
                        <img src="<s:url value="../authorAva/%{author.ID}.jpg"/>" alt=""/>
                    </td>
                    <td>
                        <s:property value="name"/>
                        <s:property value="description"/>
                    </td>
                </s:iterator>
            </tr>
        </tbody>
    </table>
    <hr/>
    <s:text name="list.author.book"/>
    <table border="1">
        <tbody>
            <s:iterator value="books">
                <tr>
                    <td>
                        <img src="<s:url value="../bookCover/%{ID}.jpg"/>" alt="book cover"/>
                    </td>
                    <td>
                        <s:url namespace="/book" action="show" var="url">
                            <s:param name="bookID" value="%{ID}"/></s:url>
                        <a href="<s:property value="#url"/>">
                            <s:property value="name"/>
                        </a>
                        <p>
                            <s:property value="description"/>
                        </p>
                        <p><i><s:property value="points"/></i> points</p> 
                        <p><i><s:property value="totalVotes"/></i> total votes</p> 
                    </td>
                    <td>
                        
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <jsp:include page="Footer.jsp"/>
</body>

