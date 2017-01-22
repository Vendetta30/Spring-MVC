<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Topics</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/css/bootstrap.min.css" />">
</head>
<body>
<div class="container-fluid">
    <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
                Demo</b></h1></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
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
    </div>
</div>
</body>
</html>