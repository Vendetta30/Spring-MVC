<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit Stock</title>
</head>
<body>
<section class="content-header">
    <h1>
        Topic
        <small>Topic</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Edit Topic</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Edit Stock</h3>
                </div>
                <sf:form method="post" commandName="stock">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="stockName">Stock Name</label>
                            <sf:input cssClass="form-control" path="stockName" placeholder="Enter Stock Name"/>
                            <sf:errors path="stockName" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="stockName">Stock Name</label>
                            <sf:input cssClass="form-control" path="stockCode" placeholder="Enter Stock Code"/>
                            <sf:errors path="stockCode" cssClass="error"/>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-flat btn-primary" value="Submit"/>
                            </div>
                            <div class="col-md-6">
                                <a class="btn btn-flat btn-info pull-right" href="<s:url value="/stock/list"/>">Topic
                                    List</a>
                            </div>
                        </div>
                    </div>
                </sf:form>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</section>
</body>
</html>
