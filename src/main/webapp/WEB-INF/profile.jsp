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

  </jsp:body>
</t:pagetemplate>