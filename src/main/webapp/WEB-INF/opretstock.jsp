<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <%--        Hvis kontoen er user--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
            <h1>Du er ikke admin!</h1>
        </c:if>

        <%--        Hvis kontoen er admin--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">
            <h1>Opret Stock:</h1>

            <form action="fc/opretstock" method="post">
                <input type="hidden" name="command" value="opretstock"/>

                <label for="stockid">Stock id:</label>
                <input type="text" id="stockid" name="stockid"/><br/>

                <label for="description">Beskrivelse:</label>
                <input type="text" id="description" name="description"/><br/>

                <label for="amount">Antal: </label>
                <input type="text" id="amount" name="amount"/><br/>

                <label for="stockunit">stock unit: </label>
                <input type="text" id="stockunit" name="stockunit"/><br/>

                <label for="priceperunit">stock pris per unit: </label>
                <input type="text" id="priceperunit" name="priceperunit"/><br/>

                <input type="submit" value="Opret Stock"/>
            </form>


        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
