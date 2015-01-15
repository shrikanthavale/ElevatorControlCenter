/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import at.fhooe.mc.controller.ElevatorController;
import at.fhooe.mc.model.Elevator;

/**
 * The contorl panel showing floor numbers, buttons pressed in the elevator, 
 * radio buttons for setting target floor, and radio button showing current floor.
 * 
 * @author Metrics_Testing Team
 */
public class TableViewControlPanel extends JPanel implements Observer,
		ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 6199634431619829199L;
	
	/**
	 * constant for the Floor
	 */
	private static final String FLOOR = "Floor";

	/**
	 * constant for the Inside elevetor controls
	 */
	private static final String INSIDE_ELEVATOR_CONTROLS = "Inside Elevator Controls";
	
	/**
	 * constant for the Floor up
	 */
	private static final String ON_FLOOR_UP = "On Floor UP";

	/**
	 * constant for the Floor Down
	 */
	private static final String ON_FLOOR_DOWN = "On Floor DOWN";

	/**
	 * constant for the set target
	 */
	private static final String SET_TARGET = "Set Target";

	/**
	 * constant for the current position
	 */
	private static final String CURRENT_POSITION = "Current Position";

	/**
	 * capturing floor number
	 */
	private int floorNr;
	
	/**
	 * check if connection is available or not
	 */
	private boolean connection = true;

	/**
	 * list for buttons pressed inside floor 
	 */
	private List<JCheckBox> listInElFloor = new ArrayList<JCheckBox>();
	
	/**
	 * list of up buttons pressed outside the elevator
	 */
	private List<JCheckBox> listOnFloorUp = new ArrayList<JCheckBox>();
	
	/**
	 * list of down buttons pressed outside elevators
	 */
	private List<JCheckBox> listOnFloorDown = new ArrayList<JCheckBox>();
	
	/**
	 * list of target floors , that can be set in elevator
	 */
	private List<JRadioButton> listTargetFloor = new ArrayList<JRadioButton>();
	
	/**
	 * list of current floor
	 */
	private List<JRadioButton> listCurrentFloor = new ArrayList<JRadioButton>();

	/**
	 * radio buttons grouped (target and current floor radio button)
	 */
	private ButtonGroup groupTargetRBs, groupCurrentFloorRBs;

	/**
	 * elevator controller
	 */
	private ElevatorController elevatorController;

	/**
	 * constructor for initializing the top view control panel
	 */
	public TableViewControlPanel(ElevatorController controller, int floorNr) {
		super.setLayout(new GridLayout(floorNr+1, 6));
		this.setSize(400, 300);
		elevatorController = controller;
		this.floorNr = floorNr;
		groupTargetRBs = new ButtonGroup();
		groupCurrentFloorRBs = new ButtonGroup();
		initTableEntries();
	}

	/**
	 * dynamically creating number of floors
	 */
	private void initTableEntries() {
		setCaptions();
		for (int i = floorNr; i > 0; i--) {
			int floor = i;
			addFloor(floor);
		}

	}

	/**
	 * Add floor, adding floor contains adding a label for floor, infloor button pressed
	 * up and down button pressed outside elevator, radio buttons for setting the target
	 * radio buttons for showing current position of elevator.
	 * 
	 * @param floor floor number to be added
	 */
	private void addFloor(int floor){
		
		// label for floor
		add(new JLabel(""+floor));

		// inside elevator button pressed
		JCheckBox elFloor = new JCheckBox();
		elFloor.setEnabled(false);
		elFloor.setName("listInElFloor" + floor);
		listInElFloor.add(0,elFloor);
		add(listInElFloor.get(0));

		// outside up button pressed
		JCheckBox floorUp = new JCheckBox();
		floorUp.setEnabled(false);
		floorUp.setName("listOnFloorUp" + floor);
		listOnFloorUp.add(0,floorUp);
		add(listOnFloorUp.get(0));

		// outside down button pressed
		JCheckBox floorDown = new JCheckBox();
		floorDown.setEnabled(false);
		floorDown.setName("listOnFloorDown" + floor);
		listOnFloorDown.add(0,floorDown);
		add(listOnFloorDown.get(0));

		//radio button for setting this floor as target
		JRadioButton target = new JRadioButton();
		target.setName("listTargetFloor" + floor);
		target.setActionCommand("targetFloor"+floor);
		target.addActionListener(this);
		if (floor == 1){
			target.setSelected(true);
		}
		listTargetFloor.add(0,target);
		add(listTargetFloor.get(0));
		groupTargetRBs.add(listTargetFloor.get(0));

		// radio button for indicating if elevator is at current floor
		JRadioButton current = new JRadioButton();
		current.setEnabled(false);
		current.setName("listCurrentFloor" + floor);
		listCurrentFloor.add(0,current);
		add(listCurrentFloor.get(0));
		groupCurrentFloorRBs.add(listCurrentFloor.get(0));
	}

	/**
	 * set the heading of individual columns in UI.
	 */
	private void setCaptions() {
		// set Caption Row
		add(new JLabel(FLOOR));
		add(new JLabel(INSIDE_ELEVATOR_CONTROLS));
		add(new JLabel(ON_FLOOR_UP));
		add(new JLabel(ON_FLOOR_DOWN));
		add(new JLabel(SET_TARGET));
		add(new JLabel(CURRENT_POSITION));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object _object) {
		
		// update the data obtained from observable 
		// 
		if (_object instanceof Elevator) {
			connection = true;
			Elevator elevator = (Elevator) _object;

			for (int i = 0; i < floorNr; i++){
				listInElFloor.get(i).setSelected(elevator.getPressedButtonsElevator()[i]);
				listOnFloorUp.get(i).setSelected(elevator.getPressedButtonsFloorUp()[i]);
				listOnFloorDown.get(i).setSelected(elevator.getPressedButtonsFloorDown()[i]);
			}

			listCurrentFloor.get(elevator.getPosition()-1).setSelected(true);
		} else {
			// check if connection is lost
			if (connection){
				JOptionPane.showMessageDialog(this, "Lost connection to Emulator, so the status is not updated anymore!");
				connection = false;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButton) {
			JRadioButton button = (JRadioButton) e.getSource();

			if (button.isSelected()) {
				int i = 0;
				while (!button.equals(listTargetFloor.get(i)))
					i++;
				if (i < listTargetFloor.size()){
					elevatorController.setTarget(i+1);
				}
			}

		}
	}

	/**
	 * Enable or disable the target floors radio button based on the elevator is in 
	 * automatic or manual mode
	 * 
	 * @param automatic - true if automatic mode, false if manual mode
	 */
	public void setManualAutomaticMode(boolean automatic){
		if (automatic){
			for (int i = 0; i < floorNr; i++)
				listTargetFloor.get(i).setEnabled(false);
		} else {
			for (int i = 0; i < floorNr; i++)
				listTargetFloor.get(i).setEnabled(true);
		}
	}
}
