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

	public ElevatorController(IElevatorControls controls) {
		iElevatorControlsReference = controls;
	}

	public void setTarget(int target) {
		try {
			int currPos = iElevatorControlsReference.getElevatorFloor(1);
			iElevatorControlsReference.setTarget(1, target);
			if (currPos < target)
				iElevatorControlsReference.setCommittedDirection(1,
						IElevatorControls.ELEVATOR_DIRECTION_UP);
			else
				iElevatorControlsReference.setCommittedDirection(1,
						IElevatorControls.ELEVATOR_DIRECTION_DOWN);

		} catch (RemoteException e) {
			// TODO
		}
	}

	public void setTargetAutomaticMode(Elevator _elevator) {
		// _elevator.getCapacity();
		// _elevator.getCurrentDirection();
		// _elevator.getDoorStatus();
		// _elevator.getPosition();
		// _elevator.getPressedButtonsElevator();
		// _elevator.getPressedButtonsFloorDown();
		// _elevator.getPressedButtonsFloorUp();
		// _elevator.getSpeed();
		// _elevator.getTarget();
		// _elevator.getWeight();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Elevator) {
//			Elevator elevator = (Elevator) arg1;
			if (automaticMode) {
				// dosomefancystuff
			}
		}
	}

	/**
	 * @param automaticMode
	 *            the automaticMode to set
	 */
	public void setAutomaticMode(boolean automaticMode) {
		this.automaticMode = automaticMode;
	}

}
