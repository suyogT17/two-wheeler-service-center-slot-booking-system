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
           <!-- Bootstrap Core CSS -->
            <!-- jQuery -->

    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>

 <!-- jQuery -->
 <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>

 <!-- Bootstrap Core JavaScript -->
 <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>



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
                                         All Transactions 
                                  </div>
                                  <div class="panel-body">
                                         <div class="well">
                                                <div class="dataTable_wrapper">
                                                       <table class="table table-striped table-bordered table-hover" id="tabledata">
                                                              <thead>
                                                                                         <tr>
                                                                                                
																								<th style="background-color: #0FA0A7;">ID</th>
																								<th style="background-color: #0FA0A7;">Job Tickit No.</th>
																							    <th style="background-color: #0FA0A7;">Cost</th>
																								<th style="background-color: #0FA0A7;">Branch Name</th>
																								<th style="background-color: #0FA0A7;">Vehicle Name</th>
																								<!-- <th>effectiveDate</th> -->
																									<!-- <th>endDate</th> -->
																								
																								
                                                                                         </tr>
                                                                                  </thead>
                                                                                  <c:forEach items="${slotList}" var="v">	
                                                                                  	<tr>
                                                                                                
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.bslotId} </td>
																							     <td style="background-color: #0FA0A10; color:#3A2925;">${v.bOTP} </td>
																							    <td style="background-color: #0FA0A10; color:#3A2925;">${v.bcost} </td>
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.branch.branchName }</td>
																								<td style="background-color: #0FA0A10; color:#3A2925;">${v.vehicle.vehicleName }</td>
																								<!-- <th>effectiveDate</th> -->
																									<!-- <th>endDate</th> -->
																								
																								
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
                <div id="myModal" class="modal fade" role="dialog">
                                   <div class="modal-dialog">
                                                      
                                                           <!-- Modal content-->
                                                           <div class="modal-content">
	                                                             <div class="modal-header">
	                                                               <button type="button" class="close" data-dismiss="modal">&times;</button>
	                                                               <h4 class="modal-title" style="color: #3A2925;" >Details</h4>
	                                                             </div>
	                                                             <div class="form-group text-center">
											                                    <i style="color : #3A2925; size: 80px ;" class="fa fa-user fa-5x "></i>
											                      </div>			                                                             
											                             
	                                                             <div class="modal-body" id="body" style="color: #3A2925;">
			                                                                
	                                                             </div>
	                                                            
	                                                             <div class="modal-footer">
	                                                               <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                                                             </div>
                                                           </div>
                              	 </div>
                      </div>
 					<!-- /.mymodal -->
                
                </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
 <script type="text/javascript">
 
 $(document).ready(function(){
	 
	 
	 $(".table-striped").on("click",'tr', function() {
         
  	   var userId= $(this).children('td:first').text();
  	   var ticket=$(this).children('td:first').next().text();
  	  console.log("uid:"+userId);
  	  console.log("uname"+ticket);
  	  $.ajax({
  		 type:"post",  		  
  		 url: "details.html",
  				 
  		data:{
			ticket:ticket
		},
		datatype:"json",
		success:function(data)
			{
				if(data!=null)
					{
					$("#body").text("");
					$("#body").append(data);

					console.log(data);
					jQuery.noConflict(); 
			         $('#myModal').modal('show');
			
					}
			}
  		 
  	  });
         //do all your operation populate the modal and open the modal now. DOnt need to use show event of modal again
        // $("#myModal").modal('show');
       



     }); 
	 
	 
 } );
 
 </script> 
  
   
</body>
</html>