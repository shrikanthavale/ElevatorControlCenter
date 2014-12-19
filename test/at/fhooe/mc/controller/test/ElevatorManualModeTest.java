/**
 * 
 */
package at.fhooe.mc.controller.test;

import java.util.Observable;
import java.util.Observer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhooe.mc.controller.ElevatorAdapter;
import at.fhooe.mc.controller.ElevatorController;
import at.fhooe.mc.controller.ElevatorUpdater;
import at.fhooe.mc.controller.IElevatorControls;

/**
 * @author Metrics_Testing Team Dec 17, 2014
 * 
 */
public class ElevatorManualModeTest implements Observer {

	/**
	 * Elevator Adapter
	 */
	private static IElevatorControls iElevatorControls;

	/**
	 * Elevator Controller
	 */
	private static ElevatorController elevatorController;

	/**
	 * Elevator Updater
	 */
	private static ElevatorUpdater elevatorUpdater;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		iElevatorControls = new ElevatorAdapter();
		iElevatorControls.setiElevatorReference(new ElevatorMock());
		elevatorController = new ElevatorController(iElevatorControls);
		elevatorUpdater = new ElevatorUpdater(iElevatorControls);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		elevatorUpdater.addObserver(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		elevatorUpdater.deleteObserver(this);
	}

	/**
	 * Test method for
	 * {@link at.fhooe.mc.model.Elevator#getCommittedDirection(int)}.
	 */
	@Test
	public final void testElevatorManualOperation() {

		// go to floor number 4 , for example
		elevatorController.setTarget(4);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
