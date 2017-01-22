<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page session="false" %>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
<spring:url value="/resources/css/shop-item.css" var="shopCss"/>
<spring:url value="/resources/css/skin-blue.min.css" var="skin"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring Application</title>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${shopCss}" rel="stylesheet"/>
    <link href="${skin}" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <t:insertAttribute name="header"/>
    <div class="content-wrapper">
        <t:insertAttribute name="body"/>
    </div>
    <t:insertAttribute name="footer"/>
</div>
<spring:url value="/resources/js/jQuery-2.1.4.min.js" var="jQuery"/>
<script src="${jQuery}" type="text/javascript"></script>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}" type="text/javascript"></script>
<spring:url value="/resources/js/app.min.js" var="app"/>
<script src="${app}" type="text/javascript"></script>
<spring:url value="/resources/js/demo.js" var="demo"/>
<script src="${demo}" type="text/javascript"></script>
</body>
</html>