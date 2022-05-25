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

            <style>
                body{
                    margin: 0;
                    padding: 0;
                    min-height: 100vh;
                    background-image: linear-gradient(skyblue,navy);
                    z-index: -1;
                }

            </style>

            <body>

            <h1 style="color: whitesmoke;font-size: 30px; margin: 0; font-weight: 900; text-align: left">Design din carport</h1>


            <br>
            <br>




            <form action="${pageContext.request.contextPath}/fc/opretrequest?command=opretrequest" method="post">
                <input type="hidden" name="command" value="opretrequest"/>


                <div class="options">
                <label for="length_cp"><b>Carport Længde:</b></label>
                <select name="length_cp" id="length_cp" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="210">210 cm</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>
                    <option value="720">720 cm</option>
                    <option value="750">750 cm</option>
                    <option value="780">780 cm</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="width_cp"><b>Carport Bredde:</b></label>
                <select name="width_cp" id="width_cp" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="210">210 cm</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="length_rr"><b>Skur Længde:</b></label>
                <select name="length_rr" id="length_rr" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="0">Ikke implementeret</option>

                </select>
                </div>

                <br>

                <div class="options">
                <label for="width_rr"><b>Skur Bredde:</b></label>
                <select name="width_rr" id="width_rr" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="0">Ikke implementeret</option>

                </select>
                </div>

                <br>

                <div class="options">
                <label for="roof_mat"><b>Tag Materiale:</b></label>
                <select name="roof_mat" id="roof_mat" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="not_yet_implemented">Ikke implementeret</option>
                </select>
                </div>

                <br>

                <div class="options">
                <label for="wood_cladding_mat"><b>Træ Beklædning Materiale:</b></label>
                <select name="wood_cladding_mat" id="wood_cladding_mat" required>
                    <option value="" disabled selected hidden>Vælg</option>
                    <option value="not_yet_implemented">Ikke implementeret</option>
                </select>
                </div>

                <br/>

                <br>

                <input type="hidden" name="customer_id" value="${sessionScope.user.id}"/>

                <input style="display: block; width: 200px; margin-right: auto; text-align: center;background: green;
                       color: #FFFFFF;padding: 20px 24px;border-radius: 19px;
                       font-size: 18px;" type="submit" value="Send forespørgsel"/>

            </form>

            </body>
        </c:if>
    </jsp:body>
</t:pagetemplate>
