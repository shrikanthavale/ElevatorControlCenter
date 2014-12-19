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
			iElevatorControlsReference.setTarget(1, target);
		} catch (RemoteException e) {
			// TODO
		}
	}

}
