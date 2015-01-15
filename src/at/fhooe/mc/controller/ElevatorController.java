/**
 *
 */
package at.fhooe.mc.controller;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import at.fhooe.mc.model.Elevator;

/**
 * @author Metrics_Testing Team Dec 18, 2014
 *
 */
public class ElevatorController implements Observer {

	private IElevatorControls iElevatorControlsReference;
	private boolean automaticMode = false;
	private int currentTarget = 1;
	private static final int CURRENT_DIRECTION_UP = 1;
	private static final int CURRENT_DIRECTION_DOWN = 2;
	private int autoModeCurrentDirection = 1;

	public ElevatorController(IElevatorControls controls) {
		iElevatorControlsReference = controls;
	}

	public void setTarget(int target) {
		try {
			int currPos = iElevatorControlsReference.getElevatorFloor(1);
			iElevatorControlsReference.setTarget(1, target);
			if (currPos < target)
				iElevatorControlsReference.setCommittedDirection(1, IElevatorControls.ELEVATOR_DIRECTION_UP);
			else
				iElevatorControlsReference.setCommittedDirection(1, IElevatorControls.ELEVATOR_DIRECTION_DOWN);

		} catch (RemoteException e) {
			// TODO
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Elevator) {
			Elevator elevator = (Elevator) arg1;
			if (automaticMode) {
				if (currentTarget == elevator.getPosition()) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setTarget(calculateNextTarget(elevator));
				}
			} else {
				currentTarget = elevator.getTarget();
			}
		}
	}

	/**
	 * @param elevator
	 * @return
	 */
	private int calculateNextTarget(Elevator elevator) {
		int targetFloor = -1;

		// On Floors, direction UP
		if (autoModeCurrentDirection == ElevatorController.CURRENT_DIRECTION_UP) {

			for (int i = 0; i < elevator.getPressedButtonsFloorUp().length; i++) {
				if (elevator.getPressedButtonsFloorUp()[i]) {
					if (elevator.getPosition() < i) {
						targetFloor = i;
					}
				}
			}

			// In Elevator -
			for (int i = 0; i < elevator.getPressedButtonsElevator().length; i++) {
				if (elevator.getPressedButtonsElevator()[i]) {
					if (elevator.getPosition() < i && targetFloor > i) {
						targetFloor = i;
					}
				}
			}

			if (targetFloor == -1) {
				if (elevator.getPressedButtonsElevator().length == 0
						&& elevator.getPressedButtonsFloorDown().length == 0
						&& elevator.getPressedButtonsFloorUp().length == 0) {
					targetFloor = 1;
				} else {
					autoModeCurrentDirection = ElevatorController.CURRENT_DIRECTION_DOWN;
					targetFloor = 6;
				}
			}

		} else if (autoModeCurrentDirection == ElevatorController.CURRENT_DIRECTION_DOWN) {
			for (int i = 0; i < elevator.getPressedButtonsFloorDown().length; i++) {
				if (elevator.getPressedButtonsFloorDown()[i]) {
					if (elevator.getPosition() > i) {
						targetFloor = i;
					}
				}
			}

			for (int i = 0; i < elevator.getPressedButtonsElevator().length; i++) {
				if (elevator.getPressedButtonsElevator()[i]) {
					if (elevator.getPosition() > i && targetFloor < i) {
						targetFloor = i;
					}
				}
			}

			if (targetFloor == -1) {
				if (elevator.getPressedButtonsElevator().length == 0
						&& elevator.getPressedButtonsFloorDown().length == 0
						&& elevator.getPressedButtonsFloorUp().length == 0) {
					targetFloor = 1;
				} else {
					autoModeCurrentDirection = ElevatorController.CURRENT_DIRECTION_UP;
					targetFloor = 1;
				}

			}
		}
		currentTarget = targetFloor;
		return targetFloor;
	}

	/**
	 * @param automaticMode
	 *            the automaticMode to set
	 */
	public void setAutomaticMode(boolean automaticMode) {
		this.automaticMode = automaticMode;
	}

}
