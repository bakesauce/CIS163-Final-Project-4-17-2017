package Simulation;

import java.util.Random;

/**
 * @author Roger Ferguson
 */

public class PersonProducer implements ClockListener {

	/* Instance variable for nextPerson */
	private int nextPerson = 0;

	/* instance variable for personType */
	private int personType = 0;

	/* Instance variable for the eatery array */
	private Eatery[] eatery;

	/* Instance variable for number for seconds till the next person produced */
	private int numOfTicksNextPerson;

	/* Instance variable for averay eatery time */
	private int averageEateryTime;

	/* Instance variable for the eatery destination */
	private int destination;

	/* Instance variable for number of special needs people in sim */
	private int numberSpecialNeeds;

	/* Instance variable for number of limited time people in sim */
	private int numberLimitedTime;

	/* Instance variable for number of total people in sim */
	private int numberPersons;

	/* Instance variable for random number generator */
	private Random r = new Random();

	/*
	 * Person producer constructor, sets instance variables
	 *
	 * @param Eatery[]
	 * @param int
	 * @param int
	 */
	public PersonProducer(Eatery[] eatery, int numOfTicksNextPerson, int averageEateryTime) {
		//Sets the eatery to array of possible eaterys
		this.eatery = eatery;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}

	/*
	 * Event handler method, controls the person producer.
	 *
	 * Controls what kind of person is produced and what eatery they go to
	 *
	 * @param int
	 */
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = tick + numOfTicksNextPerson;

			personType = r.nextInt(10);
			Person person;

			switch(personType)
			{
				case 0:
					person = new SpecialNeedsPerson();
					numberSpecialNeeds++;
					break;
				case 1:
					person = new LimitedTimePerson();
					numberLimitedTime++;
					break;
				case 2:
					person = new LimitedTimePerson();
					numberLimitedTime++;
					break;
				default:
					person = new Person();
					numberPersons++;
					break;
			}

			person.setEateryTime(averageEateryTime*0.5*r.nextGaussian() + averageEateryTime +.5);
			person.setTickTime(tick);

			/*Adds the person to a random eatery*/
			destination = r.nextInt(eatery.length);

			eatery[destination].add(person);

			//	person.setDestination(theLocationAfterTheEatery);  // You can save off where the person should go.
		}

	}

	/*
	 * Getter method that returns the number of special needs people in the sim
	 *
	 * @returns int
	 */
	public int getSpecialNeedsPeople()
	{
		return numberSpecialNeeds;
	}

	/*
	 * Getter method that returns the number of limited time people in the sim
	 *
	 * @returns int
	 */
	public int getLimitedTimePeople()
	{
		return numberLimitedTime;
	}

	/*
	 * Getter method that returns the total number of people in the sim
	 *
	 * @returns int
	 */
	public int getPersons()
	{
		return numberPersons;
	}

}
