<%-- 
    Document   : Header
    Created on : May 2, 2018, 4:14:40 PM
    Author     : lenovo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <sx:head/>
        <s:head/>
        <title>Header</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            /* Add a black background color to the top navigation */
            .topnav {
                background-color: #333;
                overflow: hidden;
            }

            /* Style the links inside the navigation bar */
            .topnav a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            /* Change the color of links on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Add an active class to highlight the current page */
            .active {
                background-color: #4CAF50;
                color: white;
            }

            /* Hide the link that should open and close the topnav on small screens */
            .topnav .icon {
                display: none;
            }
            /* When the screen is less than 600 pixels wide, hide all links, except for the first one ("Home"). Show the link that contains should open and close the topnav (.icon) */
            @media screen and (max-width: 600px) {
                .topnav a:not(:first-child) {display: none;}
                .topnav a.icon {
                    float: right;
                    display: block;
                }
            }

            /* The "responsive" class is added to the topnav with JavaScript when the user clicks on the icon. This class makes the topnav look good on small screens (display the links vertically instead of horizontally) */
            @media screen and (max-width: 600px) {
                .topnav.responsive {position: relative;}
                .topnav.responsive a.icon {
                    position: absolute;
                    right: 0;
                    top: 0;
                }
                .topnav.responsive a {
                    float: none;
                    display: block;
                    text-align: left;
                }
            }

            header {
                background: #42A5F5;
                color: white;
                line-height: 50px;
                padding: 0 20px;
            }
        </style>
        <script>
            function myFunction() {
                var x = document.getElementById("myTopnav");
                if (x.className === "topnav") {
                    x.className += " responsive";
                } else {
                    x.className = "topnav";
                }
            }
        </script>
    </head>
    <body>
        <header>
            GOODREADS.VN
        </header>
        <s:form action="search">
            <!--i wonder why this works as a dropdown list instead :((-->
            <%--<sx:autocompleter label="Tìm sách" name="searchInfo" list="books"--%>
            <!--listKey = "ID"-->
            <!--listValue="name"-->
            <!--/>-->
            <s:textfield label="Tìm sách" name="searchInfo"/>
            <s:label name="noresult"/>
            <s:submit value="Tìm kiếm"/>
        </s:form>
        <div class="topnav" id="myTopnav">
            <a href="<s:url action="init" namespace="/"/>" class="active">
                <s:text name="home"/>
            </a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
            <s:if test="%{#session.username == null}">
                <!--if not logged in yet-->
                <a href="Login.jsp">
                    <s:text name="login"/>
                </a>
                <a href="Register.jsp">
                    <s:text name="register"/>
                </a>
            </s:if>
            <s:else>
                <s:url action="list" namespace="/review" var="listReview"/>
                <a href="<s:property value="#listReview"/>">
                    <s:text name="mybooks"/>
                </a>
                <s:url action="logout" namespace="/" var="logout"/>
                <a href="<s:property value="#logout"/>">
                    <s:text name="logout"/>
                </a>
            </s:else>
        </div>
    </body>
</html>
