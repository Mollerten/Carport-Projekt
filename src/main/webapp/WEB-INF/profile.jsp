<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Profile page
    </jsp:attribute>

  <jsp:attribute name="footer">
            Profile page
    </jsp:attribute>

  <jsp:body>

    <h1>${requestScope.errormsg}</h1>

    <h3>Lavede du en fejl da du oprettede din profil? </h3>
    <h3>Udfyld formularen og få det fixet!</h3>

    <form action="fc/updateUser" method="post">
      <input type="hidden" name="command" value="updateUser"/>
      <br><br>

      <label for="newUsername">Indtast nyt brugernavn: </label>
      <input type="text" id="newUsername" name="newUsername"/>
      <br><br>

      <label for="newEmail">Indtast ny email to gange for at bekræfte: </label>
      <label for="confirmNewEmail">: </label>
      <input type="text" id="newEmail" name="newEmail"/>
      <input type="text" id="confirmNewEmail" name="confirmNewEmail"/>
      <br><br>

      <label for="newPassword">Indtast nyt kodeord to gange for at bekræfte: </label>
      <label for="confirmNewPassword">: </label>
      <input type="password" id="newPassword" name="newPassword"/>
      <input type="password" id="confirmNewPassword" name="confirmNewPassword"/>
      <br><br>

      <label for="newTlfnr">Indtast nyt telefonnummer:</label>
      <input type="text" id="newTlfnr" name="newTlfnr">
      <br><br>

      <label for="newAddress">Indtast nyt gadenavn og nummer: </label>
      <input type="text" id="newAddress" name="newAddress"/>
      <br><br>

      <label for="newCity">Indtast ny by og zipcode: </label>
      <label for="newPostalCode"></label>
      <input type="text" id="newCity" name="newCity"/>
      <input type="text" id="newPostalCode" name="newPostalCode">
      <br><br><br>

      <label for="oldPassword">Indtast dit kodeord for at gemme ændringerne:</label>
      <input type="password" id="oldPassword" name="oldPassword">
      <br><br>

      <input type="submit"  value="Update user"/>

    </form>
  </jsp:body>
</t:pagetemplate>