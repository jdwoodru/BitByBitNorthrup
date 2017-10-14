package data;

import java.util.ArrayList;
import java.util.List;

public class Situation{
    List<Boolean> incidentList;
    public Situation(int numberOfIncidents){
        incidentList = new ArrayList<Boolean>();
        for (int i = 0; i < numberOfIncidents; i++) {
        	incidentList.add(false);
        }
    }
    
    public void addIncident(int incidentId) {
    	incidentList.set(incidentId, true);
    }
    
    public void removeIncident(int incidentId) {
    	incidentList.set(incidentId, false);
    }
    
    public boolean getIncidentStatus(int IncidentId){
        return incidentList.get(IncidentId);
    }
    
    public int getRiskLevel() {
    	int total = 0;
    	for (int i = 0; i < incidentList.size(); i++) {
    		if (incidentList.get(i).equals(true)) {
    			total+=i;
    		}
    	}
		return total;
    }
    
    public int[] getNeeds(){
        int[] needList = new int[incidentList.size()];
        for (int i = 0; i < incidentList.size(); i++){
            needList[i] = incidentList.get(i) ? 1 : 0;
        }
        
        return needList;
    }
}