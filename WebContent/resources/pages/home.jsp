<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

    <style type="text/css">
    .menu
    {
    	background-color: #337ab7;
    	border-color: #337ab7;
    	color: #fff
    }
.bgimage{
 background-image: url("${pageContext.request.contextPath}/resources/images/backgrn.jpg");
 background-size: cover;
}
.fa-8x{
	font-size: 8em;
}

.panel-green {
    border-color: #5cb85c;
}

.panel-green .panel-heading {
    border-color: #5cb85c;
    color: #fff;
    background-color: #5cb85c;
}

.panel-green a {
    color: #5cb85c;
}

.panel-green a:hover {
    color: #3d8b3d;
}

.panel-red {
    border-color: #d9534f;
}

.panel-red .panel-heading {
    border-color: #d9534f;
    color: #fff;
    background-color: #d9534f;
}

.panel-red a {
    color: #d9534f;
}

.panel-red a:hover {
    color: #b52b27;
}

.panel-yellow {
    border-color: #f0ad4e;
}

.panel-yellow .panel-heading {
    border-color: #f0ad4e;
    color: #fff;
    background-color: #f0ad4e;
}

.panel-yellow a {
    color: #f0ad4e;
}

.panel-yellow a:hover {
    color: #df8a13;
}
    </style>
   
</head>
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Welcome
                    <small>${userinfo.firstName } ${userinfo.lastName }</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.html">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <!-- Sidebar Column -->
            
            <!-- Content Column -->
            <div class="col-md-12">
                <div class="panel panel-primary">
                		<!-- <div class="panel-heading">
                		<i class="fa fa-dashboard fa-fw"></i>
                			User Dashboard
                		</div> -->
                		<div class="panel-body bgimage">
                			<div class="col-md-3"> 
                				<div class="panel panel-primary">
				                        <div class="panel-heading">
				                            <div class="row">
				                               <div class="col-xs-2"></div>
				                                <div class="col-xs-10">
				                                    <i class="fa fa-wrench fa-8x"></i>
				                                </div>
				                                
				                            </div>
				                        </div>
				                        <a href="initaddservice.html">
				                            <div class="panel-footer">
				                                <span class="pull-center">Services</span>
				                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
				                                <div class="clearfix"></div>
				                            </div>
				                        </a>
                    			</div>		                							
                			 </div> 
                			 <div class="col-md-3"> 
                					<div class="panel panel-red">
				                        <div class="panel-heading">
				                            <div class="row">
				                                <div class="col-xs-2"></div>
				                                <div class="col-xs-10">
				                                    <i class="fa  fa-home fa-8x"></i>
				                                </div>
				                                
				                            </div>
				                        </div>
				                        <a href="showproducts.html?itemId=4">
				                            <div class="panel-footer">
				                                <span class="pull-center">Centers</span>
				                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
				                                <div class="clearfix"></div>
				                            </div>
				                        </a>
                    			</div>		
                							
                			 </div> 
                			 
                			 <div class="col-md-3"> 
                					<div class="panel panel-yellow">
				                        <div class="panel-heading">
				                            <div class="row">
				                                <div class="col-xs-2"></div>
				                                <div class="col-xs-10">
				                                    <i class="fa  fa-cog fa-8x"></i>
				                                </div>
				                                
				                            </div>
				                        </div>
				                        <a href="showproducts.html?itemId=3">
				                            <div class="panel-footer">
				                                <span class="pull-center">My Services</span>
				                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
				                                <div class="clearfix"></div>
				                            </div>
				                        </a>
                    				</div>		
                			 </div> 
                			 
                			 <div class="col-md-3"> 
                					<div class="panel panel-green">
				                        <div class="panel-heading">
				                            <div class="row">
				                            	<div class="col-xs-2"></div>
				                                <div class="col-xs-10">
				                                    <i class="fa fa-gift fa-8x"></i>
				                                </div>
				                            </div>
				                        </div>
				                        <a href="showproducts.html?itemId=1">
				                            <div class="panel-footer">
				                                <span class="pull-center">Offers</span>
				                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
				                                <div class="clearfix"></div>
				                            </div>
				                        </a>
                    				</div>		
                			 </div> 
                		</div>
                </div>
                
            </div>
            
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; 2016</p>
                </div>
            </div>
        </footer>

   

   

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>




