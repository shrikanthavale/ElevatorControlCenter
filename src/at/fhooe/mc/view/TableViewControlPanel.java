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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import at.fhooe.mc.controller.ElevatorAdapter;
import at.fhooe.mc.controller.ElevatorController;
import at.fhooe.mc.model.Elevator;

/**
 * @author Viktor Baier S1310455001
 */
public class TableViewControlPanel extends JPanel implements Observer, ActionListener {

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
//	private static final String TARGET = "Target";

	private JCheckBox inElFloor1CB, inElFloor2CB, inElFloor3CB, inElFloor4CB;
	private JCheckBox onFlFloor1UpCB, onFlFloor2UpCB, onFlFloor3UpCB,
			onFlFloor4UpCB;
	private JCheckBox onFlFloor4DownCB, onFlFloor3DownCB,
			onFlFloor2DownCB, onFlFloor1DownCB;
	private JRadioButton targetFloor1RB, targetFloor2RB, targetFloor3RB,
			targetFloor4RB;
	private JRadioButton currentFloor1RB, currentFloor2RB, currentFloor3RB,
			currentFloor4RB;
	private ButtonGroup groupTargetRBs, groupCurrentFloorRBs;

	private ElevatorController elevatorController;

	/**
	 *
	 */
	public TableViewControlPanel(ElevatorAdapter _adapter) {
		super.setLayout(new GridLayout(5, 6));
		this.setSize(400, 300);
		initTableEntries();
		elevatorController = new ElevatorController(_adapter);
	}

	/**
	 *
	 */
	private void initTableEntries() {
		setCaptions();
		groupTargetRBs = new ButtonGroup();
		groupCurrentFloorRBs = new ButtonGroup();
		for (int i = 0; i < 4; i++) {
			int floor = i + 1;
			addFloor(floor);
		}

	}

	/**
	 * @param i
	 */
	private void addFloor(int floor) {

		switch (floor) {

		case 1:
			add(new JLabel(""+floor));

			inElFloor1CB = new JCheckBox();
			inElFloor1CB.setEnabled(false);
			add(inElFloor1CB);

			onFlFloor1UpCB = new JCheckBox();
			onFlFloor1UpCB.setEnabled(false);
			add(onFlFloor1UpCB);

			onFlFloor1DownCB = new JCheckBox();
			onFlFloor1DownCB.setEnabled(false);
			add(onFlFloor1DownCB);

			targetFloor1RB = new JRadioButton();
			targetFloor1RB.setActionCommand("targetFloor1");
			targetFloor1RB.addActionListener(this);
			add(targetFloor1RB);
			groupTargetRBs.add(targetFloor1RB);

			currentFloor1RB = new JRadioButton();
			currentFloor1RB.setEnabled(false);
			add(currentFloor1RB);
			groupCurrentFloorRBs.add(currentFloor1RB);

			break;
		case 2:
			add(new JLabel(""+floor));

			inElFloor2CB = new JCheckBox();
			inElFloor2CB.setEnabled(false);
			add(inElFloor2CB);

			onFlFloor2UpCB = new JCheckBox();
			onFlFloor2UpCB.setEnabled(false);
			add(onFlFloor2UpCB);

			onFlFloor2DownCB = new JCheckBox();
			onFlFloor2DownCB.setEnabled(false);
			add(onFlFloor2DownCB);

			targetFloor2RB = new JRadioButton();
			targetFloor1RB.setActionCommand("targetFloor2");
			targetFloor2RB.addActionListener(this);
			add(targetFloor2RB);
			groupTargetRBs.add(targetFloor2RB);

			currentFloor2RB = new JRadioButton();
			currentFloor2RB.setEnabled(false);
			add(currentFloor2RB);
			groupCurrentFloorRBs.add(currentFloor2RB);

			break;
		case 3:
			add(new JLabel(""+floor));

			inElFloor3CB = new JCheckBox();
			inElFloor3CB.setEnabled(false);
			add(inElFloor3CB);

			onFlFloor3UpCB = new JCheckBox();
			onFlFloor3UpCB.setEnabled(false);
			add(onFlFloor3UpCB);

			onFlFloor3DownCB = new JCheckBox();
			onFlFloor3DownCB.setEnabled(false);
			add(onFlFloor3DownCB);

			targetFloor3RB = new JRadioButton();
			targetFloor1RB.setActionCommand("targetFloor3");
			targetFloor3RB.addActionListener(this);
			add(targetFloor3RB);
			groupTargetRBs.add(targetFloor3RB);

			currentFloor3RB = new JRadioButton();
			currentFloor3RB.setEnabled(false);
			add(currentFloor3RB);
			groupCurrentFloorRBs.add(currentFloor3RB);

			break;
		case 4:
			add(new JLabel(""+floor));

			inElFloor4CB = new JCheckBox();
			inElFloor4CB.setEnabled(false);
			add(inElFloor4CB);

			onFlFloor4UpCB = new JCheckBox();
			onFlFloor4UpCB.setEnabled(false);
			add(onFlFloor4UpCB);

			onFlFloor4DownCB = new JCheckBox();
			onFlFloor4DownCB.setEnabled(false);
			add(onFlFloor4DownCB);

			targetFloor4RB = new JRadioButton();
			targetFloor1RB.setActionCommand("targetFloor4");
			targetFloor4RB.addActionListener(this);
			add(targetFloor4RB);
			groupTargetRBs.add(targetFloor4RB);

			currentFloor4RB = new JRadioButton();
			currentFloor4RB.setEnabled(false);
			add(currentFloor4RB);
			groupCurrentFloorRBs.add(currentFloor4RB);

			break;
		}
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
			Elevator elevator = (Elevator) _object;

			inElFloor1CB.setSelected(elevator.getPressedButtonsElevator()[0]);
			inElFloor2CB.setSelected(elevator.getPressedButtonsElevator()[1]);
			inElFloor3CB.setSelected(elevator.getPressedButtonsElevator()[2]);
			inElFloor4CB.setSelected(elevator.getPressedButtonsElevator()[3]);

			onFlFloor1UpCB.setSelected(elevator.getPressedButtonsFloorUp()[0]);
			onFlFloor2UpCB.setSelected(elevator.getPressedButtonsFloorUp()[1]);
			onFlFloor3UpCB.setSelected(elevator.getPressedButtonsFloorUp()[2]);
			onFlFloor4UpCB.setSelected(elevator.getPressedButtonsFloorUp()[3]);

			onFlFloor1DownCB.setSelected(elevator.getPressedButtonsFloorDown()[0]);
			onFlFloor2DownCB.setSelected(elevator.getPressedButtonsFloorDown()[1]);
			onFlFloor3DownCB.setSelected(elevator.getPressedButtonsFloorDown()[2]);
			onFlFloor4DownCB.setSelected(elevator.getPressedButtonsFloorDown()[3]);

			switch(elevator.getPosition()){
			case 1:
				currentFloor1RB.setSelected(true);
				break;
			case 2:
				currentFloor2RB.setSelected(true);
				break;
			case 3:
				currentFloor3RB.setSelected(true);
				break;
			case 4:
				currentFloor4RB.setSelected(true);
				break;
			default:
				currentFloor1RB.setSelected(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Elevator was null");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButton){
			JRadioButton button = (JRadioButton) e.getSource();

			if (button.isSelected()){
		        if (button.equals(targetFloor1RB))
		        	elevatorController.setTarget(1);
		        if (button.equals(targetFloor2RB))
		        	elevatorController.setTarget(2);
		        if (button.equals(targetFloor3RB))
		        	elevatorController.setTarget(3);
				if (button.equals(targetFloor4RB))
					elevatorController.setTarget(4);
			}

		}
	}

}
