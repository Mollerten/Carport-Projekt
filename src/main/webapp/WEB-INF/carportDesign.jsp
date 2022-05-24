<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
        Carport designer
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="../login.jsp">Login</a></p>
        </c:if>

        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">

            <head>
                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/requestCSS.css"/>
            </head>

            <body>

            <h1 style="color: #000C66; text-align: left">Carport Designer:</h1>

            <br>
            <br>
            <br>

            <form action="${pageContext.request.contextPath}/fc/OpretRequest?command=opretrequest" method="post">

                <div class="options">
                <label for="length_cp">Carport Længde:</label>
                <select name="length_cp" id="length_cp" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="width_cp">Carport Bredde:</label>
                <select name="width_cp" id="width_cp" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="length_rr">	Skur Længde:</label>
                <select name="length_rr" id="length_rr" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="width_rr"> 	Skur Bredde:</label>
                <select name="width_rr" id="width_rr" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="roof_mat"> Tag Materiale:</label>
                <select name="roof_mat" id="roof_mat" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="Eg">Eg</option>
                    <option value="Mahogni">Mahogni</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="wood_cladding_mat"> Træ Beklædning Materiale:</label>
                <select name="wood_cladding_mat" id="wood_cladding_mat" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="Eg">Eg</option>
                    <option value="Mahogni">Mahogni</option>
                </select>
                </div>

                <input type="hidden" value="8" name="customer_id"/><br/>

                <br>

                <input type="button" value="Opret Request"/>

            </form>

            </body>
        </c:if>
    </jsp:body>
</t:pagetemplate>
