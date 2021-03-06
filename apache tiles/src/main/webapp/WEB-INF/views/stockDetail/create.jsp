<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create A Stock</title>
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
            <h3 class="text-center">Create Stock</h3>
            <form method="post" class="form-horizontal">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="stock">Stock Name</label>
                        <select class="pull-right form-control input-md" name="stockId" id="stockId">
                            <c:forEach var="stock" items="${stocks}">
                                <option value="${stock.getStockId()}">
                                        ${stock.getStockName()}
                                </option>
                            </c:forEach>
                        </select>
                        <errors name="stock" class="error"/>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="compName">Comapny Name</label>
                        <input class="pull-right form-control input-md" name="compName" id="compName"
                               placeholder="Enter Stock Code"/>
                        <errors name="stockCode" class="error"/>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="compDesc">Comapny Description</label>
                        <input class="pull-right form-control input-md" name="compDesc" id="compDesc"
                               placeholder="Enter Stock Code"/>
                        <errors name="stockCode" class="error"/>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="remark">Remark</label>
                        <input class="pull-right form-control input-md" name="remark" id="remark"
                               placeholder="Enter Stock Code"/>
                        <errors name="stockCode" class="error"/>
                        <br>
                    </fieldset>
                    <%--<fieldset>
                        <label class="text-left control-label" for="listedDate">Listed Date</label>
                        <input class="pull-right form-control input-md" name="listedDate" id="listedDate"
                               placeholder="Enter Stock Code"/>
                        <errors name="stockCode" class="error"/>
                        <br>
                    </fieldset>--%>

                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6 col-lg-offset-3">
                                <div class="pull-left">
                                    <input type="submit" value="Create" class="btn btn-flat btn-success ">
                                </div>
                                <div class="pull-right">
                                    &nbsp;<a class="btn btn-flat btn-info" href="<s:url value="/stock/list"/>">Stock List</a>
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
