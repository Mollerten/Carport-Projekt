<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        SVG test
    </jsp:attribute>

    <jsp:attribute name="footer">
        SVG test
    </jsp:attribute>

    <jsp:body>
        <svg width="127" height="105" viewBox="0 0 255 210">
            <rect x="0" y="0" height="255" width="255"
                  stroke="#000" fill="#ff0"></rect>
            <rect x="0" y="0" height="90" width="90"
                  stroke="#000" fill="#23f"></rect>
            <rect x="120" y="0" height="90" width="135"
                  stroke="#000" fill="#23f"></rect>
            <rect x="0" y="120" height="90" width="90"
                  stroke="#000" fill="#23f"></rect>
            <rect x="120" y="120" height="90" width="135"
                  stroke="#000" fill="#23f"></rect>
        </svg>
    </jsp:body>

</t:pagetemplate>