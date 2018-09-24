/**
 *
 */
package Simulation;

/**
 * @author Roger Ferguson
 *
 */
public class Sim {

	/*
	 * Main method for the sim
	 *
	 * @throws EmptyQException
	 */
	public static void main(String[] args) throws EmptyQException {

		/* Instance variable for number of eaterys for console sim */
		int eateryNum = 5;

		/* Instance variable for number of cashiers for console sim */
		int cashierNum = 2;

		/* Instance variable for person producer x seconds number*/
		int personProduced = 20;

		/* Instance variable for number for average eatery time for console sim */
		int averageEateryTime = 60;

		/* Instance variable for the cashier Q */
		CashierLine cLine = new CashierLine();

		/* Instance variable for creating a clock object*/
		Clock clk = new Clock();

		/* Instance variable for creating an array that holds all of the eaterys */
		Eatery eateries[] = new Eatery[eateryNum];

		/* Instance variable for creating an array that holds all of the cashiers */
		Cashier cashiers[] = new Cashier[cashierNum];

		// for loop that creates eatery objects and adds them to the eatery array based
		// on instance variable for number of eaterys
		for (int i = 0; i < eateryNum; i++) {
			eateries[i] = new Eatery(cLine);
			clk.add(eateries[i]);
		}

		// for loop that creates cashier objects and adds them to the cashier array based
		// on instance variable for number of cashiers
		for (int i = 0; i < cashierNum; i++) {
			cashiers[i] = new Cashier(cLine);
			clk.add(cashiers[i]);
		}

		// creates a new personproducer object and adds it to the clock
		PersonProducer produce = new PersonProducer(eateries, personProduced, averageEateryTime);
		clk.add(produce);

		//runs the sim based on a total time of 10000 seconds
		clk.run(10000);

		//prints results
		for (int i = 0; i < eateryNum; i++) {
			System.out.println("Eatery Number " + (i + 1));
			System.out.println("Through put is: " + eateries[i].getThroughPut() + " people.");
			System.out.println("People that are still in the Q: " + eateries[i].getLeft() + " people.");
			System.out.println("Max Q length: " + eateries[i].getMaxQlength() + " people.");
		}

		System.out.println();
		System.out.println("Cashier Stats");

		System.out.println("People waiting for Cashier: " + cLine.getNumberInCashierLine());

		for (int i = 0; i < cashierNum; i++) {
			System.out.println("Cashier Number " + (i + 1));
			System.out.println("Through put of Cashier is: " + cashiers[i].getThroughPut());
		}

		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println("Number of Special Needs People Produced: " + produce.getSpecialNeedsPeople());
		System.out.println("Number of Limited Time People Produced: " + produce.getLimitedTimePeople());
		System.out.println("Number of Generic Persons: " + produce.getPersons());
		System.out.println("Total Number of Persons Generated: "
				+ (produce.getLimitedTimePeople() + produce.getSpecialNeedsPeople() + produce.getPersons()));
	}
}
