<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 

 
 <!-- jQuery -->
 <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>

 <!-- Bootstrap Core JavaScript -->
 <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
         

</head>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="homepage.html">TWSC</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active custom-li-back"><a href="book.html">Book Slot <span class="sr-only">(current)</span></a></li>
        <li class="custom-li-back"><a href="myservices.html">View Services</a></li>
                <li class="custom-li-back"><a href="myservicecenters.html">View Service Center</a></li>
        
          </ul>     
		 <ul class="nav navbar-top-links navbar-right">     
		<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-2x fa-user "></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="myprofile.html">My Profile</a>
                            </li>
                            <li>
                                <a href="change.html">Change Password</a>
                            </li>
                 
                            <li class="divider"></li>
                           <li>
                                <a href="logout.html">Logout</a>
                            </li> 
                        </ul>
       </li>
        </ul>
 
 
      
    </div>
</div>
</nav>
    