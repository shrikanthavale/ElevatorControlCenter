/**
 *
 */
package at.fhooe.mc.model;

/**
 * @author Metrics_Testing Team
 * Dec 18, 2014
 *
 */
public class Elevator {

	/**
	 * Current direction of the elevator
	 */
	private int currentDirection;

	/**
	 * door status of elevator (like opening, closing, closed , open)
	 */
	private int doorStatus;

	/**
	 * position of the elevator
	 */
	private int position;

	/**
	 * speed of the elevator in feet per second
	 */
	private int speed;

	/**
	 * total weight of persons in the weight
	 */
	private int weight;

	/**
	 * number of persons that can fit in elevator
	 */
	private int capacity;

	/**
	 * boolean status of all the buttons pressed inside elevator
	 */
	private boolean[] pressedButtonsElevator;

	/**
	 * boolean status of the Down button pressed on all the floors
	 */
	private boolean[]pressedButtonsFloorDown;

	/**
	 * boolean status of the Up button pressed on all the floors
	 */
	 private boolean[] pressedButtonsFloorUp;

	 /**
	  * elevator target
	  */
	 private int target;
	 
	/**
	 * @return the currentDirection
	 */
	public int getCurrentDirection() {
		return currentDirection;
	}

	/**
	 * @param currentDirection the currentDirection to set
	 */
	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	/**
	 * @return the doorStatus
	 */
	public int getDoorStatus() {
		return doorStatus;
	}

	/**
	 * @param doorStatus the doorStatus to set
	 */
	public void setDoorStatus(int doorStatus) {
		this.doorStatus = doorStatus;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the pressedButtonsElevator
	 */
	public boolean[] getPressedButtonsElevator() {
		return pressedButtonsElevator;
	}

	/**
	 * @param pressedButtonsElevator the pressedButtonsElevator to set
	 */
	public void setPressedButtonsElevator(boolean[] pressedButtonsElevator) {
		this.pressedButtonsElevator = new boolean[pressedButtonsElevator.length];
		for (int i = 0; i < pressedButtonsElevator.length; i++){
			this.pressedButtonsElevator[i] = pressedButtonsElevator[i];
		}
	}

	/**
	 * @return the pressedButtonsFloorDown
	 */
	public boolean[] getPressedButtonsFloorDown() {
		return pressedButtonsFloorDown;
	}

	/**
	 * @param pressedButtonsFloorDown the pressedButtonsFloorDown to set
	 */
	public void setPressedButtonsFloorDown(boolean[] pressedButtonsFloorDown) {
		this.pressedButtonsFloorDown = new boolean[pressedButtonsFloorDown.length];
		for (int i = 0; i < pressedButtonsFloorDown.length; i++){
			this.pressedButtonsFloorDown[i] = pressedButtonsFloorDown[i];
		}
	}

	/**
	 * @return the pressedButtonsFloorUp
	 */
	public boolean[] getPressedButtonsFloorUp() {
		return pressedButtonsFloorUp;
	}

	/**
	 * @param pressedButtonsFloorUp the pressedButtonsFloorUp to set
	 */
	public void setPressedButtonsFloorUp(boolean[] pressedButtonsFloorUp) {
		this.pressedButtonsFloorUp = new boolean[pressedButtonsFloorUp.length];
		for (int i = 0; i < pressedButtonsFloorUp.length; i++){
			this.pressedButtonsFloorUp[i] = pressedButtonsFloorUp[i];
		}
	}

	/**
	 * @return the target
	 */
	public int getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(int target) {
		this.target = target;
	}


}
