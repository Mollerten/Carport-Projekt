<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
      Opdater brugeroplysninger

    </jsp:attribute>

  <jsp:attribute name="footer">
            profilside
    </jsp:attribute>

  <jsp:body>
    <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
    </head>

    <form action="fc/updateUser" method="post">
    <input type="hidden" name="command" value="updateUser"/>


    <body>
    <div class="wrapper">

      <div class="form_container">
        <form name="form">
          <div class="heading">
            <h2>Opdater brugeroplysninger</h2>
          </div>
          <div class="form_wrap">
            <div class="form_item">
              <label for="newUsername">Brugernavn: </label>
              <input type="text" id="newUsername" name="newUsername" placeholder="indtast nyt brugernavn" required/>
            </div>


          </div>
          <div class="form_wrap">
            <div class="form_item">
              <label for="newEmail">Email: </label>
              <label for="confirmNewEmail"></label>
            </div>

              <div class="form_wrap">
                <div class="form_item">
              <input type="text" id="newEmail" name="newEmail" placeholder="indtast e-mail" required/>
              <input type="text" id="confirmNewEmail" name="confirmNewEmail" placeholder="gentag e-mail" required/>
            </div>


          <div class="form_wrap">
            <div class="form_item">
              <label for="newPassword">Indtast kodeord: </label>
              <label for="confirmNewPassword"></label>
            </div>

            <div class="form_wrap">
              <div class="form_item">
                <input type="password" id="newPassword" name="newPassword" placeholder="indtast nyt kodeord" required/>
                <input type="password" id="confirmNewPassword" name="confirmNewPassword" placeholder="gentag dit nye kodeord" required/>
              </div>


          <div class="form_wrap ">
            <div class="form_item">
              <label for="newTlfnr">Telefonnummer:</label>
              <input type="text" id="newTlfnr" name="newTlfnr" placeholder="indtast dit nye telefonnummer" required>
            </div>
          </div>

          <div class="form_wrap">
            <div class="form_item">
              <label for="newAddress">Adresse: </label>
              <input type="text" id="newAddress" name="newAddress" placeholder="indtast din nye adresse" required/>
            </div>
          </div>


          <div class="form_wrap fullname">
            <div class="form_item">
              <label for="newCity">By: </label>
              <input type="text" id="newCity" name="newCity" placeholder="indtast by" required/>
            </div>

            <div class="form_item">
              <label for="newPostalCode">Postnummer:</label>
              <input type="text" id="newPostalCode" name="newPostalCode" placeholder="indtast postnummer" required>
            </div>
          </div>

          <div class="form_wrap">
            <div class="form_item">
              <label for="oldPassword">Indtast dit nuværende kodeord:</label>
              <input type="password" id="oldPassword" name="oldPassword" placeholder="indtast kodeord" required>
            </div>
          </div>


          <div class="btn">
            <input type="submit" value="Opdater oplysninger">
          </div>
            </div>
          </div>
              </div>
          </div>
        </form>
      </div>
    </div>
    </body>


 <%--   <h1>${requestScope.errormsg}</h1>

    <h3>Lavede du en fejl da du oprettede din profil? </h3>
    <h3>Udfyld formularen og få det fixet!</h3>

    <form action="${pageContext.request.contextPath}/fc/updateUser" method="post">
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
<<<<<<< HEAD:src/main/webapp/WEB-INF/profile.jsp
=======
    </form>--%>

  </jsp:body>
</t:pagetemplate>