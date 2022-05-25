<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<t:pagetemplate>

    <jsp:attribute name="title">
        FOG - Holder I Længden
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen til FOG
    </jsp:attribute>

    <jsp:body>


            <head>
            <link rel="stylesheet" type="text/css" href="css/style.css">
            </head>

            <body>

            <video id="background-video" autoplay muted loop src="videos/carportvideo.mp4"></video>


            <h2>Fog - Holder i længden</h2>


<%--        hvis brugeren ikke er logget ind skal brugeren oprette en profil--%>
            <c:if test="${sessionScope.user == null}">

                <a style="display: block; width: 200px; margin-left: auto; margin-right: auto; text-align: center; text-decoration: 0;background: #000C66;
            color: #FFFFFF;padding: 20px 24px;border-radius: 19px;
             font-size: 18px;" href="${pageContext.request.contextPath}/createUser.jsp">Send forespørgsel</a>
                </body>
            </c:if>


<%--        Hvis brugeren er logget ind skal brugeren ikke sendes til opret bruger--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">

            <a style="display: block; width: 200px; margin-left: auto; margin-right: auto; text-align: center; text-decoration: 0;background: navy;
            color: #FFFFFF;padding: 20px 24px;border-radius: 19px;
             font-size: 18px;" href="${pageContext.request.contextPath}/fc/designside?command=designside">Send forespørgsel</a>
        </c:if>



    </jsp:body>


</t:pagetemplate>