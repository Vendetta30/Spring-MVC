<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Create A Stock</title>
</head>
<body>
<section class="content-header">
    <h1>
        Stock
        <small>Stock</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Create Stock</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Create Stock</h3>
                </div>
                <form role="form" method="post">
                    <div class="box-body">
                        <div class="form-group">
                            <label class="text-left control-label" for="stockName">Stock Name</label>
                            <input class="pull-right form-control input-md" name="stockName" id="stockName"
                                   placeholder="Enter Stock Name"/>
                            <errors name="stockName" class="error"/>
                        </div>
                        <div class="form-group">
                            <label class="text-left control-label" for="stockName">Stock Code</label>
                            <input class="pull-right form-control input-md" name="stockCode" id="stockCode"
                                   placeholder="Enter Stock Code"/>
                            <errors name="stockCode" class="error"/>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="submit" value="Create" class="btn btn-flat btn-primary">
                            </div>
                            <div class="col-md-6">
                                <a class="btn btn-flat btn-info pull-right" href="<s:url value="/stock/list"/>">Stock List</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</section>
</body>
</html>
