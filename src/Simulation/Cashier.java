package Simulation;

public class Cashier implements ClockListener {

	/* Instance variable for availability */
	boolean availability;

	/* Instance variable for time of the next event */
	private int timeOfNextEvent = 0;

	/* Instance variable that counts the number of completed eaters */
	private int completed = 0;

	/* Instance variable for que length */
	private int currentQLength = 0;

	/* Instance variable for the person*/
	private Person person;

	/* Instance variable for cashier line q */
	private CashierLine cLine;

	/*
	 * Cashier Constructor, initializes cashier line
	 *
	 */
	public Cashier(CashierLine cLine)
	{
		this.cLine = cLine;
	}

	/*
	 * Method that returns the cashier's availability
	 *
	 * @return boolean
	 */
	public boolean isCashierAvaialble()
	{
		return availability;
	}

	/*
	 * Method that handles moving eaters from the cashier line que through the
	 * cashier and out of the sim
	 *
	 * @param tick
	 *
	 * @throws EmptyQException
	 *
	 * (non-Javadoc)
	 *
	 * @see Simulation.ClockListener#event(int)
	 */
	@Override
	public void event(int tick) throws EmptyQException {
		if(tick >= timeOfNextEvent)
		{
			if(cLine.getNumberInCashierLine() >= 1)
			{
				person = cLine.remove();
				timeOfNextEvent = (int) (tick + person.getCashierTime());
				completed++;
			}
		}

	}

	/*
	 * Method that returns the total number of eaters that have completed the
	 * sim
	 *
	 * @returns int
	 */
	public int getThroughPut() {
		return completed;
	}

}
