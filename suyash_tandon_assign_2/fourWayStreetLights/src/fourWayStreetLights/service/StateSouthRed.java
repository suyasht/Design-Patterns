package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;
/*
 * This class is for the state where the South traffic light 
 * is Red. Here no cars pass as the light is red.
 * From here the control goes to the class where North light 
 * is green.
 * 
 * It implements the StreetLightsStateI interface.
 */

public class StateSouthRed implements StreetLightsStateI {

	StreetLightsContext streetLightsContext;
	
	public StateSouthRed(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext= streetLightsContext;
	}
	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at South side turned Red.");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at South side already green.");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}
	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carSouth++;
		Results.storeNewResult("Car added to Southside");
		Results.storeNewResult("Total number of cars at Southside is " + streetLightsContext.carSouth);
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}
	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
