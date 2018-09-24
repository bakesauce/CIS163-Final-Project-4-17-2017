/**
 *
 */
package Simulation;


/**
 * @author   Roger Ferguson
 */
public class Person {

	/* Instance variable for the specific tick Time for this person */
	private int tickTime;

	/* Instance variable for the eatery destination of this person */
	private Eatery Destination;

	/*
	 * Instance variable for time in seconds this person will spend at the
	 * cashier
	 */
	protected double cashiersTime;

	/*
	 * Instance variable for total time this person will stay in the sim before
	 * they leave
	 */
	protected double leaveTime;

	/* Instance variable for the time this person will spend at the eatery */
	protected double eateryTime;

	/*
	 * Constructor for this person, initializes instance variables for the
	 * console sim
	 */
	public Person()
	{
		cashiersTime = 18;
		leaveTime = 900;
	}
	/*
	 * Getter for the persons eatery time
	 *
	 * @returns double
	 */
	public double getEateryTime() {
		return eateryTime;
	}

	/*
	 * Getter method for the persons eatery destination
	 *
	 * @returns Eatery
	 */
	public Eatery getDestination() {
		return Destination;
	}

	/*
	 * Setter method that sets the persons destination
	 *
	 * @param Eatery
	 */
	public void setDestination(Eatery destination) {
		Destination = destination;
	}

	/*
	 * Getter method for the persons tick time
	 *
	 * @returns int
	 */
	public int getTickTime() {
		return tickTime;
	}

	/*
	 * Setter method that sets the persons tick time
	 *
	 * @param int
	 */
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	/*
	 * Setter method that sets the persons eatery time
	 *
	 * @param double
	 */
	public void setEateryTime(double time) {
		this.eateryTime = time;
	}

	/*
	 * Getter method for the persons cashier time
	 *
	 * @returns double
	 */
	public double getCashierTime() {
		return cashiersTime;
	}

	/*
	 * Getter method for the persons leave time
	 *
	 * @returns double
	 */
	public double getLeaveTime() {
		return leaveTime;
	}

}
