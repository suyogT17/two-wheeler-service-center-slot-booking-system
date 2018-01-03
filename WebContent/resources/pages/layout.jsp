<%@ taglib uri ="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head> 
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
    <link href="../dist/css/two-wheeler.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>  

</head>  
<body>  
        <tiles:insertAttribute name="header" />
        
         <!-- Page Content -->
         <div class="content">
          <tiles:insertAttribute name="body"/>
          </div>
        	<div class="inc"></div>
          
          <div class="footer">
           <tiles:insertAttribute name="footer" />
 		 </div>
</body> 
<style type="text/css">
.navbar-default {
    background-color: #333;
    border: none;
}

.top-logo {
    margin: 15px;
    margin-bottom: 0;
}

navbar-top-links li:last-child {
    margin-right: 15px;
}

.navbar-top-links li a {
    padding: 15px;
    min-height: 50px;
}

.navbar-top-links .dropdown-toggle i {
    color: #fff;
}

.sidebar ul li a.active {
    background-color: #444;
}
.sidebar ul li a.dash {
    padding-left: 15px;
    padding-top: 15px;
}

.footer{
position: absolute;
width:100%;
height:50px;
}

</style>
 
 <script>
$(document).ready(function(){
	
var docheight=$(window).height();
var footerheight=$(".footer").height();
var contenth=$(".content").height();
var full=contenth + footerheight;
console.log("ft"+contenth);
console.log("ftheight"+footerheight);
console.log("full"+full);
console.log("win"+docheight);
console.log("foot"+(contenth+(docheight-contenth-footerheight)));
if(full < docheight)
	{
	$(".footer").css("top",(contenth+(docheight-contenth-footerheight))+"px");
	}
});
</script>
 
</html>  