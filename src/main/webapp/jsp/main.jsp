
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title><c:out value="${activePage}"/></title>
        <script src="javascript/jquery-1.11.2.js"></script>
        <script src="javascript/bootstrap.js"></script>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="jspf/navbar.jspf" %>

        <div class="container-fluid">


            <%@include file="jspf/nav-sidebar.jspf" %>

            <div class="col-md-10 main">
                <c:choose> 
                    <c:when test="${activePage==\"charts\"}">
                        <%@include file="jspf/charts.jspf" %>
                    </c:when>
                    <c:otherwise>
                        <%@include file="jspf/table.jspf" %> 
                    </c:otherwise>
                </c:choose>














            </div>
        </div>

    </body>
</html>