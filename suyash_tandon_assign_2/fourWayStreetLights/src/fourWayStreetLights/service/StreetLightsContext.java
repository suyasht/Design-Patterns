package fourWayStreetLights.service;

import fourWayStreetLights.util.FileProcessor;

/*
 * This is the Context class for the assignment. From here
 * each function is directed towards the required state.
 */
public class StreetLightsContext implements StreetLightsStateI{

	
	int carNorth=3;
	int carEast=3;
	int carWest=3;
	int carSouth=3;
	
	 StreetLightsStateI stateEastGreen;
	 StreetLightsStateI stateWestGreen;
	 StreetLightsStateI stateNorthGreen;
	 StreetLightsStateI stateSouthGreen;
	 
	 StreetLightsStateI stateEastRed;
	 StreetLightsStateI stateWestRed;
	 StreetLightsStateI stateNorthRed;
	 StreetLightsStateI stateSouthRed;
	 
	 StreetLightsStateI stateAllRed;
	 
	 StreetLightsStateI state= stateAllRed;
	 
	 public StreetLightsContext()
	 {
		 stateEastGreen= new StateEastGreen(this);
		 stateWestGreen= new StateWestGreen(this);
		 stateNorthGreen= new StateNorthGreen(this);
		 stateSouthGreen= new StateSouthGreen(this);
		 
		 stateEastRed= new StateEastRed(this);
		 stateWestRed= new StateWestRed(this);
		 stateNorthRed= new StateNorthRed(this);
		 stateSouthRed= new StateSouthRed(this);
		 stateAllRed= new StateAllRed(this);
	 }


	@Override
	public void changeToGreen() {
		// TODO Auto-generated method stub
		state.changeToGreen();
	}
	
	@Override
	public void changeToRed() {
		// TODO Auto-generated method stub
		state.changeToRed();
	}

	void setState(StreetLightsStateI state )
	{
		this.state=state;
	}	
	//Maintains current state and takes action from user

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		state.addCar();		
	}
	
	public StreetLightsStateI getStateEastRed() { return stateEastRed;}
	
	public StreetLightsStateI getStateNorthRed() { return stateNorthRed;}
	
	public StreetLightsStateI getStateWestRed() { return stateWestRed;}
	
	public StreetLightsStateI getStateSouthRed() { return stateSouthRed;}
	
	public StreetLightsStateI getStateEastGreen() { return stateEastGreen;}
	
	public StreetLightsStateI getStateNorthGreen() { return stateNorthGreen;}
	
	public StreetLightsStateI getStateWestGreen() { return stateWestGreen;}
	
	public StreetLightsStateI getStateSouthGreen() { return stateSouthGreen;}


	@Override
	public void changeAllToRed() {
		// TODO Auto-generated method stub
		stateAllRed.changeAllToRed();
		
	}
			
}


	
