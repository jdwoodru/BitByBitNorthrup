package data;

import java.util.ArrayList;
import java.util.List;

public class Quadrant {
	
    private List<Survivor> survivorList;
    
    
    public Quadrant() {
    	survivorList = new ArrayList<Survivor>();
    }
    
    public void addSurvivor(Survivor newSurvivor) {
    	survivorList.add(newSurvivor);
    }
    
    public int getRiskLevel() {
    	int total = 0;
    	for (int i = 0; i < survivorList.size(); i++) {
    		total+=survivorList.get(i).getRiskLevel();
    	}
    	return total;
    }
    public int getSurvivors() {
    	
    	return 0;
    }
    


    public int getSurvivorCount(){
        return survivorList.size();
    }

    public int[] getNeedsList() {
        int[] totalQuadrantNeeds = new int[5]; //D HFODHF KJDSFHLKDSGKJLSGLKJHDGSLFKJLDH
        
        for (int i = 0; i < 5; i++){
            totalQuadrantNeeds[i] = 0;
        }
        
        for (int i = 0; i < survivorList.size(); i++){
            int[] thisSurvivorsNeeds = survivorList.get(i).getNeeds();
            for (int j = 0; j < 5; j++){
                totalQuadrantNeeds[j]+=thisSurvivorsNeeds[j];
            }
        }
        
        return totalQuadrantNeeds;
    }

    public Survivor getSurvivor(int survivorId){
        return survivorList.get(survivorId);
    }
}