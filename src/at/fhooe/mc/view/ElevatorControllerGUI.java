/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import at.fhooe.mc.controller.ElevatorAdapter;
import at.fhooe.mc.controller.ElevatorUpdater;
import at.fhooe.mc.controller.test.ElevatorMock;

/**
 * @author Viktor Baier S1310455001
 */
public class ElevatorControllerGUI extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 6783651316064353006L;
	private TableViewControlPanel tableViewControlPanel;
	private ElevatorAttributesPanel elevatorAttributesPanel;
	private ElevatorViewPanel elevatorViewPanel;
	private JPanel flowLayout;
	private ElevatorUpdater elevatorUpdater;

	public ElevatorControllerGUI() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we) {
				elevatorUpdater.setLooping(false);
				System.exit(0);
			}
		});
		this.setSize(1200, 800);
		this.setTitle("Elevator Control");
		initPanels();

		this.setVisible(true);
	}

	/**
	 *
	 */
	private void initPanels() {
		flowLayout = new JPanel(new GridLayout(2, 2));

		tableViewControlPanel = new TableViewControlPanel();
		elevatorAttributesPanel = new ElevatorAttributesPanel();
		elevatorViewPanel = new ElevatorViewPanel();

		flowLayout.add(tableViewControlPanel);
		flowLayout.add(elevatorViewPanel);
		flowLayout.add(elevatorAttributesPanel);
		this.add(flowLayout);

		ElevatorAdapter adapter = new ElevatorAdapter();
		adapter.setiElevatorReference(new ElevatorMock());
		elevatorUpdater = new ElevatorUpdater(adapter);
		elevatorUpdater.addObserver(elevatorAttributesPanel);
		elevatorUpdater.addObserver(elevatorViewPanel);
		elevatorUpdater.addObserver(tableViewControlPanel);
		elevatorUpdater.run();
	}

	public static void main(String[] args) {
		new ElevatorControllerGUI();
	}

}
