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
 * @author Viktor Baier S1310455001
 */
public class TableViewControlPanel extends JPanel implements Observer,
		ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 6199634431619829199L;
	private static final String FLOOR = "Floor";
	private static final String INSIDE_ELEVATOR_CONTROLS = "Inside Elevator Controls";
	private static final String ON_FLOOR_UP = "On Floor UP";
	private static final String ON_FLOOR_DOWN = "On Floor DOWN";
	private static final String SET_TARGET = "Set Target";
	private static final String CURRENT_POSITION = "Current Position";

	private int floorNr;
	boolean connection = true;

	private List<JCheckBox> listInElFloor = new ArrayList<JCheckBox>();
	private List<JCheckBox> listOnFloorUp = new ArrayList<JCheckBox>();
	private List<JCheckBox> listOnFloorDown = new ArrayList<JCheckBox>();
	private List<JRadioButton> listTargetFloor = new ArrayList<JRadioButton>();
	private List<JRadioButton> listCurrentFloor = new ArrayList<JRadioButton>();

	private ButtonGroup groupTargetRBs, groupCurrentFloorRBs;

	private ElevatorController elevatorController;

	/**
	 *
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
	 *
	 */
	private void initTableEntries() {
		setCaptions();
		for (int i = floorNr; i > 0; i--) {
			int floor = i;
			addFloor(floor);
		}

	}

	private void addFloor(int floor){
		add(new JLabel(""+floor));

		JCheckBox elFloor = new JCheckBox();
		elFloor.setEnabled(false);
		elFloor.setName("listInElFloor" + floor);
		listInElFloor.add(0,elFloor);
		add(listInElFloor.get(0));

		JCheckBox floorUp = new JCheckBox();
		floorUp.setEnabled(false);
		floorUp.setName("listOnFloorUp" + floor);
		listOnFloorUp.add(0,floorUp);
		add(listOnFloorUp.get(0));

		JCheckBox floorDown = new JCheckBox();
		floorDown.setEnabled(false);
		floorDown.setName("listOnFloorDown" + floor);
		listOnFloorDown.add(0,floorDown);
		add(listOnFloorDown.get(0));

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

		JRadioButton current = new JRadioButton();
		current.setEnabled(false);
		current.setName("listCurrentFloor" + floor);
		listCurrentFloor.add(0,current);
		add(listCurrentFloor.get(0));
		groupCurrentFloorRBs.add(listCurrentFloor.get(0));
	}

	/**
	 *
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
