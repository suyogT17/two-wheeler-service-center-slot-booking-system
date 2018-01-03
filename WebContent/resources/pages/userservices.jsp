<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <title>Modern Business - Start Bootstrap Template</title>
    
     <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
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
	<div class="row">
	<div class="container-fluid" id="add-user-container">

        <div class="page-header text-center">
            
                    <h1>Add New Service</h1>
                    
        </div><!--Page Header-->
        
         <div class="row">
        
                    
                    <div class="col-md-3">
                    </div>
                    
                    <div class="col-md-6">
           
               
               
               <div class="panel-group">
                    <c:forEach items="${allList}" var="all" varStatus="status">
                   
                   	
             	
                   
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" href="#collapse${status.index}"> ${serviceTypeList[status.index].serviceTypeName}</a>
						        </h4>
						      </div>
						  
						 	
						 	
						 	<div id="collapse${status.index}" class="panel-collapse collapse">
      							 <ul class="list-group">
      						<c:forEach items="${all}" var="a" varStatus="st">
						 		<li class="list-group-item" style="color : #3A2925; font-size: 15px ;"> ${a.name} </li>
						 	</c:forEach> 
						 	</ul>	
						 </div>
						 
						 </div>	
						 
				    
				   
				    </c:forEach>
				   </div>
				  
             
      </div>  
        
    </div><!--.container-->

	</div>
</body>
</html>
	