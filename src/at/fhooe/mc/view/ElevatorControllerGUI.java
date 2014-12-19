/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	public ElevatorControllerGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	}

	public static void main(String[] args) {
		new ElevatorControllerGUI();
	}

}
