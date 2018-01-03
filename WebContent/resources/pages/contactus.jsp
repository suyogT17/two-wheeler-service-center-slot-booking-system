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

    <title>Contact Us</title>

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
</head>

<body>
    
    <div class="container-fluid" id="contact-container">
        
        
            
                <div class="page-header text-center">
            
                    <h1>Contact Us</h1>
                    <p class="lead">Feel free to contact us!</p>

                </div><!--Page Header-->
        
                <div class="row">
        
                    <div class="col-md-4 text-center">
                        
                        <div class="panel panel-primary">
                          <div class="panel-heading"><i class="fa fa-phone" aria-hidden="true"></i> Phone Number</div>
                          <div class="panel-body">+910909090910</div>
                        </div>
                    </div>
                        
                     <div class="col-md-4 text-center">
                        
                        <div class="panel panel-primary">
                          <div class="panel-heading"><i class="fa fa-envelope" aria-hidden="true"></i> E-Mail ID</div>
                          <div class="panel-body">twscwi@yourdomain.com</div>
                        </div>
                    </div>
                    
                     <div class="col-md-4 text-center">
                        
                        <div class="panel panel-primary">
                          <div class="panel-heading"><i class="fa fa-map-marker" aria-hidden="true"></i> Address</div>
                          <div class="panel-body">Mumbai,India</div>
                        </div>
                    </div>
                        
                    
        
        
        
                </div>
                <div class="row">
        
                    <div class="col-md-6">
                        
                    <form id="contact-form" action="contactus.html" method="post">

                        
                            <div class="form-group">

                                <label for="formName">Your Name<span class="red-star"><sup> *</sup></span></label>
                                <input type="text" id="formName" class="form-control" name="username">

                            </div>

                            <div class="form-group">

                                <label for="formEmail">Email<span class="red-star"><sup> *</sup></span></label>
                                <input type="email" id="formEmail" class="form-control" name="email">
                                <small class="form-text text-muted">We'll never share your email with anyone else.</small>


                            </div>

                            <div class="form-group">
                                <label for="formPhone">Mobile Number<span class="red-star"><sup> *</sup></span></label>
                                <input type="text" id="formPhone" class="form-control" name="formPhone">

                            </div>

                              <div class="form-group">

                                <label for="formComments">Comments</label>
                                  <textarea id="formComments" rows="5" class="form-control" name="msg"></textarea>

                            </div>
                        
                            <button type="submit" class="btn btn-primary">Submit</button>
                        
                    </form>

                </div><!--end of col-md-6-->
                <div class="col-md-4">

                    <iframe width="650" height="450" frameborder="0" style="border:0"
    src="https://www.google.com/maps/embed/v1/view?zoom=10&center=19.0760,72.8777&key=AIzaSyCrI7FzwjA-ycI1aE2FF61bHkCj8APpFqc" allowfullscreen></iframe>


            
            
            
            
            </div><!--end of col-md-4-->
        
        </div><!--End of row-->
    
    </div><!--.container-->
	

        

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

     <!--Validate Plugin-->
        <script src="${pageContext.request.contextPath}/resources/dist/js/jquery.validate.js">  </script>
        <script src="${pageContext.request.contextPath}/resources/dist/js/additional-methods.js"></script>
    <!--Form Validation-->
    <script src="${pageContext.request.contextPath}/resources/dist/js/contact-us.js"></script>
    

</body>

</html>
