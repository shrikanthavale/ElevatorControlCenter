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
public class ElevatorController {

	private IElevatorControls iElevatorControlsReference;

	public ElevatorController(IElevatorControls controls) {
		iElevatorControlsReference = controls;
	}

	public void setTarget(int target){
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

}
