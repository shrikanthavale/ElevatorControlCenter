/**
 *
 */
package at.fhooe.mc.controller;

import java.rmi.RemoteException;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 *
 */
public interface IElevatorControls {

	/**
	 * Retrieves the committed direction of the specified elevator (up / down / uncommitted).
	 * @param elevatorNumber - elevator number whose committed direction is being retrieved
	 * @return the current direction of the specified elevator where up=0, down=1 and uncommitted=2
	 * @throws java.rmi.RemoteException
	 */
	public int getCommittedDirection(int elevatorNumber) throws RemoteException ;

	/**
	 * Provides the current status of the doors of the specified elevator (open/closed).
	 * @param elevatorNumber - elevator number whose door status is being retrieved
	 * @return returns the door status of the indicated elevator where 1=open and 2=closed
	 * @throws RemoteException
	 */
	public int getElevatorDoorStatus(int elevatorNumber)  throws RemoteException;


	/**
	 * Provides the current location of the specified elevator in feet from the bottom of the building.
	 * @param elevatorNumber  - elevator number whose location is being retrieved
	 * @return returns the location in feet of the indicated elevator from the bottom of the building
	 * @throws RemoteException
	 */
	public int getElevatorPosition(int elevatorNumber) throws RemoteException;


	/**
	 * Provides the current speed of the specified elevator in feet per sec.
	 * @param elevatorNumber - elevator number whose speed is being retrieved
	 * @return returns the speed of the indicated elevator where positive speed is up and negative is down
	 * @throws RemoteException
	 */
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException;


	/**
	 * Retrieves the weight of passengers on the specified elevator.
	 * @param elevatorNumber - elevator number whose service is being retrieved
	 * @return total weight of all passengers in lbs
	 * @throws RemoteException
	 */
	public int getElevatorWeight(int elevatorNumber) throws RemoteException;


	/**
	 * Retrieves the maximum number of passengers that can fit on the specified elevator.
	 * @param elevatorNumber - elevator number whose service is being retrieved
	 * @return number of passengers
	 * @throws RemoteException
	 */
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException;

	/**
	 * Retrieves the number of floors in the building.
	 * @return total number of floors
	 */
	public int getFloorNum() throws java.rmi.RemoteException;

	/**
	 * Sets the committed direction of the specified elevator (up / down / uncommitted).
	 * @param elevatorNumber elevator number whose committed direction is being set
	 * @param direction direction being set where up=0, down=1 and uncommitted=2
	 * @throws RemoteException
	 */
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException;


	/**
	 * Sets whether or not the specified elevator will service the specified floor (yes/no).
	 * @param elevatorNumber elevator number whose service is being defined
	 * @param floor floor whose service by the specified elevator is being set
	 * @param service indicates whether the floor is serviced by the specified elevator (yes=true,no=false)
	 * @throws RemoteException
	 */
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException;


	/**
	 * Sets the floor target of the specified elevator.
	 * @param elevatorNumber elevator number whose target floor is being set
	 * @param target floor number which the specified elevator is to target
	 * @throws RemoteException
	 */
	public void setTarget(int elevatorNumber, int target) throws RemoteException;

	/**
	 * Provides the status of a floor request button on a specified elevator (on/off).
	 * @param elevatorNumber - elevator number whose button status is being retrieved
 	 * @return returns boolean array indicating which buttons are pressed inside this elevator
 	 * 			(example true,false,false ...  ) indicating (1 is pressed, 2 is not pressed, 2 is not pressed and so on)
 	 * @throws RemoteException
	 */
	public boolean[] getPressedButtonsElevator(int elevatorNumber) throws RemoteException;

	/**
	 * Provides the status of the Down button on all the floor (on/off).
	 * @return returns boolean array to indicate if DOWN button is active (true) or not (false)
	 * 			for all the floors in building
	 * @throws RemoteException
	 */
	public boolean[] getPressedButtonsFloorDown() throws RemoteException;

	/**
	 * Provides the status of the Up button on all the floors (on/off).
 	 * @return returns boolean array to indicate if UP button is active (true) or not (false)
	 * 			for all the floors in building
	 * @throws RemoteException
	 */
	public boolean[] getPressedButtonsFloorUp() throws RemoteException;


}
