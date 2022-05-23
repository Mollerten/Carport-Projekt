<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <%--        Hvis brugeren/admin ikke er logget ind--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu - log ind her:
                <a href="login.jsp">Login</a></p>

        </c:if>

        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
            <form action="${pageContext.request.contextPath}/fc/profil" method="post">
                <input type="hidden" name="command" value="profil"/>
                <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Opdater Profil"/>
            </form>


            <h1 style="color: #000C66; text-align: left">Carport Designer:</h1>


            <br>
            <br>
            <br>

            <form action="${pageContext.request.contextPath}/fc/OpretRequest?command=opretrequest" method="post">
                <label for="length_cp">Carport Længde:</label>
                <select name="length_cp" id="length_cp">

                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>

                <br>

                <label for="width_cp">Carport Bredde:</label>
                <select name="width_cp" id="width_cp">
                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>

                <br>

                <label for="length_rr">Tag Længde:</label>
                <select name="length_rr" id="length_rr">
                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>

                <br>

                <label for="width_rr"> Tag Bredde:</label>
                <select name="width_rr" id="width_rr">
                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="150">150 CM</option>
                    <option value="180">180 CM</option>
                    <option value="210">210 CM</option>
                    <option value="240">240 CM</option>
                    <option value="270">270 CM</option>
                </select>

                <br>

                <label for="roof_mat"> Tag Materiale:</label>
                <select name="roof_mat" id="roof_mat">
                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="Eg">Eg</option>
                    <option value="Mahogni">Mahogni</option>
                </select>

                <br>

                <label for="wood_cladding_mat"> Beklædning:</label>
                <select name="wood_cladding_mat" id="wood_cladding_mat">
                    <option value="Vælg" disabled selected hidden>Vælg</option>
                    <option value="Eg">Eg</option>
                    <option value="Mahogni">Mahogni</option>
                </select>

                <br>

                <input type="submit" value="Opret Request"/>


                <input type="hidden" value="8" name="customer_id"/><br/>

            </form>

        </c:if>
    </jsp:body>

</t:pagetemplate>