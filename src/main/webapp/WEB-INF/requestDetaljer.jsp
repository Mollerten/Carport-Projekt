
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page errorPage="../error.jsp" isErrorPage="false" %> --%>

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
            <tr>
              <td>${requestScope.request.requestid}</td>
              <td>${requestScope.request.lengthcp}</td>
              <td>${requestScope.request.widthcp}</td>
              <td>${requestScope.request.lengthrr}</td>
              <td>${requestScope.request.widthrr}</td>
              <td>${requestScope.request.roofmat}</td>
              <td>${requestScope.request.woodcladding}</td>
              <td>${requestScope.request.customerid}</td>
              <td>${requestScope.request.adminid}</td>




              <td>



                  <button class="btn btn-primary submit px-3" style="background-color: #000C66"
                          name="redigerrequest" value="${requestScope.request.requestid}" formaction="fc/redigerrequest?command=redigerrequest">rediger</button>

              </td>
            </tr>
          </tbody>
        </table>
      </form>

      <form method="post">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>Kundes informationer</th>
            <th>Brugernavn</th>
            <th>Email</th>
            <th>Tlfnr</th>
            <th>Adresse</th>
            <th>By</th>
            <th>Postnummer</th>

          </tr>

          </thead>
          <tbody>
          <tr>
            <td></td>
            <td>${requestScope.user.username}</td>
            <td>${requestScope.user.email}</td>
            <td>${requestScope.user.tlfnr}</td>
            <td>${requestScope.user.address}</td>
            <td>${requestScope.user.city}</td>
            <td>${requestScope.city.postalCode}</td>

          </tr>
          </tbody>
        </table>
      </form>

      <form method="post">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>Stykliste</th>
            <th>Mængde</th>
            <th>Varebeskrivelse</th>
            <th>Længde</th>
            <th>Enhed</th>
            <th>Hjælpetekst</th>
            <th>Pris</th>
          </tr>
          </thead>

          <tbody>
          <c:forEach var="material" items="${requestScope.partsList.materials}">
            <tr>
              <td></td>
              <td>${material.amount}</td>
              <td>${material.description}</td>
              <td>${material.length}</td>
              <td>${material.unit}</td>
              <td>${material.helpText}</td>
              <td>${material.price}</td>

            </tr>
          </c:forEach>
          </tbody>
        </table>
        <c:if test="${requestScope.request.totalPrice eq 0}"> <!-- price frozen -->
          <p style="font-size: large"><strong>Total pris: </strong>${requestScope.partsList.priceInDKK} DKK</p>
        </c:if>
        <c:if test="${requestScope.request.totalPrice ne 0}"> <!-- price not frozen -->
          <p style="font-size: large"><strong>Total pris: </strong>${requestScope.request.totalPrice} DKK</p>
        </c:if>
        <button class="btn btn-primary submit px-3" style="background-color: #000C66"
                name="svgtest"
                value="${requestScope.request.requestid}"
                formtarget="_blank"
                formaction="${pageContext.request.contextPath}/fc/svgtest?command=svgtest">Se model</button>

        <button class="btn btn-primary submit px-3" style="background-color: #26C000"
                name="requestid" value="${requestScope.request.requestid}"
                formaction="${pageContext.request.contextPath}/fc/tagAnsvar?command=tagAnsvar">Godkend forespørgsel</button>

        <button class="btn btn-primary submit px-3" style="background-color: #c82333"
                name="fjernrequest" value="${requestScope.request.requestid}"
        formaction="${pageContext.request.contextPath}/fc/fjernrequest?command=fjernrequest">Slet forespørgsel</button>


      </form>


    </c:if>

    <%--        Hvis brugeren/admin ikke er logget ind--%>
    <c:if test="${sessionScope.user == null}">
      <p>Du er ikke logget ind endnu - log ind her:
        <a href="../login.jsp">Login</a></p>
    </c:if>

  </jsp:body>

</t:pagetemplate>
