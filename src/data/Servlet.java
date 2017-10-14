package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	String name = request.getParameter("name");
    	String latitude = request.getParameter("latitude");
    	String longitude = request.getParameter("longitude");
    	
    	double latDouble = Double.parseDouble(latitude);
    	double lonDouble = Double.parseDouble(longitude);
    	
    	System.out.println(name);
    	System.out.println(latitude);
    	System.out.println(longitude);
    	
    	int zombieAttack = 0;
    	int water = 0;
    	int food = 0;
    	int rescue = 0;
    	int medicine = 0;
    	
    	String[] results = request.getParameterValues("incident");
    	for (int i = 0; i < results.length; i++) {
    	    String result = results[i];
    	    if(result.equals("zombieAttack"))
    	    	zombieAttack = 1;
    	    else if(result.equals("water"))
    	    	water = 1;
    	    else if(result.equals("food"))
    	    	food = 1;
    	    else if(result.equals("rescue"))
    	    	rescue = 1;
    	    else if(result.equals("medicine"))
    	    	medicine = 1;
    	    
    		System.out.println(results[i]); 
    	}
    	
    	String relativeWebPath = "/WEB-INF/survivorFile.txt";
    	String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
    	System.out.println(absoluteDiskPath);
    	
    	session.setAttribute("absoluteDiskPath", absoluteDiskPath);
    
    	try(FileWriter fw = new FileWriter(absoluteDiskPath, true);
    		    BufferedWriter bw = new BufferedWriter(fw);
    		    PrintWriter out = new PrintWriter(bw))
    		{
    			// Mora,-118.10122145176557,41.69410860858543,0,0,0,0,0,0
    		    StringBuilder sb = new StringBuilder();
    		    sb.append(name); sb.append(',');
    		    sb.append(lonDouble); sb.append(',');
    		    sb.append(latDouble); sb.append(',');
    		    sb.append(zombieAttack); sb.append(',');
    		    sb.append(water); sb.append(',');
    		    sb.append(food); sb.append(',');
    		    sb.append(rescue); sb.append(',');
    		    sb.append(medicine); sb.append('\n');
    		    out.println(sb.toString());
    		} catch (IOException e) {
    		    //exception handling left as an exercise for the reader
    		}
    	
    	
    	System.out.println("DONE");
    	
    	// String next = "/ResponderMap.jsp";
		// RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		// dispatch.forward(request, response);
	}
}
