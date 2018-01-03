<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Service Center</title>


    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>
    
    
      <script 
    src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBV6yW7YAbkHcTHcWXn56RtidqQUplFv5Q">
    </script>
    
     <style>
    .err{
    color:red;
    }
    </style>
    <script>
    
    		$(document).ready(function(){
   			 $geocoder = new google.maps.Geocoder();//google maps
   			var regex=/^[0-9]/;
   	    	var regex2=/^[A-Z a-z]/;
   	    	var regex3=/\S+@\S+\.\S+/; 
    			$("#form2").hide();
    			$("#form3").hide();
    			$("#form1left").attr("disabled",true);
    			$("#longitude").attr("readonly",true);
    			$("#latitude").attr("readonly",true);
    			
    			 $('#pin').blur(function(){
  	               
 	                $address = $('#pin').val();
 	                var pin=$("#pin").val();
     				if(pin.length!=6 | !regex.test(pin))
     					{
     					$("#errpin").text("Enter pin")
     					return false;
     					}
 	                
 	                $geocoder.geocode( { 'address': $address}, function(results, status) {

 	                  if (status == google.maps.GeocoderStatus.OK) {

 	                    $latitude = results[0].geometry.location.lat();
 	                    $longitude = results[0].geometry.location.lng();
 	                    console.log($longitude);
 	                    $('#longitude').val($longitude);
 	                    $('#latitude').val($latitude);
 	                      
 	                  } 
 	                
 	                }
 	                
 	                )
 	            
 	            
 	            
 	            });
    			
    			
    			$("#form1right").click(function(){
    				
    				var bname=$("#branchname").val();
    				var mname=$("#managername").val();
    				var contact=$("#contact").val();
    				var email=$("#email").val();
    				var err=0;
    				
    				if(bname.length==0 | !regex2.test(bname))
    				{
    					$("#errbranchname").text("Enter Branch name");
						err++;    				
    				}
    				
    				if(mname.length==0 | !regex2.test(mname))
    				{
    					$("#errmanagername").text("Enter Manager name");
    					err++;
    				}
    				
    				
    				if(contact.length!=10 |  !regex.test(contact))
    				{
    					$("#errcontact").text("Enter Conatct number");
    					err++;
    				}
    				
    			
    				if(email.length==0 | !regex3.test(email))
    				{
    					$("#erremail").text("Enter Email");
    					err++;
    				}
    				
    				if(err!=0)
    					{
    					return false;
    					}
    				
    				$("#form1").hide(1000);
    				$("#form2").show(1500);
    				$("#progressid").css("width","33.33%");
    				
    				
    				
    			});
    			
    			$("#from2left").click(function(){
    				
			    		
    				$("#form2").hide(1000);
    				$("#form1").show(1500);
    				$("#progressid").css("width","33.33%")
			    	
			    	});
    			
    			$("#form2right").click(function(){
    				var add1=$("#add1").val();
    				var area=$("#area").val();
    				var city=$("#city").val();
    				
    				var add2=$("#add2").val();
    				var landmark=$("#landmark").val();
    				var state=$("#state").val();
    				var country =$("#country").val();
    				var err=0;
    				
    				
    				
    				if(add1.length==0 | !regex2.test(add1))
    					{
    					$("#erradd1").text("Enter Address");
    					err++;
    					}
    				
    				if(area.length==0 | !regex2.test(area))
					{
					$("#errarea").text("Enter Area");
					err++;
					}
    				
    				if(city.length==0 | !regex2.test(city))
					{
					$("#errcity").text("Enter City");
					err++;
					}
    				
    				
    				
    				if(add2.length==0 | !regex2.test(add2))
					{
					$("#erradd2").text("Enter Address");
					err++;
					}
    				
    				if(landmark.length==0 | !regex2.test(landmark))
					{
					$("#errlandmark").text("Enter Landmark");
					err++;
					}
    				
    				if(state.length==0 | !regex2.test(state))
					{
					$("#errstate").text("Enter State");
					err++;
					}
    				
    				if(country.length==0 | !regex2.test(country))
					{
					$("#errcountry").text("Enter Country");
					err++;
					}
    				
			    	if(err!=0)
			    		{
			    		return false;
			    		}
	    			
	    			//function to generate longitude and latitiude
	    	               
	    	            
	    	            
	    	            
	    	         
    				$("#form2").hide(1000);
    				$("#form3").show(1500);
    				$("#progressid").css("width","66.66%"); 	

    			});
    			
    			$("#form3left").click(function(){
    				$("#form3").hide(1000);
    				$("#form2").show(1500);
    				$("#progressid").css("width","66.66%");
    				
    				
    			});
    			
    			
    		 $("#sbmit").click(function(){
    				  $("#progressid").css("width","100%");
				
    			}); 
    			
    			
    			$("#branchname").focus(function(){
    				$("#errbranchname").text("");
    			});
    			
    			$("#managername").focus(function(){
    				$("#errmanagername").text("");
    			});
				
    			$("#contact").focus(function(){
    				$("#errcontact").text("");
    			});
				
				$("#email").focus(function(){
    				$("#erremail").text("");
    			});
				
				$("#add1").focus(function(){
    				$("#erradd1").text("");
    			});
				
				$("#area").focus(function(){
    				$("#errarea").text("");
    			});
				
				$("#city").focus(function(){
    				$("#errcity").text("");
    			});
				
				$("#pin").focus(function(){
    				$("#errpin").text("");
    			});
				
				$("#add2").focus(function(){
    				$("#erradd2").text("");
    			});
				
				$("#landmark").focus(function(){
    				$("#errlandmark").text("");
    			});
				
				$("#state").focus(function(){
    				$("#errstate").text("");
    			});
				
				$("#country").focus(function(){
    				$("#errcountry").text("");
    			});
				
				$("#longitude").focus(function(){
    				$("#errlongitude").text("");
    			});
				
				$("#latitude").focus(function(){
    				$("#errlatitude").text("");
    			});
				
				
    		});
    		
    </script>
   
    

</head>
<body class="bg-1">
<!-- Page Content -->
	<div class="row" id="main-row1">
	<div class="col-lg-1"></div>
            <div class="col-lg-10">
                <div class="page-header text-center form-head ">
            
                    <h1>Add Service Center</h1>
                    
        </div><!--Page Header-->
              	        
		</div>
        </div>
        <!-- /.row -->
        <!-- Content Row -->
        <div class="row" id="main-row2">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">			
				<div class="panel panel-default panel-shadow-form text-color-black">
                    <div class="panel-heading"><p class="lead">Enter Service Center Details</p></div>
	  					<div class="panel-body">
	  						<br>
	    					<div class="progress">
  								<div class="progress-bar success" id="progressid"></div>
							</div>
							<br>
							<form:form id="addservicecenterform" action="addservicecenter1.html" modelAttribute="addservicecenter" method="post">
								<div class="row" id="form1">
									<div class="col-lg-2">
									</div>
									
									<div class="col-lg-4">
										<div class="form-group">
        								   <form:input path="branchName" type="text" class="form-control" id="branchname" placeholder="Enter Branch Name"/>
        								   <label class="err" id="errbranchname"></label>	   
      									</div>
      									 
      									 <div class="form-group">
        								   <form:input path="managerName" type="text" class="form-control" id="managername" placeholder="Enter Manager Name"/>
        								   <label class="err" id="errmanagername"></label>
      									 </div>
      									 
    							 	</div>
      								<div class="col-lg-4">	 
      									 <div class="form-group">
        								   <form:input path="contactNo" type="text" class="form-control" id="contact" placeholder="Enter Contact Number"/>
      									   <label class="err" id="errcontact"></label>	
      									 </div>
      							         
      							         <div class="form-group">
        								   <form:input path="emailId" type="text" class="form-control" id="email" placeholder="Enter Email"/>
        								   <label class="err" id="erremail"></label>
      									 </div>
									</div>
									<div class="col-lg-5"></div>
									<div class="col-lg-2">
										<div class="btn-group btn-group-justified">
											  <a class="btn btn-default" id="from1left"><i class="fa  fa-arrow-circle-left"></i></a>
											  <a class="btn btn-default" id="form1right"><i class="fa  fa-arrow-circle-right"></i></a>
										
										</div>
									</div>

								</div>
								
								<div class="row" id="form2">
									<div class="col-lg-2">
									</div>
									
									<div class="col-lg-4">
										<div class="form-group">
        								   <form:input path="addressLine1" type="text" class="form-control" id="add1" placeholder="Address Line 1"/>
        								   <label class="err" id="erradd1"></label>
      									 </div>
      									 
      									 <div class="form-group">
        								   <form:input path="street" type="text" class="form-control" id="area" placeholder="Area"/>
        								   <label class="err" id="errarea"></label>
      									 </div>
      									 
      									 <div class="form-group">
        								   <form:input path="city" type="text" class="form-control" id="city" placeholder="City"/>
        								   <label class="err" id="errcity"></label>
      									 </div>
      									 
      									 
      									 
    							 	</div>
      								<div class="col-lg-4">	 
      									 <div class="form-group">
        								   <form:input path="addressLine2" type="text" class="form-control" id="add2" placeholder="Address Line 2"/>
        								   <label class="err" id="erradd2"></label>
      									 </div>
      							         
      							         <div class="form-group">
        								   <form:input path="landmark" type="text" class="form-control" id="landmark" placeholder="Landmark"/>
        								   <label class="err" id="errlandmark"></label>
      									 </div>
      									 
      									 <div class="form-group">
        								   <form:input path="state" type="text" class="form-control" id="state" placeholder="state"/>
        								   <label class="err" id="errstate"></label>
      									 </div>
      							         
      							         <div class="form-group">
        								   <form:input path="country" type="text" class="form-control" id="country" placeholder="Country"/>
        								   <label class="err" id="errcountry"></label>
      									 </div>
      									 
									</div>
									
									
									<div class="col-lg-5"></div>
									<div class="col-lg-2">
										<div class="btn-group btn-group-justified">
											  <a class="btn btn-default" id="from2left"><i class="fa  fa-arrow-circle-left"></i></a>
											  <a class="btn btn-default" id="form2right"><i class="fa  fa-arrow-circle-right"></i></a>
										
										</div>
									</div>
									
									 
							</div>
							
							<div class="row" id="form3">
									<div class="col-lg-3">
									</div>
										
								        <div class="col-lg-6">
											
											<div class="form-group">
			       								   <form:input path="pinno" type="text" class="form-control" id="pin" placeholder="Pincode"/>
			       								   <label class="err" id="errpin"></label>
      									 	</div>
											
											
										   <div class="form-group">
		
		                                
		                                <form:input type="text" id="longitude" path="longitude" class="form-control" name="longitude"/>
		
		                            	</div>
	
			                            <div class="form-group">
			
			                                
			                                <form:input type="text" id="latitude" path="latitude"   class="form-control" name="latitude"/>
			                                
			
			                            </div>
      									
      									<div class="btn-group btn-group-justified">
											  <div class="col-lg-2">
											  <a class="btn btn-default" id="from3left"><i class="fa  fa-arrow-circle-left"></i></a>
											  </div>
											 <div class="col-lg-4">									  
											  <form:button type="submit" id="sbmit" class="btn btn-primary" value="submit">Submit</form:button>
											  </div>
										</div>
      							  											
										
      					
      									
      					
								        </div>
								        <!-- /.row -->
							  </div>
							</form:form>	
								</div>
								</div>
	    					  </div>
	  					</div>
	
      
    

        

       
  
    </body>
    
    </html>
