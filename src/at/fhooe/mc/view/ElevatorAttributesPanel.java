/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import at.fhooe.mc.controller.ElevatorController;
import at.fhooe.mc.model.Elevator;

/**
 * This class creates a panel containing information obtained from elevator simulator. Information like Target,
 * Door status, Mode, Elevator Direction, and Speed.
 * 
 * @author Metrics_Testing Team Dec 17, 2014
 */
public class ElevatorAttributesPanel extends JPanel implements Observer, ActionListener {

	private static final long serialVersionUID = 9111311437016062774L;

	public static final String TARGET = "Target: ";
	private static final String DOOR_STATUS = "Door Status: ";
	private static final String DOOR_STATUS_OPEN = "open";
	private static final String DOOR_STATUS_OPENING = "opening";
	private static final String DOOR_STATUS_CLOSED = "closed";
	private static final String DOOR_STATUS_CLOSING = "closing";

	private static final String ELEVATOR_MODE = "Mode: ";
	private static final String MANUAL = "manual";
	private static final String AUTOMATIC = "automatic";
	private static final String ELEVATOR_DIRECTION = "Elevator Direction: ";
	private static final String ELEVATOR_DIRECTION_UP = "up";
	private static final String ELEVATOR_DIRECTION_DOWN = "down";
	private static final String ELEVATOR_DIRECTION_NOT_SET = "not set";
	private static final String ELEVATOR_SPEED = "Speed: ";
	private static final String PAYLOAD = "Payload: ";

	private JLabel lblTarget, lblDoorState, lblDirection, lblSpeed, lblPayload;
	private JRadioButton cheManual, cheAutomatic;
	private ButtonGroup bgrMode;

	private ElevatorController elevatorController;
	private TableViewControlPanel tableView;

	public ElevatorAttributesPanel(ElevatorController controller, TableViewControlPanel table) {
		setLayout(new GridLayout(6, 2));
		initTableEntries();
		elevatorController = controller;
		tableView = table;
	}

	/**
	 *
	 */
	private void initTableEntries() {
		add(new JLabel(TARGET));
		lblTarget = new JLabel();
		lblTarget.setName("labeltarget");
		add(lblTarget);

		add(new JLabel(DOOR_STATUS));
		lblDoorState = new JLabel();
		add(lblDoorState);

		add(new JLabel(ELEVATOR_MODE));
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		bgrMode = new ButtonGroup();
		cheManual = new JRadioButton();
		cheManual.setName(MANUAL);
		cheManual.addActionListener(this);
		cheManual.setText(MANUAL);
		cheManual.setSelected(true);
		bgrMode.add(cheManual);
		p.add(cheManual);
		cheAutomatic = new JRadioButton();
		cheAutomatic.setName(AUTOMATIC);
		cheAutomatic.addActionListener(this);
		cheAutomatic.setText(AUTOMATIC);
		bgrMode.add(cheAutomatic);
		p.add(cheAutomatic);
		add(p);

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
			default:
				lblDirection.setText(ELEVATOR_DIRECTION_NOT_SET);
			}

			lblSpeed.setText(""+elevator.getSpeed() + " feet/second");
			lblPayload.setText(""+elevator.getWeight()+" lbs");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JRadioButton){
			JRadioButton button = (JRadioButton)arg0.getSource();

			if (button.isSelected()){
				if (button.equals(cheManual)){
					elevatorController.setAutomaticMode(false);
					tableView.setManualAutomaticMode(false);
				}
				if (button.equals(cheAutomatic)){
					elevatorController.setAutomaticMode(true);
					tableView.setManualAutomaticMode(true);
				}
			}
		}

	}

}
