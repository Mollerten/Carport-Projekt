<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Brugerside
    </jsp:attribute>

    <jsp:attribute name="footer">
        Brugerside
    </jsp:attribute>

    <jsp:body>


        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
            <p>Velkommen tilbage bruger</p>
            <p>Du er logget ind med rollen:  "${sessionScope.user.role}".</p>
        </c:if>


        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">
            <p>Velkommen tilbage admin!</p>
            <p>Du er logget ind med rollen:  "${sessionScope.user.role}".</p>


            <div class="form-group">
                <button type="submit" style="background-color: #000C66" class="form-control btn btn-primary submit px-3">Log ind</button>
            </div>

        </c:if>


        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>

        </c:if>

    </jsp:body>

</t:pagetemplate>