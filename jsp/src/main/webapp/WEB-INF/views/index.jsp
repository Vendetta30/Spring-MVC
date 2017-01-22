<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Link Sharing</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/shop-item.css" var="shopCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${shopCss}" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Start Bootstrap</a>
        </div>
        <div class="collapse navbar-collapse" stockDetailId="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead">Shop Name</p>
            <div class="list-group">
                <a href="<spring:url value="/topic/create"/>" class="list-group-item">Create Topic</a>
                <a href="<spring:url value="/stock/create"/>" class="list-group-item">Create Stock</a>
                <a href="<spring:url value="/stockDetail/create"/>" class="list-group-item">Create Stock Detail</a>
                <a href="<spring:url value="/forest/create"/>" class="list-group-item">Create Forest</a>
                <a href="<spring:url value="/tree/create"/>" class="list-group-item">Create Tree</a>
            </div>
        </div>
        <div class="col-md-9">
            <div class="thumbnail">
                <div class="caption-full">
                    <h4 class="pull-right">$24.99</h4>
                    <h4><a href="#">Topic Name</a>
                    </h4>
                    <c:if test="${topicList.isEmpty()}">
                        <div class="alert alert-danger">No Topic Record's Found</div>
                    </c:if>
                    <c:if test="${!topicList.isEmpty()}">
                        <table class="table table-responsive table-bordered">
                            <thead>
                            <tr>
                                <th>S.No.</th>
                                <th>ID</th>
                                <th>Topic Name</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="topic" items="${topicList}" varStatus="i">
                                <tr>
                                    <td>${i.index +1}</td>
                                    <td>${topic.getId()}</td>
                                    <td>${topic.getTopicName()}</td>
                                    <td>
                                        <a class="btn btn-success"
                                           href="<s:url value="/topic/edit?stockDetailId=${topic.getId()}"/>">Edit</a>/
                                        <a class="btn btn-danger"
                                           href="<s:url value="/topic/delete?stockDetailId=${topic.getId()}"/>">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div class="ratings">
                    <p class="pull-right">3 reviews</p>
                    <p>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        4.0 stars
                    </p>
                </div>
            </div>
        </div>

    </div>

</div>

<div class="container">
    <hr>
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>
</div>

<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>