<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Link Sharing</title>
</head>
<body>
<section class="content-header">
    <h1>
        Topic List
        <small>Topics</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">List</a></li>
        <li class="active">Topic</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-header">
                    <i class="ion ion-clipboard"></i>
                    <h3 class="box-title">Topic List</h3>
                </div>
                <div class="box-body">
                    <ul class="todo-list">
                        <c:if test="${topicList.isEmpty()}">
                            <div class="alert alert-danger">No Topic Record's Found</div>
                        </c:if>
                        <c:if test="${!topicList.isEmpty()}">
                            <c:forEach var="topic" items="${topicList}" varStatus="i">
                                <li>
                      <span class="handle">
                        <i class="fa fa-ellipsis-v"></i>
                        <i class="fa fa-ellipsis-v"></i>
                      </span>
                                    <input type="checkbox" value="" name="">
                                    <span class="text">${topic.getTopicName()}</span>
                                    <small class="label label-info"><i class="fa fa-clock-o"></i> 4 hours</small>
                                    <div class="tools">
                                        <a class="btn btn-flat btn btn-flat-primary"
                                           href="<s:url value="/topic/edit/${topic.getId()}"/>">
                                            <i class="fa fa-edit"></i>
                                        </a>

                                        <a class="btn btn btn-flat-danger"
                                           href="<s:url value="/topic/delete/${topic.getId()}"/>">
                                            <i class="fa fa-trash-o"></i>
                                        </a>
                                    </div>
                                </li>
                            </c:forEach>
                        </c:if>
                    </ul>
                </div>
                <div class="box-footer clearfix no-border">
                    <a href="<c:url value="/topic/create"/>" class="btn btn-flat btn-default pull-right">
                        <i class="fa fa-plus"></i> Add item
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>