package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/*
 * This class is for the state where the North traffic light 
 * is Green. Here cars pass as the light is green.
 * From here the control goes to the class where North light 
 * is red.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateNorthGreen implements StreetLightsStateI {
	
	StreetLightsContext streetLightsContext;
	public StateNorthGreen(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext= streetLightsContext;
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at North turned Green");
		if(streetLightsContext.carNorth>=2)
		{
			streetLightsContext.carNorth-=2;
			Results.storeNewResult("2 cars left from North");
		}
		else if(streetLightsContext.carNorth==1)
		{
			streetLightsContext.carNorth--;
			Results.storeNewResult("1 car left from North");
		}
		if(streetLightsContext.carNorth==0)
		{
			Results.storeNewResult("No car left at North");
		}
		streetLightsContext.setState(streetLightsContext.getStateNorthRed());
	}

	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at Northside is Red");
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carNorth++;
		Results.storeNewResult("Car added to Northside");
		Results.storeNewResult("Total number of cars at Northside is " + streetLightsContext.carNorth);
		streetLightsContext.setState(streetLightsContext.getStateEastGreen());
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}
	
}
