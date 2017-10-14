<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="data.GridBasedDisasterMap"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	td {
		padding: 8px;
	}
	th {
		font-size: 20px;
	}
</style>
</head>
<body>
	<%
	String relativeWebPath = "/WEB-INF/survivorFile.txt";
    String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
    System.out.println(absoluteDiskPath);
    	
    GridBasedDisasterMap disasterMap = new GridBasedDisasterMap();
    disasterMap.addToDisasterMapFromFile(absoluteDiskPath);
    double[][] grid = disasterMap.getGrid();
   	%>
   	
	<center><table>
	<tr><center>Longitude</center></tr>
	<tr>
		<th></th>
		<% for(int j = 0; j < grid.length; j++) { 
			%>
			<th><%=-124 + j%></th>
			<%
		}
		%>
	</tr>
	<% for(int i = 0; i < grid.length; i++) { %>
	<tr>
		<th><%=32 + i%></th>
		<% for(int j = 0; j < grid.length; j++) { 
			double colorScale = (grid[i][j] - disasterMap.GetMinPriority()) * disasterMap.GetPriorityMultiplier();
			System.out.println(colorScale); 
		
			if(grid[i][j] == 0) {
				%>
				<td bgcolor="#FFFFFF"></td>
			<% }
			else if(colorScale < 42.5 && colorScale >= 0) {
				%>
				<td bgcolor="#DAF7A6"></td>
			<% }
			else if(colorScale < 85.0 && colorScale >= 42.5) {
				%>
				<td bgcolor="#F9E79F"></td>
			<% }
			else if(colorScale < 127.5 && colorScale >= 85.0) {
				%>
				<td bgcolor="#FF8F77"></td>
			<% }
			else if(colorScale < 170.0 && colorScale >= 127.5) {
				%>
				<td bgcolor="#FF5733"></td>
			<% }
			else if(colorScale < 212.5 && colorScale >= 170.0) {
				%>
				<td bgcolor="#C70039"></td>
			<% }
			else if(colorScale <= 255.0 && colorScale >= 212.5) {
				%>
				<td bgcolor="#581845"></td>
			<% } 
		  } %>
	</tr>
	<% } 
	
	session.setAttribute("disasterMap", disasterMap);
	%>
	</table>
	</center>
	<center><form action="ResponderQuadrantData.jsp" method="GET">
       <div class="form-group">
         <label id="lon-txt">Longitude:</label>
         <input type="text" name="longitude" value="">
         <label id="lat-txt">Latitude:</label>
         <input type="text" name="latitude" value="">
         <input type="submit" value="Submit">
       </div>
    </form></center>
</body>
</html>