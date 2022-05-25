<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
        Denne side er ikke tilgængelig
    </jsp:attribute>

    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
            Error: ${pageContext.errorData.statusCode}
    </jsp:attribute>

    <jsp:body>

        <head>
            <link rel="stylesheet" href="css/error.css">
        </head>

    <body>
    <div class="container">

        <h1 style="color: black">Denne side er ikke tilgængelig</h1>

        <c:if test="${pageContext.errorData.statusCode == 404 }">
            <h2 style="color: black">Fejlkode: ${pageContext.errorData.statusCode}</h2>
            <p>Fejl! en fejl er sket i serveren</p>

        </c:if>

        <c:if test="${pageContext.errorData.statusCode == 500 }">

            <p><b>Fejlkode:</b> ${pageContext.errorData.statusCode}</p>
            <p>Fejlkode 500</p>
        </c:if>


        <c:if test="${requestScope.errormessage != null}">
            <p>${requestScope.errormessage}</p>
        </c:if>

        <c:if test="${requestScope.errormessage  == null}">
            <p>Fejl! vi ved ikke hvordan du havnede her</p>
        </c:if>


        <p>Gå tilbage til <a id="knap" href="${pageContext.request.contextPath}/index.jsp">forsiden</a>
            eller prøv at <a id="knap2" href="${pageContext.request.contextPath}/login.jsp">logge ind</a> igen.</p>
            </div>
    </body>

    </jsp:body>
</t:pagetemplate>