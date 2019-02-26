	package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;
/*
 * This class is for the state where the West traffic light 
 * is Red. Here no cars pass as the light is red.
 * From here the control goes to the class where North light 
 * is green.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateWestRed implements StreetLightsStateI {
	
	StreetLightsContext streetLightsContext;
	public StateWestRed(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext=streetLightsContext;
	}

	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at West side turned Red.");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at West side already Green.");
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carWest++;
		Results.storeNewResult("Car added to Westside");
		Results.storeNewResult("Total number of cars at Westside is " + streetLightsContext.carWest);
		streetLightsContext.setState(streetLightsContext.getStateNorthGreen());
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
