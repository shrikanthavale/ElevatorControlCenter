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
 * This is starting point of the application and extends {@link JFrame} initialize two panels Attribute Panel
 * Table View Panel showing Elevator numbers control panels with floor details.
 * 
 * @author Metrics_Testing Team
 */
public class ElevatorControllerGUI extends JFrame {
	
	/**
	 * generated serial versio id
	 */
	private static final long serialVersionUID = 6783651316064353006L;
	
	/**
	 * table view control panel - showing floor details and controls for selecting them
	 */
	private TableViewControlPanel tableViewControlPanel;
	
	/**
	 * Elevator attributes panel - representing different attributes of elevator taken from mock or simulator
	 */
	private ElevatorAttributesPanel elevatorAttributesPanel;
	
	/**
	 * panel for storing both panels
	 */
	private JPanel flowLayout;
	
	/**
	 * elevator updater - observable from where data for UI is fetched.
	 */
	private static ElevatorUpdater elevatorUpdater;

	/**
	 * Constructor initializing the frame.
	 */
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
	 *initialize both the panels
	 */
	private void initPanels() {
		// initialize the panel
		flowLayout = new JPanel(new GridLayout(2, 2));

		// use the adapter
		ElevatorAdapter adapter = new ElevatorAdapter();

		// try to get RMI service of Elevetor Simulator
		try {
			adapter.setiElevatorReference((IElevator) Naming.lookup("rmi://localhost/ElevatorSim"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Simulator not running so the Mock Element is used instead");
			adapter.setiElevatorReference(new ElevatorMock());
		}
		
		// use controller
		ElevatorController controller = new ElevatorController(adapter);
		int floorNr = 4;
		
		// dynamically set the floor numbers
		try{
			floorNr = adapter.getFloorNum();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "FloorNr could not be get, use 4 as standard");
		}

		// two view panels
		tableViewControlPanel = new TableViewControlPanel(controller, floorNr);
		elevatorAttributesPanel = new ElevatorAttributesPanel(controller, tableViewControlPanel);

		flowLayout.add(tableViewControlPanel);
		flowLayout.add(elevatorAttributesPanel);
		this.add(flowLayout);

		// observable initialized 
		elevatorUpdater = new ElevatorUpdater(adapter);
		elevatorUpdater.addObserver(elevatorAttributesPanel);
		elevatorUpdater.addObserver(tableViewControlPanel);
		elevatorUpdater.addObserver(controller);

		// start the thread
		new Thread(elevatorUpdater).start();
	}

	/**
	 * starting point of the application 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ElevatorControllerGUI();
	}

}
