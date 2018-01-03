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
    
    <style>
    .err{
    color:red;
    }
    
    </style>
    
    <script>
    
    $(document).ready(function(){
    		var regex=/^[A-Z a-z 0-9]/;
	    	var regex2=/^[A-Z a-z]/;
	    	var regex3=/\S+@\S+\.\S+/; 
	    	
    	$("#sbmit").click(function(){
    		
    		var vname=$("#vehiclename").val();
    		var cno=$("#chassisno").val();
    		var vno=$("#vehicleno").val();
    		var err=0;
    		if(vname.length==0 | !regex2.test(vname))
    			{
    				$("#errvehiclename").text("Enter Vehicle name");
    				err++;
    			}
    		
    		if(cno.length==0 | !regex.test(cno))
			{
				$("#errchassisno").text("Enter chassis number");
				err++;
			}
		
    		if(vno.length==0 | !regex.test(vno) )
			{
				$("#errvehicleno").text("Enter Vehicle number");
				err++;
			}
    		
    		
    		
    		if($("#user option:selected").val().length==0)
    			{
    			$("#erruser").text("Select user");
    			err++;
    			}
    	
    		if($("#branch option:selected").val().length==0)
			{
			$("#errbranch").text("Select branch");
			err++;
			}
		
    		if(err!=0)
			{
			return false;
			}
    	});
    	
    		$("#vehiclename").focus(function(){
    			$("#errvehiclename").text("");		
    		});
    		$("#chassisno").focus(function(){
    			$("#errchassisno").text("");
    		});
    		$("#vehicleno").focus(function(){
    			$("#errvehicleno").text("");
    		});
			$("#user").focus(function(){
				$("#erruser").text("");
    		});
			$("#branch").focus(function(){
				$("#errbranch").text("");
			});

    		
    		
    		
		
    	
    	
    	
    });
    
    </script>
   
   
  

</head>

<body class="bg-1">
<!-- Page Content -->
	<div class="row">
	<div class="col-lg-1"></div>
            <div class="col-lg-10 text-center">
                <h1 class="page-header form-head">
                    Add Vehicle
                    
                </h1>
              	      
                </div>
        </div>
        <!-- /.row -->
        
           <!-- Content Row -->
        <div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">			
				<div class="panel panel-default panel-shadow-form text-color-black">
                    <div class="panel-heading"><p class="lead">Enter vehicle details here</p></div>
	  					<div class="panel-body">
	    					
	    					<form:form action="addvehicle1.html" id="addvehicle" modelAttribute="addvehicle" method="post">
	    						 <div class="form-group">
      							<label >Name:</label>
								<form:input path="vehicleName" type="text" class="form-control" name="vehiclename" id="vehiclename"/> 
								<label id="errvehiclename" class="err"></label>
    							 </div>
	    					
	    						 <div class="form-group">
      							   <label>Chassis No:</label>
        						   <form:input path="chassisNo" type="text" class="form-control" name="chassisno" id="chassisno"/>
      								<label id="errchassisno" class="err"></label>	 
    							 </div>
    							 
    							  <div class="form-group">
      								<label>Vehicle No:</label>
      								<form:input path="number" type="text" class="form-control" name="vehicleno" id="vehicleno"/>
      								<label id="errvehicleno" class="err"></label>
    							 </div>
    							 
    							 <div class="form-group">
								    <label>User Name:</label>
								        <form:select path="userIds" class="form-control" name="user" id="user">
								         <form:option value="" label="-------Select User Name------"/>								          

										  <c:forEach items="${userList}" var="b">
								          <form:option value="${b.userId}">${b.userName} </form:option>
								          </c:forEach>
								          
								         </form:select>
								      <label id="erruser" class="err"></label>
    							 </div>
    							 
    							 <div class="form-group">
								    <label>Branch:</label>
								      
								        <form:select path="branchIds" class="form-control" name="branch" id="branch">
										<form:option value="" label="-------Select Branch------"/>								          

										  <c:forEach items="${branchList}" var="b">
								          <form:option value="${b.branchId}">${b.branchName} </form:option>
								          </c:forEach>
								        </form:select>
								        <label id="errbranch" class="err"></label>
								     
    							 </div>
    							

    							 
    							  <div class="form-group">
								      <div class="col-lg-10 col-lg-offset-3">
								        <button type="reset" class="btn btn-default">Cancel</button>
								        <button type="submit" id="sbmit" class="btn btn-primary">Submit</button>
								      </div>
								  </div>
	    					</form:form>
	    					</div>
	  					</div>
				</div>		
			</div>
     
        <!-- /.row -->

       

        <!-- Footer -->
        

  
    </body>
    
    </html>