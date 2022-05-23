<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
        Denne side er ikke tilgængelig
    </jsp:attribute>

    <jsp:attribute name="footer">
            Error page
    </jsp:attribute>

    <jsp:body>

        <head>
            <link rel="stylesheet" href="css/error.css">
        </head>

    <body>
    <div class="container">

        <h1>Denne side er ikke tilgængelig</h1>

        <c:if test="${pageContext.errorData.statusCode == 404 }">
            <h2>Fejlkode:</h2> <h2>${pageContext.errorData.statusCode}</h2>
            <p>Fejl! en fejl er sket i serveren</p>
        </c:if>

        <c:if test="${pageContext.errorData.statusCode == 500 }">
            <p><b>Fejlkode:</b> ${pageContext.errorData.statusCode}</p>
            <p>Fejl! en fejl er sket i serveren</p>
        </c:if>


        <c:if test="${requestScope.errormessage != null}">
            <p>${requestScope.errormessage}</p>
        </c:if>

        <c:if test="${requestScope.errormessage  == null}">
            <p>Fejl! vi ved ikke hvordan du havnede her</p>
        </c:if>


        <p>Gå tilbage til <a id="knap" href="index.jsp">forsiden</a>
            eller prøv at <a id="knap" href="login.jsp">logge ind</a> igen.</p>
            </div>
    </body>

    </jsp:body>
</t:pagetemplate>