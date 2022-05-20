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
            <h1>requestliste:</h1>
            ${requestScope.bogliste}

            <form method="post">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Request ID</th>
                        <th>Carport Længde</th>
                        <th>Carport Bredde</th>
                        <th>Skur Længde</th>
                        <th>Skur Bredde</th>
                        <th>Tag Materiale</th>
                        <th>Træ Beklædning Materiale</th>
                        <th>Kunde ID</th>
                        <th>Admin ID</th>


                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="request" items="${requestScope.requestliste}">
                        <tr>
                            <td>${request.request_id}</td>
                            <td>${request.length_cp}</td>
                            <td>${request.width_cp}</td>
                            <td>${request.length_rr}</td>
                            <td>${request.width_rr}</td>
                            <td>${request.roof_mat}</td>
                            <td>${request.wood_cladding_mat}</td>
                            <td>${request.customer_id}</td>
                            <td>${request.admin_id}</td>

                            <td>



                                    <button class="btn btn-primary submit px-3" style="background-color: #000C66"
                                            name="requestDetaljer" value="${request.request_id}" formaction="${pageContext.request.contextPath}/fc/requestDetaljer?command=requestDetaljer">Se detaljer</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>

        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>