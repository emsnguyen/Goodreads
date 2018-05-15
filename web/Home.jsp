<%-- 
    Document   : Home
    Created on : Apr 23, 2018, 4:14:23 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <style>
        img {
            width: 200px;
            height: 200px;
        }
    </style>
    <!--adding ajax support-->
    <sx:head/> 
    <body>
        <!--header-->
        <jsp:include page="Header.jsp"/>
        <!--left sidebar-->
        <aside>
            <!--list of authors-->
            <s:text name="list.authors"/>
            <table border="1">
                <s:iterator value="#session.authors">
                    <tr>
                        <td>
                            <img src="<s:url value="authorAva/%{ID}.jpg"/>" alt="author ava"/>
                        </td>
                        <td>
                            <a href="<s:url namespace="/author" action="show">
                                   <s:param name="authorID" value="%{ID}" /></s:url>">
                               <s:property value="name"/>
                            </a>
                            <s:property value="description"/>
                        </td>
                    </tr>

                </s:iterator>
            </table>
            <hr/>
            <!--list of lists-->
            <s:text name="list.lists"/>
            <table border="1">
                <s:iterator value="#session.lists">
                    <tr>
                        <td>
                            <a href="<s:url namespace="/list" action="show">
                                   <s:param name="listID" value="%{ID}" /></s:url>">
                               <s:property value="name"/>
                            </a>
                            <s:property value="description"/>
                        </td>
                    </tr>

                </s:iterator>
            </table>
            <hr/>
            <!--list of categories-->
            <s:text name="list.categories"/>
            <s:iterator value="#session.categories">
                <a href="<s:url namespace="/" action="GetByCategory">
                       <s:param name="categoryID" value="%{ID}" /></s:url>">
                   <s:property value="name"/>
                </a> &nbsp;&nbsp;
            </s:iterator>
            <hr/>
        </aside>
        <!--main content-->
        <main>
            <!--list of books-->
            <s:text name="list.popular.books"/>
            <table border="1">
                <s:iterator value="#session.books">
                    <tr>
                        <td>
                            <img src="<s:url value="bookCover/%{ID}.jpg"/>" alt="book coer"/>
                        </td>
                        <td>
                            <a href="<s:url namespace="/book" action="show">
                                   <s:param name="bookID" value="%{ID}" /></s:url>">
                               <s:property value="name"/>
                            </a>
                            <s:property value="description"/>
                            <s:property value="author.name"/>
                        </td>
                        <td>
                            <p>
                                <s:property value="points"/> points
                            </p>
                            <p>
                                <s:property value="totalVotes"/> total votes
                            </p>
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            your rating: <s:select list="ranking" onchange=""/>
                        </td>
                    </tr>

                </s:iterator>
            </table>
        </main>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>