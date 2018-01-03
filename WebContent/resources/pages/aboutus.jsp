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

    <title>About Us</title>

 
	  <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="${pageContext.request.contextPath}/resources/dist/css/two-wheeler.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>
    
   

</head>

<body id="about-us-page">

       

    <div class="container-fluid custom-padding">

    
       <div id="about-main-img">
           
           <img src="${pageContext.request.contextPath}/resources/assets/images/about-us.jpg" width="100%" height="500px" id="about-img"> 
           
           <h1 class="form-head" id="about-head">About Us</h1>
                   
           
       </div>   
   
   
   

     

        <div class="row custom-r-height-small">
            
            <div class="col-md-4  text-center">
                
                <div class="num-group">
                <h2 class="num-head"><span class="count">25</span></h2>
                <h5 class="num-caption">Service Centers</h5>
                </div>
                
            </div>
            
            <div class="col-md-4  text-center">
                
                  
                <div class="num-group">
                <h2 class="num-head"><span class="count">1000</span>+</h2>
                <h5 class="num-caption">Happy Customers</h5>
                </div>
            </div>
            
            <div class="col-md-4 text-center" >
                
                <div class="num-group">
                    <h2 class="num-head"><span class="count">500</span></h2>
                    <h5 class="num-caption">Strong Workforce</h5>
                </div>
            </div>
            
   
            
            
            
        </div>
                 <div class="about-content bg-1">
                
                <h1 class="text-center form-head">Our Story</h1>
                
                <p>Our vehicle problems not only interfere with your time and peace of mind, but often dig a hole in your pocket as well. As a solution to this problem, we started this site with the vision of empowering people with an affordable, convenient, and transparent approach to auto repair and maintenance. No negotiating, no trips to the service center, no surprises.</p>
                
                  <p>
                      
                      We believe that seamless, automatic service trumps last minute, on-demand requests and with our less than 30-seconds booking process, secure payment, and a 100% money-back guarantee, We aim to be the easiest and most convenient way to provide your vehicle the service it deserves.
                      
                  </p>      
                
                
                
            </div>
     </div>

       
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!--Validate Plugin-->
        <script src="../dist/js/jquery.validate.js">  </script>
        <script src="../dist/js/additional-methods.js"></script>
    <!--Form Validation-->
    <script>
    $(document).ready(function(){
    $('.count').each(function () {
    $(this).prop('Counter',0).animate({
        Counter: $(this).text()
    }, {
        duration: 1000,
        easing: 'swing',
        step: function (now) {
            console.log(now);
            $(this).text(Math.ceil(now));
        }
    });
});});
        
    
    
    
    </script>

</body>

</html>