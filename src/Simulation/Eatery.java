package Simulation;
/**
 * @author   Mark Baker, Kevin, Dante
 */
public class Eatery implements ClockListener {

	/* Instance variable that creates a separate que for each eatery */
	private Quene<Person> eateryQ = new Quene<Person>();

	/* Instance variable for time of the next event */
	private int timeOfNextEvent = 0;

	/*
	 * Instance variable that counts the overall maximum que length in one
	 * moment
	 */
	private int maxQlength = 0;

	/* Instance variable for current person at front of que */
	private Person person; // this is the person at the Eatery.

	/*
	 * Instance variable that counts the number of people that move through this
	 * eatery
	 */
	private int completed = 0;

	/* Instance variable for the cashier queue */
	private CashierLine cLine;

	/*
	 * Constructor for the Eatery, sets the cashier queue
	 *
	 * @param CashierLine
	 */
	public Eatery(CashierLine cLine)
	{
		this.cLine = cLine;
	}

	/*
	 * Method that adds a person to the back of the que and edits that max q length
	 *
	 * @param Person
	 */
	public void add (Person person)
	{
		eateryQ.enQ(person);
		if (eateryQ.size() > maxQlength)
			maxQlength = eateryQ.size();
	}

	/*
	 * Method that handles the event of moving people through the que
	 *
	 * @param tick
	 *
	 * @throws EmptyQException
	 *
	 * (non-Javadoc)
	 *
	 * @see Simulation.ClockListener#event(int)
	 */
	public void event (int tick) throws EmptyQException{
		if (tick >= timeOfNextEvent) {
//			if (person != null) { 			// Notice the delay that takes place here
//				person.getDestination().add(person);    // take this person to the next station.
//			person = null;				// I have send the person on.
//			}

			if (eateryQ.size() >= 1) {
				person = eateryQ.deQ();		// do not send this person as of yet, make them wait.
				cLine.add(person);
				timeOfNextEvent = tick + (int) (person.getEateryTime() + 1);
				completed++;
			}
		}
	}

	/*
	 * Method that returns the current size of the que
	 *
	 * @returns int
	 */
	public int getLeft() {
		return eateryQ.size();
	}

	/*
	 * Method that returns the overall maximum length the que was at a single
	 * moment
	 *
	 * @returns int
	 */
	public int getMaxQlength() {
		return maxQlength;
	}

	/*
	 * Method that returns the number people who have moved through this que
	 *
	 * @returns int
	 */
	public int getThroughPut() {
		return completed;
	}
}
