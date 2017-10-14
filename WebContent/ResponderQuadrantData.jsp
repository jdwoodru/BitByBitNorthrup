<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="data.GridBasedDisasterMap"%>
<%@ page import="data.Quadrant"%>
<%@ page import="data.Situation"%>
<%@ page import="data.Survivor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%	String longitude = request.getParameter("longitude");
     	String latitude = request.getParameter("latitude");
     	Double lonDouble = Double.parseDouble(longitude);
     	Double latDouble = Double.parseDouble(latitude);
     	
     	int zombieTotal = 0;
     	int waterTotal = 0;
     	int foodTotal = 0;
     	int rescueTotal = 0;
     	int medicineTotal = 0;
     
     	GridBasedDisasterMap disasterMap = (GridBasedDisasterMap) session.getAttribute("disasterMap");
     	Quadrant quad = disasterMap.getQuadrant(lonDouble, latDouble);
     	
     	int survivorCount = quad.getSurvivorCount();
     	for(int i = 0; i < survivorCount; i++) {
     		Survivor survivor = quad.getSurvivor(i);
     		String name = survivor.getName();
     		double longCoord = survivor.getLongCoordinate();
     		double latCoord = survivor.getLatCoordinate();
     		int[] needs = survivor.getNeeds();
     		%>
     		<label>Name: <%=name %></label><br/>
     		<label>Longitude: <%=longCoord %></label><br/>
     		<label>Latitude: <%=latCoord %></label><br/>
     		<label>Zombie Attacks: <%= needs[0] %></label><br/>
     		<% zombieTotal += needs[0]; %>
     		<label>Water Requests: <%= needs[1] %></label><br/>
     		<% waterTotal += needs[1]; %>
     		<label>Food Requests: <%= needs[2] %></label><br/>
     		<% foodTotal += needs[2]; %>
     		<label>Rescue Requests: <%= needs[3] %></label><br/>
     		<% rescueTotal += needs[3]; %>
     		<label>Medicine Requests: <%= needs[4] %></label><br/>
     		<% medicineTotal += needs[4]; %>
     		<br/>
     	<%	
     	}
     %>    
     <label>Total zombie attacks: <%= zombieTotal%></label><br/>
     <label>Total water requests: <%= waterTotal%></label><br/>
     <label>Total food requests: <%= foodTotal%></label><br/>
     <label>Total rescue requests: <%= rescueTotal%></label><br/>
     <label>Total medicine requests: <%= medicineTotal%></label><br/>
     <br/>
     
     <form action="ResponderMap.jsp" method="GET">
     	<input type="submit" value="Back"></input>
     </form>
</body>
</html>