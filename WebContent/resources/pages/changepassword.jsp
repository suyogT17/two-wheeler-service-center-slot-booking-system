<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
    
<script type="text/javascript">
$(document).ready(function(){
	$("#message").hide();
	$("#verifybtn").hide();
	//$("#verificationbtn").hide();
	$("#Code").hide();
	$("#sbmit").attr("disabled",true);
	$("#err").hide();
	var passregex=/^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@#$%]).{8,}$/;

	
	$("#password").focus(function(){
		$("#err").hide();
		return true;
	})
	
	$("#npassword").focus(function(){
		$("#err").hide();
		return true;
	})
	$("#verificationbtn").click(function(){
		var pass=$("#npassword").val();
		
		
		
		
		if( $("#password").val() != $("#npassword").val())
			{
			$("#err").show();
			}
		$.ajax({
			type:"post",
			url:"generatecode.do",
			data:{
				password:pass
			},
			datatype:"json",
			success:function(data)
    			{
    				if(data=="ok")
    					{
	    					$("#verificationbtn").hide();
	    					$("#verifybtn").show();
	    					$("#Code").show();

    					}
    			}
		});
		
		$("#verifybtn").click(function(){
			
			var code=$("#Code").val();
			var pass=$("#npassword").val();
			$.ajax({
				type:"post",
				url:"verifycode.do",
				data:{
					code:code,
					password:pass
				},
				
				datatype:"json",
				success:function(data)
				{
					if(data=="success")
						{
							$("#sbmit").attr("disabled",false);
						}
					else{
						$("#message").show();
					}
				}
				
			});
			
		});
		
	});
});
</script>

<style>
.err{
color : red;
}
</style>


</head>

<body class="bg-1" class="customlogin">

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default panel-shadow-form">
                    <div class="panel-heading">
                        <h3 class="panel-title">Change Password</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="updatepassword.html" >
                            <fieldset>
                            
                            <div class="form-group text-center">
                                    <i style="color : #3A2925; size: 80px ;" class="fa fa-user fa-5x "></i>
                                </div>
                                <div class="form-group">
                                	<label style="color : #3A2925; font-size: 15px ;">Enter new Password:</label>
                                    <input class="form-control" placeholder="new password" id="password" type="password">
                                	<label  id="errpassword"  style="color:red;" class="err"></label>
                                </div>
                                <div class="form-group">
                                    <label style="color : #3A2925; font-size: 15px ;">Re-Enter Password:</label>
                                    <input class="form-control" placeholder="Re-enter Password" id="npassword" type="password" value="">
                                	<label  id="errnpassword" class="err"></label>
                                </div>
                             	 <div class="alert alert-danger" id ="err">
                                 Passwords did not Matching!!!
                            </div>
                                <div class="alert alert-danger" id ="message">
                                 Invalid verification code!!!
                            </div>
                            <div class="form-group">
                                	
                                    <input class="form-control" id="Code" placeholder="verification Code" name="vcode" type="text">
                                </div>
                                
                            	<div class="form-group">
	                                      <button type="button" id="verificationbtn" class="btn btn-outline btn-success btn-lg btn-block">Get Verification code</button>
									</div>
									
									<div class="form-group">
	                                      <button type="button" id="verifybtn" class="btn btn-outline btn-success btn-lg btn-block">Verify</button>
									</div>
                            	
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="dashboard.html">
                                <button type="submit"  id="sbmit" class="btn btn-lg btn-success btn-block">change Password</button>
                                </a>
                            </fieldset>
                        </form>
                    </div>
                    <div class="panel-footer">
                    	
                    		
		                     <a href="userregistration.html">
		                     
		                     <i class="fa  fa-sign-in fa-fw"></i>Sign up
		                   	 </a>
		                   
		                    
		                    <span class="pull-right">
		                    <a href="forgetpassword.html">
		                     <i class="fa  fa-unlock fa-fw p"></i>
		                     
		                     Forgot Password?
		                     </a>
		                    </span>
		                    
                   		
                    </div>
                </div>
            </div>
        </div>
    </div>

    

</body>

</html>