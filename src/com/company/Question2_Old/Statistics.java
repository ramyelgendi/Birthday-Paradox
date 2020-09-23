package com.company.Question2_Old;

/**
 * Created by ibrahimroshdy on 9/23/17.
 */

import java.util.Stack;
import java.text.DecimalFormat;


/**
 * The class Statistics accumulates the results of
 * the experiments. It knows ahead of time how many experiments
 * will be run, and provides at the end the min, the max, the
 * average and the standard deviation for the data. *
 * This class should not use classes such as Array,
 * Lists etc. to store the data, only primitive types
 * and java arrays. *
 *
 */

public class Statistics {

    // ADD HERE INSTANCE VARIABLES DECLARATION

     private Stack<Integer> counterRes;
     private int numberOfRuns;
     private int counter;
     public int min, max;



    // The numberOfRuns the number of experiments that will be run

    public Statistics(int numberOfRuns){
    // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
       // Statistics statistics = new Statistics(6);
        counterRes = new Stack<>();
       // counterRes.setSize(numberOfRuns);
        this.numberOfRuns = numberOfRuns;
        this.counter = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }
    /* Updates statistics after one experiment.
    This method cannot be called more times than
    the parameter that was passed in the constructor.
    If it is, an error message should be printed and no change should occur.
    The param value the result returned from a new experiment
    */

    public void updateStatistics(int value) {
    // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        if(counter<numberOfRuns){
            counter++;
            counterRes.push(value);
        }else System.out.println("No Update Must Occur");

    }

    /* The function returns the current average of the
        values passed to the method updateStatistic
    */
    public double average() {
    /* The function returns the current standard deviation of
        the values passed to the method updateStatistic*/
        double sum = 0;


        Stack<Integer> temp = (Stack<Integer>) counterRes.clone();

        for(int i=0;i<numberOfRuns;i++) {
            if(temp.peek() < min )
                min = temp.peek();
            if(temp.peek() > max)
                max = temp.peek();
            sum += temp.pop();

        }
        return sum/numberOfRuns;
    }

    public double standardDeviation() {

        double sd = 0;
        Stack<Integer> temp2 = (Stack<Integer>) counterRes.clone();

        for (int i = 0; i <numberOfRuns; i++) {
            sd += Math.pow(temp2.pop() - average(),2);
        }

        double standardDeviation = Math.sqrt(sd/numberOfRuns);

        return standardDeviation;
    }

    /* this function returns the complete statistics information:
    current minimum, maximum, average, and stdev. For the last two, only two digit decimals are printed.
     The toString function will define how an object will be printed out if you use something
     like System.out.println(objectName). It simply returns a string back describing the text that will be printed out.
    */
    public String toString() {

        String output;

        DecimalFormat decimalFormat = new DecimalFormat(".##"); //for 2 decimal points only

        output= String.format(" The mean was: " + decimalFormat.format(average())+
                "%n"+" The standard deviation was: " + decimalFormat.format(standardDeviation())+
                "%n"+" The minimum was: " + min +
                "%n"+" The maximum was: " + max);

        return output;


    }
}
