package data;

public class Survivor {
	static final int NUMBER_OF_INCIDENT_TYPES = 5;
    String name;
    double longCoordinate;
    double latCoordinate;
    Situation situation;
    
    public Survivor(String name, double longCoordinate, double latCoordinate){
    	this.name = name;
        this.situation = new Situation(NUMBER_OF_INCIDENT_TYPES);
        this.longCoordinate = longCoordinate;
        this.latCoordinate = latCoordinate;
    }
    
    public String getName() {
    	return this.name;
    }
    
    
    public double getLongCoordinate(){
    	return longCoordinate;
    }
    
    public double getLatCoordinate() {
    	return latCoordinate;
    }
    
    public void addIncident(int incidentId) {
    	situation.addIncident(incidentId);
    }
    
    public void removeIncident(int incidentId) {
    	situation.removeIncident(incidentId);
    }
    
    public void setSituation(Situation situation) {
    	this.situation = situation;
    }
    
    public int getRiskLevel() {
    	return situation.getRiskLevel();
    }
    
    public int[] getNeeds() {
        return situation.getNeeds();
    }

//    public String getNeedsString(){
//        StringBuilder sb = new StringBuilder();
//    }
}
