package fourWayStreetLights.service;

public interface StreetLightsStateI {
	
	
	/* 
	 * This method changes the appropriate light to green
	 * and changes the state afterward.
	 */
	public void changeToGreen();
	
	/*
	 *  This method changes the appropriate light to red
	 * and changes the state afterward.
	 */
	
	public void changeToRed();
	
	/* 
	 * This method adds a car to the specific traffic light.
	 */
	
	public void addCar();
	
	/* 
	 * This method is created for the initial state.
	 * here all the traffic lights are red.
	 * It is only implemented in one class(i.e StateAllRed).
	 */

	public void changeAllToRed();
	
}
