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


<%--        Hvis kontoen er user--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"user\"}">
            <p>Velkommen tilbage bruger</p>
            <p>Du er logget ind med rollen:  "${sessionScope.user.role}".</p>
        </c:if>

<%--        Hvis kontoen er admin--%>
        <c:if test="${sessionScope.user != null && sessionScope.user.role eq \"admin\"}">

            <link rel="stylesheet" href="scss/style.scss">

            <body style="background-attachment: fixed; background-size: cover; background-repeat: no-repeat; background-image: url(${pageContext.request.contextPath}/images/adminpaa.jpg)";>

            <h1>Velkommen tilbage Admin</h1>

            <h2> Du er logget ind med rollen: "${sessionScope.user.role}".</h2>

            <form action="fc/stockside" method="post">
            <input type="hidden" name="command" value="stockside"/>
            <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Se Stock"/>
            </form>
            <br>
            <form action="fc/requestside" method="post">
                <input type="hidden" name="command" value="requestside"/>
                <input type="submit" style="background-color: #000C66" class="btn btn-primary submit px-3"  value="Se Requests"/>
            </form>
            <br>
            </body>


        </c:if>

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





        <form action="/action_page.php" id="carport">

        </form>

        <label for="cars">Carport Længde:</label>
        <select name="cars" id="cars" form="carport">
            <option value="length_cp">Volvo</option>
        </select>

        <label for="cars">Carport bredde:</label>
        <select name="cars" id="cars" form="carport">
            <option value="width_cp">Volvo</option>
        </select>

        <label for="cars">Tag Længde:</label>
        <select name="cars" id="cars" form="carport">
            <option value="length_rr">Volvo</option>
        </select>

        <label for="cars">Tag Bredde:</label>
        <select name="cars" id="cars" form="carport">
            <option value="width_rr">Volvo</option>
        </select>

            <h1>Carport Designer:</h1>

            <form action="fc/Opretrequest" method="post">
                <input type="hidden" name="command" value="opretrequest"/>

                <label for="length_cp">Carport Længde:</label>
                <input type="text" id="length_cp" name="length_cp"/><br/>

                <label for="width_cp">Carport Bredde: </label>
                <input type="text" id="width_cp" name="width_cp"/><br/>

                <label for="length_rr">Tag Længde: </label>
                <input type="text" id="length_rr" name="length_rr"/><br/>

                <label for="width_rr">Tag Bredde: </label>
                <input type="text" id="width_rr" name="width_rr"/><br/>

                <label for="roof_mat">Tag Materiale: </label>
                <input type="text" id="roof_mat" name="roof_mat"/><br/>

                <label for="wood_cladding_mat">Tag Beklædning: </label>
                <input type="text" id="wood_cladding_mat" name="wood_cladding_mat"/><br/>

                <label for="customer_id">Din Mor: </label>
                <input type="text" id="customer_id" name="customer_id"/><br/>

                <label for="admin_id">Er Stor: </label>
                <input type="text" id="admin_id" name="admin_id"/><br/>

                <input type="submit" value="Opret Request"/>
            </form>


        </c:if>
    </jsp:body>

</t:pagetemplate>