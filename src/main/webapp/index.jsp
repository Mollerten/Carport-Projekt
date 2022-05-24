<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<t:pagetemplate>

    <jsp:attribute name="title">
        FOG - Holder I Længden
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen til FOG
    </jsp:attribute>

    <jsp:body>

            <link rel="stylesheet" href="css/style.css">

            <video id="background-video" autoplay muted loop src="videos/carportvideo.mp4"></video>

            <h2>FOG - Holder I Længden</h2>

    </jsp:body>


</t:pagetemplate>