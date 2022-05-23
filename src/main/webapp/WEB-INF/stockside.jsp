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

            <form method="post">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Stock ID</th>
                        <th>Beskrivelse</th>
                        <th>Antal</th>
                        <th>Unit</th>
                        <th>Pris per unit</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="stock" items="${requestScope.stockliste}">
                        <tr>
                            <td>${stock.stockid}</td>
                            <td>${stock.description}</td>
                            <td>${stock.amount}</td>
                            <td>${stock.unit}</td>
                            <td>${stock.price_per_unit}</td>
                            <td>

                                <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">

                                    <button class="btn btn-primary submit px-3" style="background-color: #c82333"
                                            name="fjernstock" value="${stock.stockid}"
                                            formaction="${pageContext.request.contextPath}/fc/fjernstock?command=fjernstock">fjern</button>

                                    <button class="btn btn-primary submit px-3" style="background-color: #000C66"
                                            name="redigerstock" value="${stock.stockid}" formaction="${pageContext.request.contextPath}/fc/redigerstock?command=redigerstock">rediger</button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-primary submit px-3" style="background-color: #000C66"
                        name="opret" formaction="${pageContext.request.contextPath}/fc/opretstockside?command=opretstockside">Opret</button>
            </form>

        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>