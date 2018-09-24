/* Test*/
package sample;

import Simulation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class BasicController implements Initializable{

    /* Declaration of instance variables */
    private Clock clk;
    private Eatery[] eateries;
    private Eatery eatery;

    /* Declaring our FXML variables for use with JavaFX */

    @FXML
    private TextField secondsToNext;

    @FXML
    private TextField averageSecondsPerCashier;

    @FXML
    private TextField totalTime;

    @FXML
    private TextField averageSecondsPerEatery;

    @FXML
    private TextField numOfEateries;

    @FXML
    private TextField throughput;

    @FXML
    private TextField averageStartToFinish;

    @FXML
    private TextField throughput1;

    @FXML
    private TextField throughput2;

    @FXML
    private TextField throughput3;

    @FXML
    private TextField throughput4;

    @FXML
    private TextField throughput5;

    @FXML
    private TextField stillInQ1;

    @FXML
    private TextField stillInQ2;

    @FXML
    private TextField stillInQ3;

    @FXML
    private TextField stillInQ4;

    @FXML
    private TextField stillInQ5;

    @FXML
    private TextField maxQLength1;

    @FXML
    private TextField maxQLength2;

    @FXML
    private TextField maxQLength3;

    @FXML
    private TextField maxQLength4;

    @FXML
    private TextField maxQLength5;

    @FXML
    private TextField cashier1Throughput;

    @FXML private TextField cashier2Throughput;

    @FXML
    private TextField numNormalPeople;

    @FXML
    private TextField numSpecialNeeds;

    @FXML
    private TextField numLimitedTime;

    @FXML
    private TextField numTotal;

    @FXML
    private TextField cashierNumInLine;

    private int eateryNum;
    private int cashierNum;
    private int nextPerson;
    private int avgSecondsCashier;
    private int personProduced;
    private int totalTimeSeconds;
    private int averageEateryTime;
    //private int secondsBeforeLeaves;
    private int totalThroughput;
    private int avgTimePerson;

    public void initialize(URL location, ResourceBundle resources){

        eateryNum = 0;
        avgSecondsCashier = 0;
        totalTimeSeconds = 0;
        averageEateryTime = 0;
        personProduced = 0;
        eateryNum = 0;
        cashierNum = 2;
        totalThroughput = 0;
    }

    /* Method that runs the simulation completely */
    @FXML
    public void startSimulation(){
        try{
            totalThroughput = 0;
            /* Initializing the text fields */
            personProduced = (Integer.parseInt(secondsToNext.getText()));
            avgSecondsCashier = (Integer.parseInt(averageSecondsPerCashier.getText()));
            totalTimeSeconds = (Integer.parseInt(totalTime.getText()));
            averageEateryTime = (Integer.parseInt(averageSecondsPerEatery.getText()));
           //secondsBeforeLeaves = (Integer.parseInt(secondsBeforePersonLeaves.getText()));
            eateryNum = (Integer.parseInt(numOfEateries.getText()));

            Clock clk = new Clock();
            CashierLine cLine = new CashierLine();
            Eatery booth[] = new Eatery[eateryNum];
            Cashier cashiers[] = new Cashier[cashierNum];
           
            for(int i = 0; i < eateryNum; i++) {
                booth[i] = new Eatery(cLine);
                clk.add(booth[i]);
            }

            for(int i = 0; i < cashierNum; i++) {
                cashiers[i] = new Cashier(cLine);
                clk.add(cashiers[i]);
            }

            /* Makes a person and starts the clock */
            PersonProducer produce = new PersonProducer(booth, personProduced, averageEateryTime);
            clk.add(produce);
            clk.run(totalTimeSeconds);

            /* Adds stats for each eatery by number
            *  Only able to handle up to 5 eateries,
            *  but could easily make it dynamically
            *  add eateries based on user input */

            for(int i=0; i<eateryNum; i++){
                if(i == 0){
                    throughput1.setText(Integer.toString(booth[i].getThroughPut()));
                    stillInQ1.setText(Integer.toString(booth[i].getLeft()));
                    maxQLength1.setText(Integer.toString(booth[i].getMaxQlength()));

                    totalThroughput += booth[i].getThroughPut();

                }
                else if(i == 1){
                    throughput2.setText(Integer.toString(booth[i].getThroughPut()));
                    stillInQ2.setText(Integer.toString(booth[i].getLeft()));
                    maxQLength2.setText(Integer.toString(booth[i].getMaxQlength()));

                    totalThroughput += booth[i].getThroughPut();

                }
                else if(i == 2){
                    throughput3.setText(Integer.toString(booth[i].getThroughPut()));
                    stillInQ3.setText(Integer.toString(booth[i].getLeft()));
                    maxQLength3.setText(Integer.toString(booth[i].getMaxQlength()));

                    totalThroughput += booth[i].getThroughPut();

                }
                else if(i == 3){
                    throughput4.setText(Integer.toString(booth[i].getThroughPut()));
                    stillInQ4.setText(Integer.toString(booth[i].getLeft()));
                    maxQLength4.setText(Integer.toString(booth[i].getMaxQlength()));

                    totalThroughput += booth[i].getThroughPut();

                }
                else if(i == 4){
                    throughput5.setText(Integer.toString(booth[i].getThroughPut()));
                    stillInQ5.setText(Integer.toString(booth[i].getLeft()));
                    maxQLength5.setText(Integer.toString(booth[i].getMaxQlength()));

                    totalThroughput += booth[i].getThroughPut();
                }
                else{
                    break;
                }
            }

            cashierNumInLine.setText(Integer.toString(cLine.getNumberInCashierLine()));

            /* Adds stats for each of the two cashiers */

            for(int i = 0; i < cashierNum; i++){
                if(i ==0){
                    cashier1Throughput.setText(Integer.toString(cashiers[i].getThroughPut()));
                }
                else if(i == 1){
                    cashier2Throughput.setText(Integer.toString(cashiers[i].getThroughPut()));
                }
                else{
                    break;
                }
            }

            /* Adds final stats */
            avgTimePerson = (produce.getPersons() +
                            produce.getSpecialNeedsPeople() +
                            produce.getLimitedTimePeople());

            numNormalPeople.setText(Integer.toString(produce.getPersons()));
            numSpecialNeeds.setText(Integer.toString(produce.getSpecialNeedsPeople()));
            numLimitedTime.setText(Integer.toString(produce.getLimitedTimePeople()));
            numTotal.setText(Integer.toString(produce.getPersons() +
                                              produce.getSpecialNeedsPeople() +
                                              produce.getLimitedTimePeople()));

            throughput.setText(Integer.toString(totalThroughput));
            averageStartToFinish.setText(Integer.toString(avgTimePerson));


        /* Catch for errors while also channeling our inner emo teenager*/

        } catch (NullPointerException e){
            System.out.println("WAKE ME UP");
            System.out.println("(wake me up inside)");
            System.out.println("(I can't wake up)");
            System.out.println("WAKE ME UP INSIDE");
            System.out.println("SAAAAAAAAVE MEEEEE");
        } catch (EmptyQException e) {
            e.printStackTrace();
        }
    }

    /* Method that allows the quit button to exit the simulation */
    @FXML
    public void quitSimulation(){
        System.exit(0);
    }

    @FXML
    public void secondsToNext(){
        System.out.println("Seconds to next");
    }

    @FXML
    public void averageSecondsPerCashier(){
        System.out.println("Average seconds per cashier");
    }

    @FXML
    public void totalTime(){
        System.out.println("Total time");
    }

    @FXML
    public void averageSecondsPerEatery(){
        System.out.println("Average Seconds per eatery");
    }

    @FXML
    public void secondsBeforePersonLeaves(){
        System.out.println("Seconds before person leaves");
    }

    @FXML
    public void numOfEateries(){
        System.out.println("Number of eateries");
    }

    @FXML
    public void throughput(){
        System.out.println("Throughput");
    }

    @FXML
    public void averageStartToFinish(){
        System.out.println("Average Start to Finish");
    }

    @FXML
    public void numPeopleLeftInLine(){
        System.out.println("People left in line");
    }

    @FXML
    public void maxQLength(){
        System.out.println("Max Q Length");
    }

}
