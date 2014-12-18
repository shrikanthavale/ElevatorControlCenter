/**
 * 
 */
package at.fhooe.mc.test;

import java.rmi.RemoteException;
import java.util.Observable;

import at.fhooe.mc.model.IElevator;

/**
 * @author Metrics_Testing Team
 * Dec 17, 2014
 * 
 */
public class ElevatorMock extends Observable implements IElevator {

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getCommittedDirection(int)
	 */
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorAccel(int)
	 */
	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorButton(int, int)
	 */
	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorDoorStatus(int)
	 */
	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorFloor(int)
	 */
	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorNum()
	 */
	@Override
	public int getElevatorNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorPosition(int)
	 */
	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorWeight(int)
	 */
	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getElevatorCapacity(int)
	 */
	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getFloorButtonDown(int)
	 */
	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getFloorButtonUp(int)
	 */
	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getFloorHeight()
	 */
	@Override
	public int getFloorHeight() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getFloorNum()
	 */
	@Override
	public int getFloorNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getServicesFloors(int, int)
	 */
	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getTarget(int)
	 */
	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#setServicesFloors(int, int, boolean)
	 */
	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#setTarget(int, int)
	 */
	@Override
	public void setTarget(int elevatorNumber, int target)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.fhooe.mc.model.IElevator#getClockTick()
	 */
	@Override
	public long getClockTick() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
