<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

     <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
    
     <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    
      <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/js/dropdown.js"></script>
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/two-wheeler.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>

   
</head>
<body class="bg-1">
<!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header text-center form-head">My Profile
                   
                </h1>
              	      
		</div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <div class="col-lg-1"></div>
             <div class="col-lg-10">
             	<div class="panel panel-default text-color-black panel-shadow-form">
                        <div class="panel-heading">
                            Details
                        </div>
                        <div class="panel-body">
	                        <div class="row">
	                        <div class="form-group text-center">
                                    <i class="fa fa-user fa-5x "></i>
                                </div>
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> User Name:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.username}</label>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> First Name:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.firstname}</label>
	                        		</div>
	                        	</div>
	                        	
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> Email Id:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.emailid}</label>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> Contact Number:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.contactnumber}</label>
	                        		</div>
	                        	</div>
	                        	
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> addressline1:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.addressline1}</label>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> addressline2:</label> <i class="form-control-static"></i>
	                        		<label>${registrationDto.addressline2}</label>
	                        		
	                        		</div>
	                        	</div>
	                        	
	                        </div>
	           			 
                        </div>
                        
                    </div>   
            </div>
        </div>
        <!-- /.row -->

       
    </div>
    </body>
    </html>