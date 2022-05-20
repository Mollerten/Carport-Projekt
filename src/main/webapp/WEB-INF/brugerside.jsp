<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>


<%--        Hvis kontoen er user--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
            <p>Velkommen tilbage bruger</p>
            <p>Du er logget ind med rollen:  "${sessionScope.user.role}".</p>
        </c:if>

<%--        Hvis kontoen er admin--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">

            <link rel="stylesheet" href="scss/style.scss">

            <body style="background-attachment: fixed; background-size: cover; background-repeat: no-repeat; background-image: url(${pageContext.request.contextPath}/images/adminpaa.jpg)";>

            <h1>Velkommen tilbage Admin</h1>

            <h2> Du er logget ind med rollen: "${sessionScope.user.role}".</h2>

            <form action="${pageContext.request.contextPath}/fc/stockside" method="post">
            <input type="hidden" name="command" value="stockside"/>
            <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Se Stock"/>
            </form>
            <br>
            <form action="${pageContext.request.contextPath}/fc/requestside" method="post">
                <input type="hidden" name="command" value="requestside"/>
                <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Se Requests"/>
            </form>
            <br>
            </body>


        </c:if>

<%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>

        </c:if>


        <form action="${pageContext.request.contextPath}/fc/profil" method="post">
            <input type="hidden" name="command" value="profil"/>
            <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Opdater Profil"/>
        </form>

    </jsp:body>

</t:pagetemplate>