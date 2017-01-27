<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create A Forest</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/css/bootstrap.min.css" />">
    <style>
        span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
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
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center">Create Forest</h3>
            <form method="post" class="form-horizontal">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="forestId">Forest Name</label>
                        <select class="pull-right form-control input-md" name="forestId" id="forestId">
                            <c:forEach var="forest" items="${forests}">
                                <option value="${forest.getForestId()}">
                                        ${forest.getForestName()}
                                </option>
                            </c:forEach>
                        </select>
                        <errors name="forest" class="error"/>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="treeIdentity">Tree Identity</label>
                        <input class="pull-right form-control input-md" name="treeIdentity" id="treeIdentity"
                               placeholder="Enter Forest Code"/>
                        <errors name="forestCode" class="error"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6 col-lg-offset-3">
                                <div class="pull-left">
                                    <input type="submit" value="Create" class="btn btn-flat btn-success ">
                                </div>
                                <div class="pull-right">
                                    &nbsp;<a class="btn btn-flat btn-info" href="<s:url value="/forest/list"/>">Forest List</a>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
