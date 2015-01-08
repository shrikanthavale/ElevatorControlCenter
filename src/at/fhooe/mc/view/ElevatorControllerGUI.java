/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sqelevator.IElevator;
import at.fhooe.mc.controller.ElevatorAdapter;
import at.fhooe.mc.controller.ElevatorController;
import at.fhooe.mc.controller.ElevatorUpdater;
import at.fhooe.mc.model.ElevatorMock;

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
	private JPanel flowLayout;
	private static ElevatorUpdater elevatorUpdater;

	public ElevatorControllerGUI() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		ElevatorAdapter adapter = new ElevatorAdapter();

		try {
			adapter.setiElevatorReference((IElevator) Naming.lookup("rmi://localhost/ElevatorSim"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Simulator not running");
			adapter.setiElevatorReference(new ElevatorMock());
		}
		ElevatorController controller = new ElevatorController(adapter);
		int floorNr = 4;
		try{
			floorNr = adapter.getFloorNum();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "FloorNr could not be get, use 4 as standard");
		}

		tableViewControlPanel = new TableViewControlPanel(controller, floorNr);
		elevatorAttributesPanel = new ElevatorAttributesPanel(controller, tableViewControlPanel);

		flowLayout.add(tableViewControlPanel);
		flowLayout.add(elevatorAttributesPanel);
		this.add(flowLayout);

		elevatorUpdater = new ElevatorUpdater(adapter);
		elevatorUpdater.addObserver(elevatorAttributesPanel);
		elevatorUpdater.addObserver(tableViewControlPanel);
		elevatorUpdater.addObserver(controller);

		new Thread(elevatorUpdater).start();
	}

	public static void main(String[] args) {
		new ElevatorControllerGUI();
	}

}
