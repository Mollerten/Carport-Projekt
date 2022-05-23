<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
              Opdater brugeroplysninger
    </jsp:attribute>

  <jsp:attribute name="footer">
            profilside
    </jsp:attribute>

  <jsp:body>


    <h1>${requestScope.errormsg}</h1>

    <h3>You can change your profile information here.</h3>
    <h3>Fill in only the information you want to change</h3>

    <form action="fc/updateUser" method="post">
      <input type="hidden" name="command" value="updateUser"/>
      <br><br>

      <label for="newUsername">Enter new username: </label>
      <input type="text" id="newUsername" name="newUsername"/>
      <br><br>

      <label for="newEmail">Enter new email twice to confirm: </label>
      <label for="confirmNewEmail">: </label>
      <input type="text" id="newEmail" name="newEmail"/>
      <input type="text" id="confirmNewEmail" name="confirmNewEmail"/>
      <br><br>

      <label for="newPassword">Enter new password twice to confirm: </label>
      <label for="confirmNewPassword">: </label>
      <input type="password" id="newPassword" name="newPassword"/>
      <input type="password" id="confirmNewPassword" name="confirmNewPassword"/>
      <br><br>

      <label for="newTlfnr">Enter new phone number:</label>
      <input type="text" id="newTlfnr" name="newTlfnr">
      <br><br>

      <label for="newAddress">Enter new street name and number: </label>
      <input type="text" id="newAddress" name="newAddress"/>
      <br><br>

      <label for="newCity">Enter new city and postal code: </label>
      <label for="newPostalCode"></label>
      <input type="text" id="newCity" name="newCity"/>
      <input type="text" id="newPostalCode" name="newPostalCode">
      <br><br><br>

      <label for="oldPassword">Enter your current password to save changes:</label>
      <input type="password" id="oldPassword" name="oldPassword">
      <br><br>

      <input type="submit"  value="Update user"/>
    </form>

  </jsp:body>
</t:pagetemplate>