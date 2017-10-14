package data;

public interface DisasterMap {
	public void addSurvivor(Survivor newSurvivor);
	public Quadrant getQuadrant();
	public double[][] getGrid();
}