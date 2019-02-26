 package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/*
 * This class is for the state where the East traffic light 
 * is Green. Here cars pass as the light is green
 * From here the control goes to the class where east light 
 * is red.
 * 
 * It implements the StreetLightsStateI interface.
 */
public class StateEastGreen implements StreetLightsStateI {
	
	
	StreetLightsContext streetLightsContext;
	public StateEastGreen(StreetLightsContext streetLightsContext)
	{
		this.streetLightsContext=streetLightsContext;
	}
	
	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at Eastside is Red");	
	}

	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		Results.storeNewResult("Tarffic light at East turned Green");
		if(streetLightsContext.carEast>=2)
		{
			streetLightsContext.carEast-=2;
			Results.storeNewResult("2 cars left from East");
		}
		else if(streetLightsContext.carEast==1)
		{
			streetLightsContext.carEast--;
			Results.storeNewResult("1 car left from East");
		}
		if(streetLightsContext.carEast==0)
		{
			Results.storeNewResult("No car left at East");
		}
		streetLightsContext.setState(streetLightsContext.getStateEastRed());
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		streetLightsContext.carEast++;
		Results.storeNewResult("Car added to Eastside");
		Results.storeNewResult("Total number of cars at Eastside is " + streetLightsContext.carEast);
		streetLightsContext.setState(streetLightsContext.getStateWestGreen());
		
		
	}

	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		
	}

}
