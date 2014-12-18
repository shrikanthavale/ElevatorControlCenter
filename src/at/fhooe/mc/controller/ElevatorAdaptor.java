/**
 * 
 */
package at.fhooe.mc.controller;

import at.fhooe.mc.test.ElevatorMock;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 * 
 */
public class ElevatorAdaptor implements IElevatorControls {
	
	/**
	 * For time being referenced from mock object
	 */
	private IElevator iElevatorReference = new ElevatorMock();

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getCommittedDirection(int)
	 */
	@Override
	public int getCommittedDirection(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorDoorStatus(int)
	 */
	@Override
	public int getElevatorDoorStatus(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorPosition(int)
	 */
	@Override
	public int getElevatorPosition(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorSpeed(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorWeight(int)
	 */
	@Override
	public int getElevatorWeight(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorCapacity(int)
	 */
	@Override
	public int getElevatorCapacity(int elevatorNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setServicesFloors(int, int, boolean)
	 */
	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setTarget(int, int)
	 */
	@Override
	public void setTarget(int elevatorNumber, int target) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsElevator(int)
	 */
	@Override
	public boolean[] getPressedButtonsElevator(int elevatorNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsFloorDown()
	 */
	@Override
	public boolean[] getPressedButtonsFloorDown() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsFloorUp()
	 */
	@Override
	public boolean[] getPressedButtonsFloorUp() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the iElevatorReference
	 */
	public IElevator getiElevatorReference() {
		return iElevatorReference;
	}

	/**
	 * @param iElevatorReference the iElevatorReference to set
	 */
	public void setiElevatorReference(IElevator iElevatorReference) {
		this.iElevatorReference = iElevatorReference;
	}

}
