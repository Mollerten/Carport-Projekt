<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="title">
        SVG tegning
    </jsp:attribute>

    <jsp:attribute name="header">
        SVG tegning
    </jsp:attribute>

    <jsp:attribute name="footer">
        SVG tegning
    </jsp:attribute>

    <jsp:body>
        ${requestScope.svgDrawing}
    </jsp:body>

</t:pagetemplate>