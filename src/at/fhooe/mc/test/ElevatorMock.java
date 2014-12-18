/**
 * 
 */
package at.fhooe.mc.test;

import java.rmi.RemoteException;
import java.util.Random;

import at.fhooe.mc.controller.IElevator;

/**
 * @author Metrics_Testing Team Dec 17, 2014
 * 
 */
public class ElevatorMock implements IElevator, Runnable {

	@Override
	public void run() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getCommittedDirection(int)
	 */
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {

		int elevatorDirection = ELEVATOR_DIRECTION_UNCOMMITTED;

		switch (elevatorNumber) {
		case 1:
			elevatorDirection = ELEVATOR_DIRECTION_UP;
			break;
		case 2:
			elevatorDirection = ELEVATOR_DIRECTION_UNCOMMITTED;
			break;
		case 3:
			elevatorDirection = ELEVATOR_DIRECTION_UNCOMMITTED;
			break;
		case 4:
			elevatorDirection = ELEVATOR_DIRECTION_DOWN;
			break;
		default:
			break;
		}

		return elevatorDirection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorAccel(int)
	 */
	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		int elevatorAcceleration = 0;

		switch (elevatorNumber) {
		case 1:
			elevatorAcceleration = randInt(50, 100);
			break;
		case 2:
			elevatorAcceleration = randInt(50, 100);
			break;
		case 3:
			elevatorAcceleration = randInt(50, 100);
			break;
		case 4:
			elevatorAcceleration = randInt(50, 100);
			break;
		default:
			break;
		}

		return elevatorAcceleration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorButton(int, int)
	 */
	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor)
			throws RemoteException {

		boolean floorButtonInsideElevatorStatus = false;

		switch (elevatorNumber) {
		case 1:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = true;
				break;
			case 2:
				floorButtonInsideElevatorStatus = false;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			case 5:
				floorButtonInsideElevatorStatus = true;
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = true;
				break;
			case 2:
				floorButtonInsideElevatorStatus = false;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			case 5:
				floorButtonInsideElevatorStatus = true;
				break;
			default:
				break;
			}
		case 3:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = true;
				break;
			case 2:
				floorButtonInsideElevatorStatus = false;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			case 5:
				floorButtonInsideElevatorStatus = true;
				break;
			default:
				break;
			}
		case 4:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = true;
				break;
			case 2:
				floorButtonInsideElevatorStatus = false;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			case 5:
				floorButtonInsideElevatorStatus = true;
				break;
			default:
				break;
			}
		default:
			break;
		}

		return floorButtonInsideElevatorStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorDoorStatus(int)
	 */
	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		int elevatorDoorStatus = ELEVATOR_DOORS_CLOSED;

		switch (elevatorNumber) {
		case 1:
			elevatorDoorStatus = ELEVATOR_DOORS_CLOSED;
			break;
		case 2:
			elevatorDoorStatus = ELEVATOR_DOORS_OPENING;
			break;
		case 3:
			elevatorDoorStatus = ELEVATOR_DOORS_OPEN;
			break;
		case 4:
			elevatorDoorStatus = ELEVATOR_DOORS_CLOSING;
			break;
		default:
			break;
		}

		return elevatorDoorStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorFloor(int)
	 */
	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		int floorClosetToEleveator = 0;

		switch (elevatorNumber) {
		case 1:
			floorClosetToEleveator = randInt(1, 5);
			break;
		case 2:
			floorClosetToEleveator = randInt(1, 5);
			break;
		case 3:
			floorClosetToEleveator = randInt(1, 5);
			break;
		case 4:
			floorClosetToEleveator = randInt(1, 5);
			break;
		default:
			break;
		}

		return floorClosetToEleveator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorNum()
	 */
	@Override
	public int getElevatorNum() throws RemoteException {
		return 4;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorPosition(int)
	 */
	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		int elevatorPositionFromGround = 0;

		switch (elevatorNumber) {
		case 1:
			elevatorPositionFromGround = randInt(100, 750);
			break;
		case 2:
			elevatorPositionFromGround = randInt(100, 750);
			break;
		case 3:
			elevatorPositionFromGround = randInt(100, 750);
			break;
		case 4:
			elevatorPositionFromGround = randInt(100, 750);
			break;
		default:
			break;
		}

		return elevatorPositionFromGround;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorSpeed(int)
	 */
	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		int elevatorSpeed = 0;

		switch (elevatorNumber) {
		case 1:
			elevatorSpeed = randInt(30, 50);
			break;
		case 2:
			elevatorSpeed = randInt(30, 50);
			break;
		case 3:
			elevatorSpeed = randInt(30, 50);
			break;
		case 4:
			elevatorSpeed = randInt(30, 50);
			break;
		default:
			break;
		}

		return elevatorSpeed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorWeight(int)
	 */
	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		int elevatorWeight = 0;

		switch (elevatorNumber) {
		case 1:
			elevatorWeight = randInt(500, 800);
			break;
		case 2:
			elevatorWeight = randInt(500, 800);
			break;
		case 3:
			elevatorWeight = randInt(500, 800);
			break;
		case 4:
			elevatorWeight = randInt(500, 800);
			break;
		default:
			break;
		}

		return elevatorWeight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getElevatorCapacity(int)
	 */
	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		int elevatorCapacity = 0;

		switch (elevatorNumber) {
		case 1:
			elevatorCapacity = randInt(0, 10);
			break;
		case 2:
			elevatorCapacity = randInt(0, 10);
			break;
		case 3:
			elevatorCapacity = randInt(0, 10);
			break;
		case 4:
			elevatorCapacity = randInt(0, 10);
			break;
		default:
			break;
		}

		return elevatorCapacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getFloorButtonDown(int)
	 */
	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		boolean floorButtonDownStatus = false;

		switch (floor) {
		case 1:
			floorButtonDownStatus = true;
			break;
		case 2:
			floorButtonDownStatus = false;
			break;
		case 3:
			floorButtonDownStatus = true;
			break;
		case 4:
			floorButtonDownStatus = false;
			break;
		case 5:
			floorButtonDownStatus = true;
			break;
		default:
			break;
		}

		return floorButtonDownStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getFloorButtonUp(int)
	 */
	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		boolean floorButtonUpStatus = false;

		switch (floor) {
		case 1:
			floorButtonUpStatus = true;
			break;
		case 2:
			floorButtonUpStatus = false;
			break;
		case 3:
			floorButtonUpStatus = true;
			break;
		case 4:
			floorButtonUpStatus = false;
			break;
		case 5:
			floorButtonUpStatus = true;
			break;
		default:
			break;
		}

		return floorButtonUpStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getFloorHeight()
	 */
	@Override
	public int getFloorHeight() throws RemoteException {
		return randInt(100, 150);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getFloorNum()
	 */
	@Override
	public int getFloorNum() throws RemoteException {
		return 5;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getServicesFloors(int, int)
	 */
	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor)
			throws RemoteException {
		boolean elevatorServiceFloors = false;

		switch (elevatorNumber) {
		case 1:
			switch (floor) {
			case 1:
				elevatorServiceFloors = true;
				break;
			case 2:
				elevatorServiceFloors = true;
				break;
			case 3:
				elevatorServiceFloors = true;
				break;
			case 4:
				elevatorServiceFloors = true;
				break;
			case 5:
				elevatorServiceFloors = false;
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (floor) {
			case 1:
				elevatorServiceFloors = true;
				break;
			case 2:
				elevatorServiceFloors = true;
				break;
			case 3:
				elevatorServiceFloors = true;
				break;
			case 4:
				elevatorServiceFloors = false;
				break;
			case 5:
				elevatorServiceFloors = true;
				break;
			default:
				break;
			}
		case 3:
			switch (floor) {
			case 1:
				elevatorServiceFloors = true;
				break;
			case 2:
				elevatorServiceFloors = false;
				break;
			case 3:
				elevatorServiceFloors = true;
				break;
			case 4:
				elevatorServiceFloors = true;
				break;
			case 5:
				elevatorServiceFloors = true;
				break;
			default:
				break;
			}
		case 4:
			switch (floor) {
			case 1:
				elevatorServiceFloors = true;
				break;
			case 2:
				elevatorServiceFloors = true;
				break;
			case 3:
				elevatorServiceFloors = false;
				break;
			case 4:
				elevatorServiceFloors = true;
				break;
			case 5:
				elevatorServiceFloors = true;
				break;
			default:
				break;
			}
		default:
			break;
		}

		return elevatorServiceFloors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getTarget(int)
	 */
	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		return randInt(1, 5);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#setServicesFloors(int, int, boolean)
	 */
	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#setTarget(int, int)
	 */
	@Override
	public void setTarget(int elevatorNumber, int target)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhooe.mc.model.IElevator#getClockTick()
	 */
	@Override
	public long getClockTick() throws RemoteException {
		return randInt(50, 100);
	}
	
	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
}
