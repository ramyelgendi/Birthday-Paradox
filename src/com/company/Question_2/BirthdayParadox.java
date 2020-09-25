package com.company.Question_2;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class BirthdayParadox is used to
 * simulate the Birthday paradox, it uses
 * the class Statistics to store the results of * the experiments (average, min, max, and stdev) *
 */
public class BirthdayParadox {
    /* Random generator */
    private static Random generator = new Random();

    /* The function runExperiments runs the series of experiments, and stores the result into a Statistics object.
    The parameter range is the size of the set from which random number are drawn.
    The parameter numberOfRuns is the number of experiments to run. The function returns
    a reference to a Statistics instance that holds the result of the experiment (min, max, average, stdev).
    */
    public static Statistics runExperiments(int range, int numberOfRuns){
        Statistics statistics = new Statistics(numberOfRuns);
        for (int i = 0; i < numberOfRuns; i++)
            statistics.updateStatistics(oneRun(range));
        return statistics;
    }

    /* Runs a single experiment. The parameter range defines the size of the set from which the numbers are drawn.
    The method returns the number of random draws in the set that the method underwent before drawing an
    element of the set for the second time */
    private static int oneRun(int range){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        int TotalDraws = 0;
        int RandomNum;
        ArrayList<Integer> List = new ArrayList<>();

        for (int  i=0;i<range;i++) {
            RandomNum = generator.nextInt(range) + 1;

            if (List.isEmpty()) {
                List.add(RandomNum);
                TotalDraws++;
            } else {
                if (List.contains(RandomNum)) {
                    TotalDraws++;
                    return TotalDraws;

                } else if (!List.contains(RandomNum)) {
                    List.add(RandomNum);
                    TotalDraws++;
                }
            }
        }
        return 0;
    }

    /* Main method. The default size of the set is 365, and the experiment is run 50 times.
    Both numbers can be reset from the command line.
    This method runs the experiments and prints the resulting Statistics.
    The param args, if not empty, contains the runtime values for the size of the set and the number of runs
     */
    public static void main(String[] args) {
        int rangeBegin = 100;
        int rangeEnd = 10000;
        int numberofruns = 1000;

        // Command Line Arguments Validation
        if(args.length!= 0) {
            rangeBegin = Integer.parseInt(args[0]); //100
            if(args.length>=2) {
                rangeEnd = Integer.parseInt(args[1]); //10000
            }
            if(args.length>=3) {
                numberofruns = Integer.parseInt(args[2]); //1000
            }
        }
        System.out.println("Birthday Paradox Program");
        System.out.println("Range Begin: "+rangeBegin+"\nRange End: "+rangeEnd+"\nNumOfRuns: "+numberofruns+"\n");

        int stepNum = rangeEnd/rangeBegin;

        Statistics statistics;

        for(int i = 0 ; i<stepNum;i++) {
            System.out.println("Range "+(i+1)*rangeBegin);
            statistics = runExperiments((i+1)*rangeBegin,numberofruns);
            System.out.print(statistics.toString());
        }
    }
}