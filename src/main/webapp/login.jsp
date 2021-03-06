<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <head>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
        </head>

        <br>
        <br>
        <br>

        <body>

        <h1>Login</h1>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">



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
                                <button type="submit" style="background-color: #45c007" class="form-control btn btn-primary submit px-3">Opret ny konto</button>
                            </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        </body>

    </jsp:body>
</t:pagetemplate>