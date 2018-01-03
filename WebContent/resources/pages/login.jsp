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
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/two-wheeler.css" rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>
    
<script type="text/javascript">
$(document).ready(function(){
	$("#message").hide();
	var status = "<%= request.getAttribute("status")%>";
	console.log("status"+status)
	if(status=="Error")
		{
		$("#message").show();
		}
});
</script>

<style type="text/css">
.customlogin{
 background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
}
</style>


</head>

<body class="customlogin">

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="j_spring_security_check" >
                            <fieldset>
                            
                            <div class="form-group text-center">
                                    <i class="fa fa-user fa-5x "></i>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="j_username">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="j_password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <div class="alert alert-danger" id ="message">
                                Login failed!!. Invalid Username or Password.
                            </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <!-- <a href="dashboard.html"> -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                                
                            </fieldset>
                        </form>
                    </div>
                    <div class="panel-footer">
                    	
                    </div>
                </div>
            </div>
        </div>
    </div>

    	
    	
    

</body>

</html>