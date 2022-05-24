<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="title">
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
                Brugerside
                </c:if>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">
                Adminside
                </c:if>
    </jsp:attribute>


    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <head>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
        </head>

<%--        Hvis kontoen er user--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">


            <body>
            <br>
            <b style="font-size: 20px">Velkommen tilbage ${sessionScope.user.username}</b>
            <br>
            <br>
            <b>Email:  ${sessionScope.user.email}</b>
            <br>
            <br>
            <b>Telefonnummer:  ${sessionScope.user.tlfnr}</b>
            <br>
            <br>
            <b>Adresse:  ${sessionScope.user.address} ${sessionScope.user.city}</b>
            <br>
            <br>
            <br>

            <p>Opdater dine oplysninger her:</p>
            <form action="${pageContext.request.contextPath}/fc/profil" method="post">
                <input type="hidden" name="command" value="profil"/>
                <input type="submit" id="knap2" value="Opdater brugeroplysninger"/>
            </form>


            </body>
        </c:if>

<%--        Hvis kontoen er admin--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">

            <link rel="stylesheet" href="scss/style.scss">


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
            <br>
            <p>Opdater dine oplysninger her:</p>
            <form action="${pageContext.request.contextPath}/fc/profil" method="post">
                <input type="hidden" name="command" value="profil"/>
                <input type="submit" id="knap" value="Opdater adminoplysninger"/>
            </form>

            <br>
            </body>


        </c:if>

<%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>

        </c:if>




    </jsp:body>

</t:pagetemplate>