<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>List of Stocks</title>
</head>
<body>
<section class="content-header">
    <h1>
        Stock List
        <small>Stocks</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">List</a></li>
        <li class="active">Stock</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">Stock List</h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <c:if test="${stocks.isEmpty()}">
                        <div class="alert alert-danger">No Stock Record's Found</div>
                    </c:if>
                    <c:if test="${!stocks.isEmpty()}">
                        <div class="table-responsive">
                            <table class="table no-margin">
                                <thead>
                                <tr>
                                    <th>S.No.</th>
                                    <th>Stock Name</th>
                                    <th>Stock Code</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="stock" items="${stocks}" varStatus="i">
                                    <tr>
                                        <td>${i.index +1}</td>
                                        <td>${stock.getStockName()}</td>
                                        <td>${stock.getStockCode()}</td>
                                        <td>
                                            <div class="tools">
                                                <a class="btn btn-flat btn-primary"
                                                   href="<s:url value="/stock/edit/${stock.getStockId()}"/>">
                                                    <i class="fa fa-edit"></i>
                                                </a>&nbsp;
                                                <a class="btn btn-flat btn-danger"
                                                   href="<s:url value="/stock/delete/${stock.getStockId()}"/>">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
                <div class="box-footer clearfix">
                    <a href="<c:url value="/stock/create"/>" class="btn btn-flat btn-default pull-right">
                        <i class="fa fa-plus"></i> Add item
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>