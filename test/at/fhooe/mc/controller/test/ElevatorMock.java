/**
 *
 */
package at.fhooe.mc.controller.test;

import java.rmi.RemoteException;
import java.util.Random;

import at.fhooe.mc.controller.IElevator;

/**
 * @author Metrics_Testing Team Dec 17, 2014
 *
 */
public class ElevatorMock implements IElevator, Runnable {

	int[] directions = {ELEVATOR_DIRECTION_UP, ELEVATOR_DIRECTION_UNCOMMITTED, ELEVATOR_DIRECTION_UNCOMMITTED, ELEVATOR_DIRECTION_DOWN};
	int[] targets = {1,4,2,3};
	int[] positions = {1,1,1,1};

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

		if (elevatorNumber < 1 || elevatorNumber > 4)
			throw new RemoteException("Not existing elevator number.");
		else
			return directions[elevatorNumber-1];
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
			default:
				throw new RemoteException("Not existing floor.");
			}
			break;
		case 2:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = true;
				break;
			case 2:
				floorButtonInsideElevatorStatus = true;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = true;
				break;
			default:
				throw new RemoteException("Not existing floor.");
			}
			break;
		case 3:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = false;
				break;
			case 2:
				floorButtonInsideElevatorStatus = false;
				break;
			case 3:
				floorButtonInsideElevatorStatus = false;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			default:
				throw new RemoteException("Not existing floor.");
			}
			break;
		case 4:
			switch (floor) {
			case 1:
				floorButtonInsideElevatorStatus = false;
				break;
			case 2:
				floorButtonInsideElevatorStatus = true;
				break;
			case 3:
				floorButtonInsideElevatorStatus = true;
				break;
			case 4:
				floorButtonInsideElevatorStatus = false;
				break;
			default:
				throw new RemoteException("Not existing floor.");
			}
			break;
		default:
			throw new RemoteException("Not existing elevator number.");
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
			throw new RemoteException("Not existing elevator number.");
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
		if (elevatorNumber < 1 || elevatorNumber > 4)
			throw new RemoteException("Not existing elevator number.");
		else
			return positions[elevatorNumber-1];
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
			elevatorPositionFromGround = 100;
			break;
		case 2:
			elevatorPositionFromGround = 250;
			break;
		case 3:
			elevatorPositionFromGround = 500;
			break;
		case 4:
			elevatorPositionFromGround = 750;
			break;
		default:
			throw new RemoteException("Not existing elevator number.");
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
			elevatorSpeed = 30;
			break;
		case 2:
			elevatorSpeed = 0;
			break;
		case 3:
			elevatorSpeed = 10;
			break;
		case 4:
			elevatorSpeed = 50;
			break;
		default:
			throw new RemoteException("Not existing elevator number.");
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
			elevatorWeight = 500;
			break;
		case 2:
			elevatorWeight = 550;
			break;
		case 3:
			elevatorWeight = 800;
			break;
		case 4:
			elevatorWeight = 720;
			break;
		default:
			throw new RemoteException("Not existing elevator number.");
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
			elevatorCapacity = 0;
			break;
		case 2:
			elevatorCapacity = 5;
			break;
		case 3:
			elevatorCapacity = 7;
			break;
		case 4:
			elevatorCapacity = 10;
			break;
		default:
			throw new RemoteException("Not existing elevator number.");
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
			floorButtonDownStatus = false;
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
		return 4;
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
		if (elevatorNumber < 1 || elevatorNumber > 4)
			throw new RemoteException("Not existing elevator number.");
		else
			return targets[elevatorNumber-1];
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see at.fhooe.mc.model.IElevator#setCommittedDirection(int, int)
	 */
	@Override
	public void setCommittedDirection(int elevatorNumber, int direction)
			throws RemoteException {
		if (elevatorNumber < 1 || elevatorNumber > 4)
			throw new RemoteException("Not existing elevator number.");
		else
			if (direction != ELEVATOR_DIRECTION_UP && direction != ELEVATOR_DIRECTION_DOWN && direction != ELEVATOR_DIRECTION_UNCOMMITTED)
				throw new RemoteException("Not existing direction.");
			else
				directions[elevatorNumber-1] = direction;
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
		if (elevatorNumber < 1 || elevatorNumber > 4)
			throw new RemoteException("Not existing elevator number.");
		else
			if (target < 1 || target > 4)
				throw new RemoteException("Not existing target.");
			else{
				targets[elevatorNumber-1] = target;

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				positions[elevatorNumber-1] = target;
				directions[elevatorNumber-1] = ELEVATOR_DIRECTION_UNCOMMITTED;
			}
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
