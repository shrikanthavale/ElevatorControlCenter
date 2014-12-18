/**
 * 
 */
package at.fhooe.mc.controller;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 * 
 */
public class ElevatorController {
	
	private IElevatorControls iElevatorControlsReference;
	
	public ElevatorController() {
		iElevatorControlsReference = new ElevatorAdaptor();
	}
	
}
