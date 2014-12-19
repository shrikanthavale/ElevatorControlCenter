/**
 *
 */
package at.fhooe.mc.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

//import at.fhooe.mc.model.Elevator;

/**
 * @author Viktor Baier S1310455001
 */
public class ElevatorViewPanel extends JPanel implements Observer {

	public ElevatorViewPanel() {
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -5803158051170982919L;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object _object) {
//		if (_object instanceof Elevator) {
//			Elevator elevator = (Elevator) _object;
//		}

	}

}
