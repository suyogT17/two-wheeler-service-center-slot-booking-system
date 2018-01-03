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
         <script>
         $(function(){
            /* $("#wrapper").toggleClass("toggled");*/
                
             $("#menu-toggle").click(function(e) {
                e.preventDefault();
                 $(this).toggleClass("change");
                 $("#wrapper").toggleClass("toggled");
                 $("#menu-toggle").toggleClass("position-button");
                 $("#main-row1").toggleClass("position-button");
                 $("#main-row2").toggleClass("position-button");
                 
        });
         
         });
         
    </script>
    
    
</head>
<body>
        
  
       <div id="wrapper" class="toggled">
	
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand" >
                    <a href="#">
                        TWSC
                    </a>
                </li>
                <li>
                    <a  href="viewservicecenter.html">View Service Center</a>
                </li>
                <!-- <li>
                    <a href="myservices.html">View Services</a>
                </li> -->
                <li>
                    <a href="viewusers.html">View Users</a>
                </li>
                <li>
                    <a href="adduser.html">Add Users</a>
                </li>
                <li>
                    <a href="viewallvehicles.html">View Vehicles</a>
                </li>
                <li>
                    <a href="addvehicle.html">Add Vehicles</a>
                </li>
                <li>
                    <a href="addservice.html">Add Services</a>
                </li>
                <li>
                    <a href="addservicecenter.html">Add Service Center</a>
                </li>
                <li>
                    <a href="transactions.html">View Transactions</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

    </div>
    <!-- /#wrapper -->
    <nav class="navbar navbar-inverse" id="nav-sidebar" >
    
        <div class="container-fluid">
            <div class="navbar-header">
                     <div class="menu-container" id="menu-toggle" >
                      <div class="bar1"></div>
                      <div class="bar2"></div>
                      <div class="bar3"></div>
            			</div>
            </div>
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    

		 <ul class="nav navbar-nav navbar-right">
                    <li class="custom-li-back"><a href="logout"><span class="fa  fa-sign-out"></span> Logout</a></li>
                </ul>
		
        </div>
        <!--End of Container-->

</div>
    </nav><!--End of Header-->
    


        

