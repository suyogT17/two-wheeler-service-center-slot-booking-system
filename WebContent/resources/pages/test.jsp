<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="getallparam.html"  method="post">

	<input type="checkbox"   id="chk" name="chk"  value="1"/>1
		<input type="checkbox"   id="chk" name="chk"  value="2"/>2
			<input type="checkbox"   id="chk" name="chk"  value="3"/>3
			<input type="checkbox"   id="chk" name="chk"  value="4"/>4
					<input type="checkbox"   id="chk" name="chk"  value="5"/>5
						<input type="checkbox" id="chk" name="chk"  value="6"/>6
				 <button type="submit" value="submit">Submit</button>		
</form>

</body>
</html>




