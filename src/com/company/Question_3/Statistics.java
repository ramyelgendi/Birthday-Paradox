package com.company.Question_3;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
    //private Stack<Integer> Stack;
    private int numberOfRuns,Counter;
    private ArrayList<Integer> List;
    public int Minimum,Maxmimum;

// The numberOfRuns the number of experiments that will be run
    public Statistics(int numberOfRuns){    // Initializing
        List = new ArrayList<>();
        this.numberOfRuns=numberOfRuns;
        this.Counter=0;
        this.Maxmimum = Integer.MIN_VALUE;
        this.Minimum = Integer.MAX_VALUE;
    }
/* Updates statistics after one experiment. This method cannot be called more times than the parameter
that was passed in the constructor. If it is, an error message should be printed and no change should
occur. The param value the result returned from a new experiment */

    public void updateStatistics(int value){
        if(Counter < numberOfRuns) {
            List.add(value);
            Counter++;
        } else {
            System.out.println("Error! Nothing will happen!");
        }
    }
    /* The function returns the current average of the values passed to the method updateStatistic */
    public double average(){
        double sum = 0;
        for(int num : List) {
            sum += num;
            if(num < Minimum)
                Minimum = num;
            if(num > Maxmimum)
                Maxmimum = num;
        }
        return sum/List.size();
    }
    /* The function returns the current standard deviation of the values passed to the method updateStatistic */
    public double standardDeviation(){  // sqrt(sum [(xi-X^)^2]/n)
        double avg = average();
        double sd = 0;
        for(int num : List){
            sd += Math.pow(num-avg,2);
        }
        return Math.sqrt(sd/numberOfRuns);
    }
    /* this function returns the complete statistics information: current minimum, maximum, average, and
    stdev. For the last two, only two digit decimals are printed. The toString function will define how
    an object will be printed out if you use something like System.out.println(objectName).
    It simply returns a string back describing the text that will be printed out. */
    public String toString(){
        String output;
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        output = "  -----------------------------------------"+
                "\n     * We ran: "+ Counter +" experiments"+
                "\n     * Mean: "+ decimalFormat.format(average()) +
                "\n     * Standard Deviation: "+ decimalFormat.format(standardDeviation()) +
                "\n     * Minimum: "+ Minimum +
                "\n     * Maximum: "+ Maxmimum +
                "\n  -----------------------------------------\n";

        return output;
    }
}