<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

        <title>Modern Business</title>

     <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/dist/css/two-wheeler.css" rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>
    
      
    <link href="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <script>
    
    		$(document).ready(function(){
    			$("#sbmit").click(function(){
    				
    			
    			if($("#vehicle option:selected").val().length==0)
    			{
    			$("#errvehicle").text("Select vehicle");
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
    			})
    			
});
</script>
 
<style>
.err{
color : red;
}
</style>
   

</head>
<body  class="bg-1">
<!-- Page Content -->
<div class="row" id="main-row1">
	<div class="col-lg-1"></div> 

            <div class="col-lg-10">
                <h1 class="page-header text-center form-head">Book Service Slot
                    
                </h1>
                  
		</div>
        </div>
        		
        <!-- /.row -->
        <!-- Content Row -->
        <div class="row">
			<div class="col-lg-3">
			</div>
			<div class="col-lg-6">			
				<div class="panel panel-default panel-shadow-form">
					 <div class="panel-heading lead">Book Service Slot</div>
	  					<div class="panel-body">
	  						
	    					
							<form:form id="addservicecenterform"  modelAttribute="bookaslot" action="book1.html" method="post">
								<div class="row">
									<div class="col-lg-2">
									</div>								
										<div class="col-lg-8">
										<center><label  style="color : #3A2925; font-size: 25px;"><h3>Select Branch and vehicle</h3></label></center>	
										</div>
								</div>
								<div class="row">	
									<div class="col-lg-2">
									</div>	
									<div class="col-lg-8">
										<div class="form-group">
										      <label for="select" style="color : #3A2925; font-size: 15px;">Select Vehicle</label>
										      
										        <form:select class="form-control" id="vehicle" path="vehicleIds">
										          <form:option value="">------Select Vehicle------</form:option>
										          	<c:forEach items="${vehicleList}" var="a" varStatus="st">
												 		<form:option value="${a.vehicleId}" >${a.vehicleName }</form:option>
												 	</c:forEach> 
												 </form:select>
												 <label  id="errvehicle" class="err"></label>
										     
										</div>       	 
    							 	</div>
    							 </div>	
    							 <div class="row">
    							 		<div class="col-lg-2">
										</div>	
      								<div class="col-lg-8">	 
      									 <div class="form-group">
        								   <label for="select" style="color : #3A2925; font-size: 15px;">Select Service Center</label>
										     
										        <form:select class="form-control" id="branch" path="branchIds">
										          <form:option value="">------Select Branch------</form:option>
										          	<c:forEach items="${branchList}" var="a" varStatus="st">
												 		<form:option value="${a.serviceCenterId}">${a.serviceCentername }</form:option>
												 	</c:forEach> 
										        </form:select>
										     <label  id="errbranch" class="err"></label>
      									 </div>      							               							  
									</div>
								</div>
								
								<div class="row">
									<div class="col-lg-2">
									</div>
									<div class="col-lg-8">
										<center><label style="color : #3A2925; font-size: 25px;"><h3>Select Services</h3></label></center>
									</div>
								</div>	
								<div class="row">
									<div class="col-lg-2">
									</div>
									<div class="col-lg-8">
	
				    
				   
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
												 		<li class="list-group-item" style="color : #3A2925; font-size: 20px ;"><input type="checkbox"  value="${a.serviceId }" name="service"/> ${a.name} </li>
												 	</c:forEach> 
												 	</ul>	
												 </div>
							 
									</div>	
							 
					    
					   		
					   </c:forEach>
					   </div>
				   
				    </div>
				    </div>
							
							
							<div class="row">
								<div class="col-lg-2">
								</div>	
                           		 	<div class="col-lg-8">
									
                           		
                           		 	<form:checkbox  name="pick" path="bpick"/> <label style="color : #3A2925; font-size: 20px ;">pick</label> 
                           		 		<form:checkbox   name="drop" path="bdrop"/><label style="color : #3A2925; font-size: 20px ;">drop</label> 
                           		</div>
							</div>
							                           		
                           			<div class="row">
                           		 <div class="col-lg-2">
                           		 
                           		 </div>
                           		 <div class="col-lg-8">
                           		
                               
                                <button type="submit"  id="sbmit" class="btn btn-lg btn-primary btn-block">Submit</button>
                           	</div>
                           					               				
                           					               				
                      
	               				
											
								        </div>
								        <!-- /.row -->

								
							
							
							</form:form>	
							
	    			</div>		
	  		</div>			
						
			</div>
        </div>
        <!-- /.row -->

        

      

  
    </body>
    
    </html>