<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<title>Insert title here</title>
<style>
	.checkbox{
	  padding: 2%;
	  background: #d3d3d3;
	  width: 50%;
	  font-family: roboto condensed;
	  border: 2px;
	  border-radius: 15px;
	}
	
</style>
</head>
   <body>
      <div class="container">
        <form action="Servlet" method="POST">
        <div class="checkbox">
          <label> Name: </label>
          <label><input type="text" id="name" name="name" value=""></label><br/>
          <label> Latitude: </label>
          <input type="text" name="latitude" id="latitude" value=""><br/>
          <label> Longitude: </label>
          <input type="text" name="longitude" id="longitude" value=""><br/>
          <label><input type="checkbox" name="incident" value="zombieAttack">Zombie Attack</label><br/>
          <label><input type="checkbox" name="incident" value="water">Water</label><br/>
          <label><input type="checkbox" name="incident" value="food">Food</label><br/>
          <label><input type="checkbox" name="incident" value="rescue">Rescue</label><br/>
          <label><input type="checkbox" name="incident" value="medicine">Medicine</label><br/>
        <input type="submit" value="Submit">
        </div>
       </form>
      </div>  
	</body>
</html>