package Simulation;


public class CashierLine{

	/* Instance variable that initializes cashier queue */
	public Quene<Person> cashierQ = new Quene<Person>();

	/*
	 * Constructor
	 */
	public CashierLine() {

	}

	/*
	 * Gets the current number of people in the queue
	 *
	 * @returns int
	 */
	public int getNumberInCashierLine() {
		return cashierQ.size();
	}

	/*
	 * Method that resets the size of the queue
	 */
	public void reset(){
		cashierQ = new Quene<>();
	}

	/*
	 * Method that adds someone to the queue
	 *
	 * @param Person
	 */
	public void add(Person person) {
		this.cashierQ.enQ(person);

	}

	/*
	 * Method that removes someone from the queue and returns that person
	 *
	 * @returns Person
	 * @throws EmptyQException
	 */
	public Person remove() throws EmptyQException {

		Person person = cashierQ.deQ();

		return person;
	}
}
