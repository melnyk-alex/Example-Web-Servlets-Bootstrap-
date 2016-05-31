<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple design</title>

        <%@include file="/WEB-INF/jspf/styles.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>

        <div class="container">
            <h1>Articles</h1>

            <div class="row">
                <c:forEach items="${articleList}" var="article">
                    <div class="col-md-6">
                        <h4>${article.title} <small><fmt:formatDate value="${article.timestamp}" pattern="dd.MM.yyyy (hh:mm:ss)" /></small></h4>
                        <div class="well">${article.content}</div>
                        <p class="text-right text-muted"><i>${article.author}</i></p>
                    </div>
                </c:forEach>
            </div>
        </div>



        <%@include file="/WEB-INF/jspf/scripts.jspf" %>
    </body>
</html>
