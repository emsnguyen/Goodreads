<%-- 
    Document   : SearchResult
    Created on : May 1, 2018, 9:13:02 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            img {
                width: 100px;
                height: 100px;
            }
        </style>
    </head>
    <body>
        <h1>
            <s:text name="search.result">
            </s:text>
            <i>'<s:property value="searchInfo"/>'</i>
        </h1>
        <s:iterator value="books">
            <table border="1">
                <tr>
                    <s:url namespace="/book" action="show" var="url">
                        <s:param name="bookID" value="%{ID}"/>
                    </s:url>

                    <td>
                        <a href="<s:property value="#url"/>">
                            <img src="<s:url value="bookCover/%{ID}.jpg"/>" alt="book cover"/>
                        </a>
                    </td>
                    <td rowspan="3">
                        <a href="<s:property value="#url"/>">
                            <h3><s:property value="name"/></h3>
                        </a>
                        <p><s:property value="author.name"/></p>
                        <p><i><s:property value="description"/></i></p>
                        <p>
                            Rating: <s:property value="points"/>
                        </p>
                        <p>
                            Total votes: <s:property value="totalVotes"/>
                        </p>
                        <p>
                            Published Date: <s:property value="publishedDate"/>
                        </p>
                    </td>
                    <td>
                        <p>
                            <s:select list="{'Đang đọc', 'Muốn đọc', 'Đã đọc'}"
                                      name="status"
                                      />
                        </p>
                        <p>
                            <s:select list="{'Very Bad', 'Bad', 'Neutral', 'Good','Very good'}"
                                      name="rating"
                                      />
                        </p>
                    </td>
                </tr>
            </table>
        </s:iterator>
    </body>
</html>
