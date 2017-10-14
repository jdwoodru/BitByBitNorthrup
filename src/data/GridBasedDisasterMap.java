package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GridBasedDisasterMap implements DisasterMap {
	
	private static final double longCoordMax = -114;
	private static final double longCoordMin = -124;
	private static final double latCoordMax = 42;
	private static final double latCoordMin = 32;
	private static final int gridSize = 10;
	
	private double minPriority = Double.MAX_VALUE;
	private double maxPriority = 0.0; 
	private double priorityMultiplier = 1.0;
	
	private List<List<Quadrant>> disasterMap;
	
	public double GetMinPriority() {
		return minPriority;
	}
	public double GetMaxPriority() {
		return maxPriority;
	}
	public double GetPriorityMultiplier() {
		return priorityMultiplier;
	}
	
    public GridBasedDisasterMap() {
    	disasterMap = new ArrayList<List<Quadrant>>();
    	for (int i = 0; i < gridSize; i++) {
    		disasterMap.add(new ArrayList<Quadrant>());
    		for (int j = 0; j < gridSize; j++) {
    			disasterMap.get(i).add(new Quadrant());
    		}
    	}
    }
	
	public double[][] getGrid() {
		double[][] gridToReturn = new double[disasterMap.size()][disasterMap.size()];
		
		for (int i = 0; i < disasterMap.size(); i++) {
			for (int j = 0; j < disasterMap.size(); j++) {
				gridToReturn[i][j] = disasterMap.get(i).get(j).getRiskLevel();
				if(gridToReturn[i][j] > maxPriority) {
					maxPriority = gridToReturn[i][j];
				}
				if(gridToReturn[i][j] < minPriority) {
					minPriority = gridToReturn[i][j];
				}
			}
		}
		priorityMultiplier = 255.0 / (maxPriority - minPriority);
		
		return gridToReturn;
	}
    
    public Quadrant getQuadrant() {
    	return new Quadrant();
    }
    
    public void addSurvivor(Survivor newSurvivor) {
    	int xCoordToAddSurvivor = (int) Math.floor(
    			newSurvivor.getLongCoordinate() - longCoordMin);
    	int yCoordToAddSurvivor = (int) Math.floor(
    			newSurvivor.getLatCoordinate() - latCoordMin);
    	disasterMap.get(yCoordToAddSurvivor).get(
    			xCoordToAddSurvivor).addSurvivor(newSurvivor);
    }
    
    public void addToDisasterMapFromFile(String filename){
    	try {
	    	String line;
	    	BufferedReader in = new BufferedReader(new FileReader(filename));
	    	while ((line = in.readLine()) != null) {
		    	String[] wordArray = line.split(",");
		    	//do something with the outcome.
		    	String name = wordArray[0];
	            String longitude = wordArray[1];
	            String latitude = wordArray[2];
	            double lonDouble = Double.parseDouble(longitude);
	            double latDouble = Double.parseDouble(latitude);
	            
	            Survivor s = new Survivor(name, lonDouble, latDouble);
	            
	            for (int i = 0; i < 5; i++){
	            	int incident = Integer.parseInt(wordArray[3 + i]);
	            	if(incident == 1) {
	            		s.addIncident(i);
	            	}
	            }
	            
	            addSurvivor(s);
	    	}
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public Quadrant getQuadrant(double longCoord, double latCoord) {
        int xCoord = (int) Math.floor(
        		longCoord - longCoordMin);
        int yCoord = (int) Math.floor(
        		latCoord - latCoordMin);
        
        return disasterMap.get(yCoord).get(xCoord);
    }
}
