<%--
  Created by IntelliJ IDEA.
  User: patricknielsen
  Date: 12/05/2022
  Time: 12.45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

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
            <h1>Stockliste:</h1>

            <form action="${pageContext.request.contextPath}/fc/opdaterstock" method="post">
                <input type="hidden" name="command" value="opdaterstock"/>

                <label for="stockid">Stock Id:</label>
                <input type="text" id="stockid" readonly name="stockid" value="${requestScope.stock.stockid}"/><br/>

                <label for="description">Beskrivelse:</label>
                <input type="text" id="description" name="description" value="${requestScope.stock.description}"/><br/>

                <label for="amount">Antal: </label>
                <input type="text" id="amount" name="amount"  value="${requestScope.stock.amount}"/><br/>

                <label for="stockunit">stock unit: </label>
                <input type="text" id="stockunit" name="stockunit"  value="${requestScope.stock.unit}"/><br/>

                <label for="priceperunit">stock pris per unit: </label>
                <input type="text" id="priceperunit" name="priceperunit" value="${requestScope.stock.price_per_unit}"/><br/>

                <input type="submit" value="Opdater Stock"/>
            </form>

        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
