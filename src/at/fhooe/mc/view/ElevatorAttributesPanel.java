/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import at.fhooe.mc.model.Elevator;

/**
 * @author Viktor Baier S1310455001
 */
public class ElevatorAttributesPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 9111311437016062774L;

	private static final String TARGET = "Target: ";
	private static final String DOOR_STATUS = "Door Status: ";
	private static final String DOOR_STATUS_OPEN = "open";
	private static final String DOOR_STATUS_OPENING = "opening";
	private static final String DOOR_STATUS_CLOSED = "closed";

	private static final String ELEVATOR_MODE = "Mode: ";
	private static final String MANUAL = "manual";
	private static final String AUTOMATIC = "automatic";
	private static final String ELEVATOR_DIRECTION = "Elevator Direction: ";
	private static final String ELEVATOR_DIRECTION_UP = "up";
	private static final String ELEVATOR_DIRECTION_DOWN = "down";
	private static final String ELEVATOR_DIRECTION_NOT_SET = "not set";
	private static final String ELEVATOR_SPEED = "Speed: ";
	private static final String PAYLOAD = "Payload: ";

	private String targetFloor = "";
	private String doorState = "";
	private String mode = "";
	private String elevatorDirection = "";
	private String elevatorSpeed = "";
	private String payload = "";

	public ElevatorAttributesPanel() {
		setLayout(new GridLayout(6, 2));
		initTableEntries();

	}

	/**
	 *
	 */
	private void initTableEntries() {
		add(new JLabel(TARGET));
		add(new JLabel(targetFloor));

		add(new JLabel(DOOR_STATUS));
		add(new JLabel(doorState));

		add(new JLabel(ELEVATOR_MODE));
		add(new JLabel(mode));

		add(new JLabel(ELEVATOR_DIRECTION));
		add(new JLabel(elevatorDirection));

		add(new JLabel(ELEVATOR_SPEED));
		add(new JLabel(elevatorSpeed));

		add(new JLabel(PAYLOAD));
		add(new JLabel(targetFloor));

	}

	/**
	 * @return the targetFloor
	 */
	public String getTargetFloor() {
		return targetFloor;
	}

	/**
	 * @param targetFloor
	 *            the targetFloor to set
	 */
	public void setTargetFloor(String targetFloor) {
		this.targetFloor = targetFloor;
	}

	/**
	 * @return the doorState
	 */
	public String getDoorState() {
		return doorState;
	}

	/**
	 * @param doorState
	 *            the doorState to set
	 */
	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the elevatorDirection
	 */
	public String getElevatorDirection() {
		return elevatorDirection;
	}

	/**
	 * @param elevatorDirection
	 *            the elevatorDirection to set
	 */
	public void setElevatorDirection(String elevatorDirection) {
		this.elevatorDirection = elevatorDirection;
	}

	/**
	 * @return the elevatorSpeed
	 */
	public String getElevatorSpeed() {
		return elevatorSpeed;
	}

	/**
	 * @param elevatorSpeed
	 *            the elevatorSpeed to set
	 */
	public void setElevatorSpeed(String elevatorSpeed) {
		this.elevatorSpeed = elevatorSpeed;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object _object) {
		if (_object instanceof Elevator) {
			Elevator elevator = (Elevator) _object;
		}
	}

}
