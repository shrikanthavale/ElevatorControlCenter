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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import at.fhooe.mc.model.Elevator;

/**
 * @author Viktor Baier S1310455001
 */
public class TableViewControlPanel extends JPanel implements Observer {

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
	private JRadioButton currrentFloor1RB, currrentFloor2RB, currrentFloor3RB,
			currrentFloor4RB;
	private ButtonGroup groupTargetRBs, groupCurrentFloorRBs;

	/**
	 *
	 */
	public TableViewControlPanel() {
		super.setLayout(new GridLayout(5, 6));
		this.setSize(400, 300);
		initTableEntries();
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

			initRow(inElFloor1CB, onFlFloor1UpCB, onFlFloor1DownCB,
					targetFloor1RB, currrentFloor1RB, floor);

			break;
		case 2:
			initRow(inElFloor2CB, onFlFloor2UpCB, onFlFloor2DownCB,
					targetFloor2RB, currrentFloor2RB, floor);

			break;
		case 3:
			initRow(inElFloor3CB, onFlFloor3UpCB, onFlFloor3DownCB,
					targetFloor3RB, currrentFloor3RB, floor);

			break;
		case 4:
			initRow(inElFloor4CB, onFlFloor4UpCB, onFlFloor4DownCB,
					targetFloor4RB, currrentFloor4RB, floor);

			break;
		}
	}

	/**
	 * @param _inElFloorCB
	 * @param _onFlFloorUpCB
	 * @param _onFlFloorDownCB
	 * @param _targetFloorRB
	 * @param _currrentFloorRB
	 * @param _floor
	 */
	private void initRow(JCheckBox _inElFloorCB, JCheckBox _onFlFloorUpCB,
			JCheckBox _onFlFloorDownCB, JRadioButton _targetFloorRB,
			JRadioButton _currrentFloorRB, int _floor) {
		add(new JLabel(String.valueOf(_floor)));
		_inElFloorCB = new JCheckBox();
		_onFlFloorUpCB = new JCheckBox();
		_onFlFloorDownCB = new JCheckBox();
		_targetFloorRB = new JRadioButton();
		_currrentFloorRB = new JRadioButton();

		groupTargetRBs.add(_targetFloorRB);
		groupCurrentFloorRBs.add(_currrentFloorRB);

		_inElFloorCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		_onFlFloorUpCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		_onFlFloorDownCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		_targetFloorRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		add(_inElFloorCB);
		add(_onFlFloorUpCB);
		add(_onFlFloorDownCB);
		add(_targetFloorRB);
		add(_currrentFloorRB);

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
		}
	}

}
