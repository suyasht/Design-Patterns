package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/*
 * This class is for the state where the South traffic light 
 * is Green. Here cars pass as the light is red.
 * From here the control goes to the class where South light 
 * is Red.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateSouthGreen implements StreetLightsStateI {
	
	StreetLightsContext streetLightsContext;
	public StateSouthGreen(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext= streetLightsContext;
	}
	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at Southside is Red");
	}
	
	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub	
		Results.storeNewResult("Tarffic light at South turned Green");
		if(streetLightsContext.carSouth>=2)
		{
			streetLightsContext.carSouth-=2;
			Results.storeNewResult("2 cars left from South");
		}
		else if(streetLightsContext.carSouth==1)
		{
			streetLightsContext.carSouth--;
			Results.storeNewResult("1 car left from South");
		}
		if(streetLightsContext.carSouth==0)
		{
			Results.storeNewResult("No car left at South");
		}
		streetLightsContext.setState(streetLightsContext.getStateSouthRed());
	}
	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carSouth++;
		Results.storeNewResult("Car added to Southside");
		Results.storeNewResult("Total number of cars at Southside is " + streetLightsContext.carSouth);
		streetLightsContext.setState(streetLightsContext.getStateEastGreen());
	}
	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
