<%--
  Created by IntelliJ IDEA.
  User: patricknielsen
  Date: 16/05/2022
  Time: 11.03
  To change this template use File | Settings | File Templates.
--%>
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
            <h1>Requestliste:</h1>

            <form action="fc/opdaterrequest" method="post">
                <input type="hidden" name="command" value="opdaterrequest"/>

                <label for="request_id">Request ID:</label>
                <input type="text" id="request_id" readonly name="request_id" value="${requestScope.request.requestid}"/><br/>

                <label for="length_cp">CP længde:</label>
                <input type="text" id="length_cp" name="length_cp" value="${requestScope.request.lengthcp}"/><br/>

                <label for="width_cp">CP bredde: </label>
                <input type="text" id="width_cp" name="width_cp" value="${requestScope.request.widthcp}"/><br/>

                <label for="length_rr">RR længde: </label>
                <input type="text" id="length_rr" name="length_rr" value="${requestScope.request.lengthrr}"/><br/>

                <label for="width_rr">rr bredde: </label>
                <input type="text" id="width_rr" name="width_rr" value="${requestScope.request.widthrr}"/><br/>

                <label for="roofmat">roof mat: </label>
                <input type="text" id="roofmat" name="roofmat" value="${requestScope.request.roofmat}"/><br/>

                <label for="woodcladdingmat">wood cladding mat: </label>
                <input type="text" id="woodcladdingmat" name="woodcladdingmat" value="${requestScope.request.woodcladding}"/><br/>

                <label for="customer_id">kunde id: </label>
                <input type="text" id="customer_id" name="customer_id" value="${requestScope.request.customerid}"/><br/>

                <label for="admin_id">admin id: </label>
                <input type="text" id="admin_id" name="admin_id" value="${requestScope.request.adminid}"/><br/>

                <input type="submit" value="Opdater Request"/>
            </form>

        </c:if>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>