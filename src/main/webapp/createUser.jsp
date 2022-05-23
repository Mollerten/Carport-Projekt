<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
    Opret bruger
    </jsp:attribute>

    <jsp:attribute name="footer">
            Opret bruger
    </jsp:attribute>

    <jsp:body>

        <head>
            <link rel="stylesheet" href="css/style2.css">
        </head>


        <form action="fc/createUser" method="post">
            <input type="hidden" name="command" value="createUser"/>

            <body>
            <div class="wrapper">

            <div class="form_container">
                <form name="form">
                    <div class="heading">
                        <h2>Opret Bruger</h2>
                    </div>
                    <div class="form_wrap">
                        <div class="form_item">
                            <label for="username">Brugernavn</label>
                            <input type="text" id="username" name="username" required/>
                        </div>
                    </div>
                    <div class="form_wrap">
                        <div class="form_item">
                            <label for="email">Email: </label>
                            <input type="email" id="email" name="email" required/>
                        </div>
                    </div>

                    <div class="form_wrap">
                        <div class="form_item">
                            <label for="password">Kodeord: </label>
                            <input type="password" id="password" name="password" required/>
                        </div>
                    </div>

                    <div class="form_wrap ">
                        <div class="form_item">
                            <label for="tlfnr">Telefonnummer:</label>
                            <input type="number" id="tlfnr" name="tlfnr" required>
                        </div>
                    </div>

                    <div class="form_wrap">
                        <div class="form_item">
                            <label for="address">Adresse: </label>
                            <input type="text" id="address"  name="address" required/>
                        </div>
                    </div>


                    <div class="form_wrap fullname">
                        <div class="form_item">
                            <label for="city">By: </label>
                            <input type="text" id="city" name="city" required/>
                        </div>

                        <div class="form_item">
                            <label>Postnummer:</label>
                            <input type="number" id="postalCode" name="postalCode" required>
                        </div>
                    </div>

                    <div class="btn">
                        <input type="submit" value="Opret bruger">
                    </div>
                </form>
            </div>
        </div>
        </body>



<%--        <form action="fc/createUser" method="post">
            <input type="hidden" name="command" value="createUser"/>
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

            <input type="submit"  value="Create user"/>
        </form>--%>

    </jsp:body>
</t:pagetemplate>