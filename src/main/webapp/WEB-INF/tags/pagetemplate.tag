<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="title"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <%--    Til inkøbskurv--%>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>


    <script src="https://kit.fontawesome.com/cb408aef43.js" crossorigin="anonymous"></script>

    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000C66">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/images/foglogo.png" width="126" class="img-fluid"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/about?command=about"><strong>Om os</strong></a>




                    <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/designside?command=designside"><strong>Carport Design</strong></a>
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/brugerside?command=brugerside"><strong>Brugerside</strong></a>
                        <i style=" position:relative; top:10px; color:white;" class="fa-solid fa-user"></i>
                    </c:if>


                    <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/brugerside?command=brugerside"><strong>Adminside</strong></a>
                        <i style=" position:relative; top:10px; color:white;" class="fa-solid fa-user-gear"></i>
                    </c:if>


                    <c:if test="${sessionScope.user == null }">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp"><strong>Log ind</strong></a>

                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/logout?command=logout"><strong>Log ud</strong></a>
                    </c:if>


                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 600px">
    <h1><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container mt-4" style="background-color: #000C66">
    <hr/>
    <div class="row mt-4">
        <div class="col" style="color: white">
            Johannes Fog A/S - Firskovvej 20<br/>
            2800 Lyngby
        </div>
        <div class="col" style="color: white">
            <p>©2022 Fog</p>
        </div>
        <div class="col" style="color: white">
            Fog Firma<br/>
        </div>
    </div>

</div>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>