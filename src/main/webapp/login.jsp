<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">



<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <body class="img-fluid align-items-md-stretch" style="background-image: url(images/bg3.jpeg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <br>
                        <br>
                        <br>
                        <br>
                        <h2 class="heading-section"><strong>Login</strong></h2>

                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h1></h1>



                            <form action="fc/login" method="post">
                                <input type="hidden" name="command" value="login"/>

                                <div class="form-group">

                                    <input type="text" class="form-control"
                                           placeholder="Brugernavn" id="username" name="username" required>
                                </div>
                                <div class="form-group">
                                    <input id="password" name="password" type="password" class="form-control" placeholder="Kodeord" required>
                                </div>
                                <div class="form-group">
                                    <button type="submit" style="background-color: #000C66" class="form-control btn btn-primary submit px-3">Log ind</button>
                                </div>
                                    <div class="w-50 text-md-right">
                                        <a href="#" style="color: #fff">Glemt kodeord?</a>
                                    </div>
                            </form>

                            <form action="createUser.jsp">
                            <div class="form-group">
                                <button type="submit" style="background-color: darkgreen" class="form-control btn btn-primary submit px-3">Opret ny konto</button>
                            </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

        </body>




<%--
    <body>

    </body>

        <h3>You can log in here</h3>

        <form action="fc/login" method="post">
            <input type="hidden" name="command" value="login"/>
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>

            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit"  value="Log in"/>
        </form>
--%>

    </jsp:body>
</t:pagetemplate>