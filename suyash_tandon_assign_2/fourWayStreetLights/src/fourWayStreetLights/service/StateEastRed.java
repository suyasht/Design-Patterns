package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/*
 * This class is for the state where the East traffic light 
 * is Red. Here no cars pass as the light is red.
 * From here the control goes to the class where South light 
 * is green.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateEastRed implements StreetLightsStateI {

	StreetLightsContext streetLightsContext;
	public StateEastRed(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext=streetLightsContext;
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at east side already green.");
		streetLightsContext.setState(streetLightsContext.getStateEastGreen());
	}

	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Light at east side turned red.");
		streetLightsContext.setState(streetLightsContext.getStateSouthGreen());
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carEast++;
		Results.storeNewResult("Car added to Eastside");
		Results.storeNewResult("Total number of cars at Eastside is " + streetLightsContext.carEast);
		streetLightsContext.setState(streetLightsContext.getStateEastGreen());
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
