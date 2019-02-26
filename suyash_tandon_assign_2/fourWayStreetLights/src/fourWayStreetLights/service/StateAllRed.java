package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;
/**
 * This class is made for the initial state when all 
 * 		the lights in all directions are
 *   red. From here the state changes to NorthGreen.
 * @author Suyash
 *
 */

public class StateAllRed implements StreetLightsStateI {

	StreetLightsContext streetLightsContext;
	
	public StateAllRed(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext= streetLightsContext;
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("All Lights Turned Red");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}
}