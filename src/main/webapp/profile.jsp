<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Create user
    </jsp:attribute>

  <jsp:attribute name="footer">
            Create user
    </jsp:attribute>

  <jsp:body>

    <h1>${requestScope.errormsg}</h1>

    <h3>You can change your profile information here</h3>

    <form action="fc/updateUser" method="post">
      <input type="hidden" name="command" value="updateUser"/>
      <br><br>

      <label for="username">Username: </label>
      <input type="text" id="username" name="username"/>
      <br><br>

      <label for="email">Email: </label>
      <input type="text" id="email" name="email"/>
      <br><br>

      <label for="password">Password: </label>
      <input type="password" id="password" name="password"/>
      <br><br>

      <label for="tlfnr">Phone number:</label>
      <input type="text" id="tlfnr" name="tlfnr">
      <br><br>

      <label for="address">Street name and number: </label>
      <input type="text" id="address" name="address"/>
      <br><br>

      <label for="city">City and postal code: </label>
      <label for="postalCode"></label>
      <input type="text" id="city" name="city"/>
      <input type="text" id="postalCode" name="postalCode">
      <br><br>

      <input type="submit"  value="Update user"/>
    </form>

  </jsp:body>
</t:pagetemplate>