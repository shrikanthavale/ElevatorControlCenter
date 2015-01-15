/**
 *
 */
package at.fhooe.mc.controller;

import java.rmi.RemoteException;

import sqelevator.IElevator;

/**
 * 
 * 
 * @author Metrics_Testing Team
 * Dec 18, 2014
 *
 */
public class ElevatorAdapter implements IElevatorControls {

	/**
	 * For time being referenced from mock object
	 */
	private IElevator iElevatorReference = null;

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getCommittedDirection(int)
	 */
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getCommittedDirection(elevatorNumber-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorDoorStatus(elevatorNumber-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorFloor(int)
	 */
	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorFloor(elevatorNumber-1)+1;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException{
		return iElevatorReference.getElevatorSpeed(elevatorNumber-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorWeight(int)
	 */
	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		return iElevatorReference.getElevatorWeight(elevatorNumber-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getElevatorCapacity(int)
	 */
	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException{
		return iElevatorReference.getElevatorCapacity(elevatorNumber-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setCommittedDirection(int, int)
	 */
	public int getFloorNum() throws RemoteException {
		return iElevatorReference.getFloorNum();
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException{
		iElevatorReference.setCommittedDirection(elevatorNumber-1, direction);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.conroller.IElevatorControls#getTarget(int)
	 */
	@Override
	public int getTarget(int elevatorNumber) throws RemoteException{
		return iElevatorReference.getTarget(elevatorNumber-1)+1;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#setTarget(int, int)
	 */
	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException{
		iElevatorReference.setTarget(elevatorNumber-1, target-1);
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.controller.IElevatorControls#getPressedButtonsElevator(int)
	 */
	@Override
	public boolean[] getPressedButtonsElevator(int elevatorNumber) throws RemoteException{
		int floorNum = getFloorNum();
		boolean buttonsSet[] = new boolean[floorNum];

		for (int i = 0; i < floorNum; i++){
			buttonsSet[i] = iElevatorReference.getElevatorButton(elevatorNumber-1, i);
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
			buttonsSet[i] = iElevatorReference.getFloorButtonDown(i);
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
			buttonsSet[i] = iElevatorReference.getFloorButtonUp(i);
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
	 * @throws NullPointerException
	 */
	public void setiElevatorReference(IElevator iElevatorReference) throws NullPointerException{
		if (iElevatorReference == null)
			throw new NullPointerException("Null reference.");
		else
			this.iElevatorReference = iElevatorReference;
	}

}
