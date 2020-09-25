package com.company.Question_1;

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
        int range = 365;
        int numberofruns = 50;

        // Command Line Arguments Validation
        if(args.length!= 0) {
            range = Integer.parseInt(args[0]); //365
            if(args.length>=2) {
                numberofruns = Integer.parseInt(args[1]); //50
            }
        }
        System.out.println("Birthday Paradox Program For One Range");
        System.out.println("Range: "+range+"\nNumOfRuns: "+numberofruns+"\n");



        System.out.println("Range "+range);
        Statistics statistics = runExperiments(range,numberofruns);
        System.out.print(statistics.toString());
    }
}