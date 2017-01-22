<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
    <a href="/" class="logo">
        <span class="logo-mini"><b>A</b>LT</span>
        <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">Alexander Pierce</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-footer">
                            <a href="#" class="btn btn-default btn-flat">Sign out</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<s:url value="/resources" />/images/images.jpg" border="0" width="50px" height="40px"/>
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i>
                    <span>Layout Options</span>
                    <span class="label label-primary pull-right">4</span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/topic/list"/>">
                            <i class="fa fa-circle-o"></i> List Topic
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/stock/list"/>">
                            <i class="fa fa-circle-o"></i> List Stock
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/stockDetail/list"/>">
                            <i class="fa fa-circle-o"></i> List Stock Detail
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/forest/list"/>">
                            <i class="fa fa-circle-o"></i> List Forest
                        </a>
                    <li>
                        <a href="<c:url value="/tree/list"/>">
                            <i class="fa fa-circle-o"></i> List Tree
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
</aside>