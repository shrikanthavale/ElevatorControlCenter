/**
 *
 */
package at.fhooe.mc.controller;

import java.rmi.RemoteException;
import java.util.Observable;

import at.fhooe.mc.model.Elevator;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 *
 */
public class ElevatorUpdater extends Observable implements Runnable {
	private Elevator elevator = new Elevator();
	private boolean looping = true;
	private IElevatorControls adapter;

	public ElevatorUpdater(IElevatorControls controls){
		adapter = controls;
	}

	@Override
	public void setChanged(){
		super.setChanged();
	}

	@Override
	public void notifyObservers(){
		super.notifyObservers(elevator);
	}

	public Elevator getElevator(){
		return elevator;
	}

	public void setLooping(boolean looping){
		this.looping = looping;
	}

	@Override
	public void run() {
		while(looping){
			try {
				elevator.setCapacity(adapter.getElevatorCapacity(1));
				elevator.setCurrentDirection(adapter.getCommittedDirection(1));
				elevator.setDoorStatus(adapter.getElevatorDoorStatus(1));
				elevator.setPosition(adapter.getElevatorFloor(1));
				elevator.setPressedButtonsElevator(adapter.getPressedButtonsElevator(1));
				elevator.setPressedButtonsFloorDown(adapter.getPressedButtonsFloorDown());
				elevator.setPressedButtonsFloorUp(adapter.getPressedButtonsFloorUp());
				elevator.setSpeed(adapter.getElevatorSpeed(1));
				elevator.setWeight(adapter.getElevatorWeight(1));
				elevator.setTarget(adapter.getTarget(1));

			} catch (RemoteException e) {
				elevator = null;
			}

			setChanged();
			notifyObservers();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
