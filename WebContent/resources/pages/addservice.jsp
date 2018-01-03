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
 
        <title>Add service</title>

    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    

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
    	
    $("#sbbtn").click(function(){
    	var sname=$("#formSName").val();
    	var stime=$("#formSTime").val();
    	var scost=$("#formSCost").val();
    	var regex=/^[0-9]/;
    	var regex2=/^[a-z A-Z]/;
    	var err=0;
    	if(sname.length==0 | !regex2.test(sname))
    		{
    			$("#errformSName").text("Enter service name");
    			err++;
    		}
    	
    	if(stime.length==0 | !regex.test(stime))
		{
			$("#errformSTime").text("Enter Time ");
			err++;
		}
    	
    	if(scost.length==0 | !regex.test(scost))
		{
			$("#errformSCost").text("Enter Cost");
			err++;
		}
    	
    	if($("#serviceType option:selected").val().length==0)
		{
			$("#errserviceType").text("Select Service Type");
			err++;
		}
    	console.log(err)
    	if(err!=0)
    		{
    		return false;
    		}
    });
    
    
    $("#formSName").focus(function(){
    	$("#errformSName").text("");
    });
    
    $("#formSCost").focus(function(){
    	$("#errformSCost").text("");
    });
    
    $("#formSTime").focus(function(){
    	$("#errformSTime").text("");
    });
    
    $("#serviceType").focus(function(){
    	$("#errserviceType").text("");
    });
    	
    });
    </script>
    
    
    
    
    
</head>
 
  <body class="bg-1">

    <div class="container-fluid" id="add-user-container">
        <div class="page-header text-center">
            
                    <h1>Add New Service</h1>
                    
        </div><!--Page Header-->
        
         <div class="row">
        
                    
                    <div class="col-md-3">
                    </div>
                    
                    <div class="col-md-6">
                    <div class="panel panel-default panel-shadow-form text-color-black">

				    <div class="panel-body">
                    <form:form action="addservice1.html" method="post" modelAttribute="addnewservice" id="add-serv-form">


                            <div class="form-group">

                                <label>Service Name</label>
                                <form:input path="name" type="text" id="formSName" class="form-control" name="formSName"/>
								<label id="errformSName" class="err"></label>
                            </div>
                            
                            <div class="form-group">

                                <label>Service Cost</label>
                            <!--     <span class="input-group-addon"><i class="fa fa-inr"></i></span> -->
                                <form:input path="charges" type="text" id="formSCost" class="form-control" name="formSCost"/>
                                <label id="errformSCost" class="err"></label>
                            </div>
                        
                            <div class="form-group">

                                <label>Service Time(in hrs)</label>
                                <form:input path="timeToComplete" type="text" id="formSTime" class="form-control" name="formSTime"/>
                                <label id="errformSTime" class="err"></label>
                            </div>
                        
                             <div class="form-group">

                                <label>Service Type</label>
                                <br>
                                <form:select path="serviceTypeIds" class="form-control" id="serviceType" name="serviceType">
                               	<option disabled selected value="">Select a service type</option>
                              
                                
                                 
                                  <c:forEach items="${serviceTypeList}" var="ser">
                                  
                                  <form:option value="${ser.serviceTypeId}"> ${ser.serviceTypeName} </form:option>
                                  
                                  </c:forEach> 
                                </form:select>
                                <label id="errserviceType" class="err"></label>
                            </div>
                             <button id ="sbbtn" type="submit" class="btn btn-primary">Submit</button>

                    </form:form>
                        </div>
                        </div>
                </div><!--end of col-md-6-->
             
      </div>  
        
    </div><!--.container-->

</body>
 
</html>