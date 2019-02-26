package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;
/*
 * This class is for the state where the West traffic light 
 * is Green. Here  cars pass as the light is green.
 * From here the control goes to the class where West light 
 * is red.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateWestGreen implements StreetLightsStateI 
{
	StreetLightsContext streetLightsContext;
	public StateWestGreen(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext= streetLightsContext;
	}
	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub		
		Results.storeNewResult("Tarffic light at Westside is Red");
		streetLightsContext.setState(streetLightsContext.getStateWestRed());
	}
	
	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at Westside turned Green");
		if(streetLightsContext.carWest>=2)
		{
			streetLightsContext.carWest-=2;
			Results.storeNewResult("2 cars left from West side");
		}
		else if(streetLightsContext.carWest== 1)
		{
			streetLightsContext.carWest--;
			Results.storeNewResult("1 car left from Westside");
		}
		if(streetLightsContext.carWest<=0)
		{
			Results.storeNewResult("No car left at Westside");
		}
		streetLightsContext.setState(streetLightsContext.getStateWestRed());
	}
	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carWest++;
		Results.storeNewResult("Car added to Westside");
		Results.storeNewResult("Total number of cars at Westside is " + streetLightsContext.carWest);
		streetLightsContext.setState(streetLightsContext.getStateSouthGreen());
	}
	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}
}
