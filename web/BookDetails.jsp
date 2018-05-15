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
    <title>Book Details Page</title>
    <style>
        img {
            width: 200px;
            height: 200px;
        }
        #reviewerAva {
            width: 50px;
            height: 50px;
        }
        ul {
            list-style: none;
        }
    </style>
    <!--adding ajax support-->
    <sx:head/> 
</head>
<body>
    <jsp:include page="Header.jsp"/>
    <table border="1">
        <tbody>
            <tr>
                <s:iterator value="book">
                    <td>
                        <img src="<s:url value="../bookCover/%{ID}.jpg" namespace="/"/>" alt="book cover"/>
                    </td>
                    <td>
                        <h3>
                            <s:property value="name"/>
                        </h3>
                        <a href="<s:url namespace="/author" action="show">
                               <s:param name="authorID" value="%{author.ID}" />
                           </s:url>">
                           <s:property value="author.name"/>
                        </a>
                        <p><i><s:property value="description"/></i></p>
                        <p><i><s:property value="points"/></i> points</p> 
                        <p><i><s:property value="totalVotes"/></i> total votes</p> 
                    </td>
                </s:iterator>
            </tr>
        </tbody>
    </table>
    <br/>
    <!--list categories-->
    <s:if test="%{categories.size > 0}">
        <s:text name="book.details.categories"/>
        <s:iterator value="categories">
            <a href="<s:url action="show" namespace="/category">
                   <s:param name="categoryID">%{ID}</s:param>
               </s:url>">
                <s:property value="name"/>
            </a>
        </s:iterator>
    </s:if>
    <s:else>
        <s:text name="book.details.nocategory"/>
    </s:else>
    <br/>
    <!--list lists-->
    <s:if test="%{lists.size > 0}">
        <s:text name="book.details.lists"/>
        <s:iterator value="lists">
            <s:property value="name"/>
        </s:iterator>
    </s:if>
    <s:else>
        <s:text name="book.details.nolist"/>
    </s:else>
    <br/>
    <br/>
    <s:if test="%{reviews.size > 0}">
        <h2>
            <s:text name="book.details.reviews"/>
        </h2>
        <ul>
            <s:iterator value="mapReviewComment">
                <!--avatar of reviewer-->
                <li>
                    <img src="../userAva/<s:property value="key.userID"/>.jpg" alt="ava" id="reviewerAva"/>
                </li>
                <li>
                    <ul>
                        <!--review details-->
                        <li>
                            <s:property value="key.content"/>
                            <s:property value="key.date"/>
                            <p>
                                <s:property value="key.points"/> points
                            </p>
                            <p>
                                <s:property value="key.totalVotes"/> votes
                            </p>
                            
                        </li>
                        <li>
                            <s:text name="comments"/>
                            <s:if test="%{value.size > 0}">
                                <a>
                                    <s:property value="%{value.size}"/>
                                </a>
                            </s:if>
                            <s:else>
                                <s:property value="%{value.size}"/>
                            </s:else>
                        </li>
                        <!--add a new comment for a given review-->
                        <li>
                            <s:text name="comment.add"/>
                            <s:form namespace="/comment" action="add">
                                <s:hidden name="reviewID" value="key.ID"/>
                                <s:textarea rows="4" cols="20" name="newComment"></s:textarea>
                                <s:submit key="add"/>
                            </s:form>
                        </li>
                    </ul>
                </li>
            </s:iterator>
        </ul>
    </s:if>
    <s:else>
        <s:text name="book.details.noreview"/>
    </s:else>
    <br/>
<!--add a new review for this book-->
    <s:text name="review.add"/>
    <s:form namespace="/review" action="add">
        <s:hidden name="bookID" value="bookID"/>
        <s:textarea rows="10" cols="40" name="newReview"></s:textarea>
        <s:submit/>
    </s:form>
    <jsp:include page="Footer.jsp"/>
</body>

