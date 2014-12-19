/**
 *
 */
package at.fhooe.mc.view;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sqelevator.IElevator;
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
		} catch (NullPointerException | MalformedURLException | RemoteException
				| NotBoundException e) {
			// TODO: show error message as dialog!
			e.printStackTrace();
		}

		tableViewControlPanel = new TableViewControlPanel(adapter);
		elevatorAttributesPanel = new ElevatorAttributesPanel();
		elevatorViewPanel = new ElevatorViewPanel();

		flowLayout.add(tableViewControlPanel);
		flowLayout.add(elevatorViewPanel);
		flowLayout.add(elevatorAttributesPanel);
		this.add(flowLayout);

		elevatorUpdater = new ElevatorUpdater(adapter);
		elevatorUpdater.addObserver(elevatorAttributesPanel);
		elevatorUpdater.addObserver(elevatorViewPanel);
		elevatorUpdater.addObserver(tableViewControlPanel);

		new Thread(elevatorUpdater).start();
	}

	public static void main(String[] args) {
		new ElevatorControllerGUI();
	}

}
