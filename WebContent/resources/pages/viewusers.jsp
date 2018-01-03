<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Tech Know Admin Template</title>
  
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>
    
    
</head>
<body class="bg-1">
   <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
            		<br/>
                <div class="row" id="main-row1">
                   <!--  Start designing your Html body from here -->
                   
                     <div class="col-md-12">
                           <div class="panel panel-primary">
                                  <div class="panel-heading">
                                         All users
                                  </div>
                                  <div class="panel-body">
                                         <div class="well">
                                                <div class="dataTable_wrapper">
                                                       <table class="table table-striped table-bordered table-hover" id="tabledata">
                                                              <thead>
                                                                                         <tr>
                                                                                                
																								<th style="background-color: #0FA0A7;">User Name</th>
																								<th style="background-color: #0FA0A7;">First Name</th>
																								<th style="background-color: #0FA0A7;">Last Name</th>
																							    <th style="background-color: #0FA0A7;">Contact No.</th>
																								<th style="background-color: #0FA0A7;">Email</th>
																								
																								<th style="background-color: #0FA0A7;">Creation Date</th>
																								<!-- <th>effectiveDate</th> -->
																									<!-- <th>endDate</th> -->
																								<!-- <th style="background-color: #0FA0A7;">Branch</th> -->
																								
                                                                                         </tr>
                                                                                  </thead>
                                                                                  <c:forEach items="${user}" var="v">	
                                                                                  	<tr>
                                                                                                
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.userName } </td>
																							     <td style="background-color: #0FA0A10; color:#3A2925;">${v.firstName} </td>
																							    <td style="background-color: #0FA0A10; color:#3A2925;">${v.lastName} </td>
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.contactNo}</td>
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.emailId }</td>
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.creationDate }</td>
																								
                                                                                         </tr>		
                                                                                   </c:forEach>      
                                                       </table>
                                                </div>
                                         </div>
                                  </div>
                           </div>
                           </div>
                  
 
                </div>
                <!-- /.row -->
                
                
                
                
                </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
  
 
</body>
</html>