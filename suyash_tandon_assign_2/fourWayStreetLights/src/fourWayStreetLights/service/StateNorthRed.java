package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/*
 * This class is for the state where the North traffic light 
 * is Red. Here no cars pass as the light is red.
 * From here the control goes to the class where North light 
 * is green or West is green depending on the conditions.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateNorthRed implements StreetLightsStateI {
	
	StreetLightsContext streetLightsContext;
	public StateNorthRed(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext=streetLightsContext;
	}

	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at north side turned Red.");
		if(streetLightsContext.carNorth==0)
		{
			streetLightsContext.setState(streetLightsContext.getStateWestGreen());
		}
		else
		{
			streetLightsContext.setState(streetLightsContext.getStateNorthGreen());	
		}
		
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at east side already green.");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carNorth++;
		Results.storeNewResult("Car added to Northside");
		Results.storeNewResult("Total number of cars at Northside is " + streetLightsContext.carNorth);
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
