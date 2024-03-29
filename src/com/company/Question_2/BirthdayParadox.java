package com.company.Question_2;

import java.util.ArrayList;
import java.util.Random;


public class BirthdayParadox {
    private static final Random generator = new Random();     /* Random generator */


    public static Statistics runExperiments(int range, int numberOfRuns){
        Statistics statistics = new Statistics(numberOfRuns);
        for (int i = 0; i < numberOfRuns; i++)
            statistics.updateStatistics(oneRun(range));
        return statistics;
    }

    private static int oneRun(int range){
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