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
            <h1>Opret Stock:</h1>

            <form action="fc/Opretrequest" method="post">
                <input type="hidden" name="command" value="opretrequest"/>

                <label for="request_id">Request ID:</label>
                <input type="text" id="request_id" name="request_id"/><br/>

                <label for="length_cp">Carport Længde:</label>
                <input type="text" id="length_cp" name="length_cp"/><br/>

                <label for="width_cp">Carport Bredde: </label>
                <input type="text" id="width_cp" name="width_cp"/><br/>

                <label for="length_rr">Tag Længde: </label>
                <input type="text" id="length_rr" name="length_rr"/><br/>

                <label for="roof_mat">Tag Materiale: </label>
                <input type="text" id="roof_mat" name="width_rr"/><br/>

                <label for="wood_cladding_mat">Tag Beklædning: </label>
                <input type="text" id="wood_cladding_mat" name="width_rr"/><br/>

                <label for="customer_id">Din Mor: </label>
                <input type="text" id="customer_id" name="customer_id"/><br/>

                <label for="admin_id">Er Stor: </label>
                <input type="text" id="admin_id" name="admin_id"/><br/>

                <input type="submit" value="Opret Request"/>
            </form>


        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
