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
	private static final String DOOR_STATUS_CLOSING = "closing";

	private static final String ELEVATOR_MODE = "Mode: ";
	private static final String MANUAL = "manual";
//	private static final String AUTOMATIC = "automatic";
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

	private JLabel lblTarget, lblDoorState, lblMode, lblDirection, lblSpeed, lblPayload;

	public ElevatorAttributesPanel() {
		setLayout(new GridLayout(6, 2));
		initTableEntries();

	}

	/**
	 *
	 */
	private void initTableEntries() {
		add(new JLabel(TARGET));
		lblTarget = new JLabel();
		add(lblTarget);

		add(new JLabel(DOOR_STATUS));
		lblDoorState = new JLabel();
		add(lblDoorState);

		add(new JLabel(ELEVATOR_MODE));
		lblMode = new JLabel(MANUAL);
		add(lblMode);

		add(new JLabel(ELEVATOR_DIRECTION));
		lblDirection = new JLabel();
		add(lblDirection);

		add(new JLabel(ELEVATOR_SPEED));
		lblSpeed = new JLabel();
		add(lblSpeed);

		add(new JLabel(PAYLOAD));
		lblPayload = new JLabel();
		add(lblPayload);

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

			lblTarget.setText(""+elevator.getTarget());
			switch(elevator.getDoorStatus()){
			case 1:
				lblDoorState.setText(DOOR_STATUS_OPEN);
				break;
			case 2:
				lblDoorState.setText(DOOR_STATUS_CLOSED);
				break;
			case 3:
				lblDoorState.setText(DOOR_STATUS_OPENING);
				break;
			case 4:
				lblDoorState.setText(DOOR_STATUS_CLOSING);
				break;
			default:
				lblDoorState.setText("Default");
			}

			switch(elevator.getCurrentDirection()){
			case 0:
				lblDirection.setText(ELEVATOR_DIRECTION_UP);
				break;
			case 1:
				lblDirection.setText(ELEVATOR_DIRECTION_DOWN);
				break;
			case 2:
				lblDirection.setText(ELEVATOR_DIRECTION_NOT_SET);
				break;
			default:
				lblDirection.setText("Default");
			}

			lblSpeed.setText(""+elevator.getSpeed());
			lblPayload.setText(""+elevator.getWeight());
		}
	}

}
