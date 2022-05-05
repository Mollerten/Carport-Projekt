<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Create user
    </jsp:attribute>

    <jsp:attribute name="footer">
            Create user
    </jsp:attribute>

    <jsp:body>

        <h3>You can create a new user here</h3>

        <form action="fc/createUser" method="post">
            <input type="hidden" name="command" value="createUser"/>
            <br><br>

            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <br><br>

            <label for="email">Email: </label>
            <input type="text" id="email" name="email"/>
            <br><br>

            <label for="address">Street name and number: </label>
            <input type="text" id="address" name="address"/>
            <br><br>

            <label for="city">City and postal code: </label>
            <input type="text" id="city" name="city"/>
            <br><br>

            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <br><br>

            <input type="submit"  value="Create user"/>
        </form>

    </jsp:body>
</t:pagetemplate>