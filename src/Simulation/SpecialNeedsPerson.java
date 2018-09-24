package Simulation;

/**
 * Created by Dante on 3/27/17.
 */
public class SpecialNeedsPerson extends Person {

    /* Override for cashiersTime, doubles */
    @Override
    public double getCashierTime(){
        return cashiersTime * 2;
    }

    /* Override for leaveTime, triples */
    @Override
    public double getLeaveTime(){
        return leaveTime * 3;
    }

    /* Override for eateryTime, quadruples */
    @Override
    public double getEateryTime(){
        return eateryTime * 4;
    }
}
