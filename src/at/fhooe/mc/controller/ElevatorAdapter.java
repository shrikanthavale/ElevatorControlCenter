/**
 *
 */
package at.fhooe.mc.controller;

import java.rmi.RemoteException;

import at.fhooe.mc.test.ElevatorMock;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 *
 */
public class ElevatorAdapter implements IElevatorControls {

	/**
	 * For time being referenced from mock object
	 */
	private IElevator iElevatorReference = new ElevatorMock();

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getCommittedDirection(int)
	 */
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getCommittedDirection(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorDoorStatus(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorPosition(int)
	 */
	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorPosition(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException{
		return iElevatorReference.getElevatorSpeed(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorWeight(int)
	 */
	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorWeight(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorCapacity(int)
	 */
	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException{
		return iElevatorReference.getElevatorCapacity(elevatorNumber);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setCommittedDirection(int, int)
	 */
	public int getFloorNum() throws java.rmi.RemoteException {
		return iElevatorReference.getFloorNum();
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException{
		iElevatorReference.setCommittedDirection(elevatorNumber, direction);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setServicesFloors(int, int, boolean)
	 */
	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		iElevatorReference.setServicesFloors(elevatorNumber, floor, service);

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setTarget(int, int)
	 */
	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException{
		iElevatorReference.setTarget(elevatorNumber, target);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsElevator(int)
	 */
	@Override
	public boolean[] getPressedButtonsElevator(int elevatorNumber) throws RemoteException{
		int floorNum = getFloorNum();
		boolean buttonsSet[] = new boolean[floorNum];

		for (int i = 0; i < floorNum; i++){
			buttonsSet[i] = iElevatorReference.getElevatorButton(elevatorNumber, i+1);
		}

		return buttonsSet;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsFloorDown()
	 */
	@Override
	public boolean[] getPressedButtonsFloorDown() throws RemoteException {
		int floorNum = getFloorNum();
		boolean buttonsSet[] = new boolean[floorNum];

		for (int i = 0; i < floorNum; i++){
			buttonsSet[i] = iElevatorReference.getFloorButtonDown(i+1);
		}

		return buttonsSet;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsFloorUp()
	 */
	@Override
	public boolean[] getPressedButtonsFloorUp() throws RemoteException {
		int floorNum = getFloorNum();
		boolean buttonsSet[] = new boolean[floorNum];

		for (int i = 0; i < floorNum; i++){
			buttonsSet[i] = iElevatorReference.getFloorButtonUp(i+1);
		}

		return buttonsSet;
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
