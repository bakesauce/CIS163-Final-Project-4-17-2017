package Simulation;

/**
 * Created by Dante on 3/27/17.
 */
public class LimitedTimePerson extends Person {

    /* Override for cashiersTime, stays the same */
    @Override
    public double getCashierTime(){
        return cashiersTime;
    }

    /* Override for leaveTime, reduced by 50%  */
    @Override
    public double getLeaveTime(){
        return leaveTime / 2;
    }

    /* Override for Eaterytime, reduced by 50% */
    @Override
    public double getEateryTime(){
        return eateryTime / 2;
    }
}
