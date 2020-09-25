package com.company.Question_1;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Statistics {
    private final int numberOfRuns;
    private int Counter;
    private final ArrayList<Integer> List;
    public int Minimum,Maxmimum;

    // The numberOfRuns the number of experiments that will be run
    public Statistics(int numberOfRuns){    // Initializing
        List = new ArrayList<>();
        this.numberOfRuns=numberOfRuns;
        this.Counter=0;
        this.Maxmimum = Integer.MIN_VALUE;
        this.Minimum = Integer.MAX_VALUE;
    }

    public void updateStatistics(int value){ // Total Experiments List
        if(Counter < numberOfRuns) {
            List.add(value);
            Counter++;
        } else {
            System.out.println("Error! Nothing will happen!");
        }
    }

    public double average(){ // MEAN
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
    public double standardDeviation(){  // Standard Deviation = sqrt(sum [(xi-X^)^2]/n)
        double avg = average();
        double sd = 0;
        for(int num : List){
            sd += Math.pow(num-avg,2);
        }
        return Math.sqrt(sd/numberOfRuns);
    }

    public String toString(){ // OUTPUT FUNCTION TO PRINT STATS FOR EVERY EXPERIMENT
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