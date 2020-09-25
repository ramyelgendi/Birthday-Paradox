
package com.company.Question_3;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Created by ibrahimroshdy on 9/23/17.
 */

/**
 * The class BirthdayParadox is used to
 * simulate the Birthday paradox, it uses
 * the class Statistics to store the results of
 * the experiments (average, min, max, and stdev) *
 */
public class BirthdayParadox {

    private static Random generator = new Random();

  /* The function runExperiments runs the series of experiments,
         and stores the result into a Statistics object.
         The parameter range is the size of the set from which random number are drawn.
         The parameter numberOfRuns is the number of experiments to run. The function
         returns a reference to a Statistics instance that holds the result of the
         experiment (min, max, average, stdev).
        */


    public static Statistics runExperiments(int range, int numberOfRuns) {

        Statistics statistics = new Statistics(numberOfRuns);

        for (int i = 0; i < numberOfRuns; i++)
            statistics.updateStatistics(oneRun(range));

        return statistics;

    }


    /* Runs a single experiment. The parameter range defines the size of the set
       from which the numbers are drawn. The method returns the number of random
       draws in the set that the method underwent before drawing an element of
       the set for the second time
    */
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

    /* Main method. The default size of the set is 365, and the experiment
       is run 50 times. Both numbers can be reset from the command line. This method
       runs the experiments and prints the resulting Statistics. The param args,
       if not empty, contains the runtime values for the size of the set and the number of runs
    */
    private static String printLine(){

        return String.format("%n__________________________________________%n");
    }


    private static void question_1()
    {
        Scanner sc=new Scanner(System.in);

        int range;
        int numberOfRuns;

        System.out.println("Please enter the range");

        // String ana= sc.nextLine();

        String entertedVal=sc.nextLine();

        if(entertedVal.equals("")){
            range=365;
            System.out.println("Please enter the number of times the experiment is repeated");
            entertedVal=sc.nextLine();
        }

        else {
            range = Integer.valueOf(entertedVal);
            System.out.println("Please enter the number of times the experiment is repeated");
            entertedVal=sc.nextLine();

        }

        if(entertedVal.equals(""))
            numberOfRuns=50;
        else
            numberOfRuns = Integer.valueOf(entertedVal);


        Statistics statistics = runExperiments(range,numberOfRuns);
        System.out.print(printLine() + statistics.toString());



        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();

        categoryDataset.addValue(statistics.average(),"Mean","Mean");
        categoryDataset.addValue(statistics.standardDeviation(),"SD","SD");

        JFreeChart chart = ChartFactory.createBarChart(
                "Mean And SD For 1 Range(s)","Experiments","Values", // Title
                categoryDataset, PlotOrientation.VERTICAL, // Dataset
                true, // Show legend
                true, // Use tooltips
                false // Configure chart to generate URLs?

        );


        ChartFrame frame = new ChartFrame("Birthday Paradox",chart);
        frame.pack();
        frame.setVisible(true);

    }



    /*This method is used for a series of experiments
    with a number of ranges, with a series of bar graphs indicating */

    private static void question_2(String[] args){
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
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();


        for(int i = 0 ; i<stepNum;i++) {

            System.out.println("Range "+(i+1)*rangeBegin);
            statistics = runExperiments((i+1)*rangeBegin,numberofruns);
            System.out.print(statistics.toString());

            categoryDataset.addValue(statistics.average(),"Mean", ""+(i+1)*rangeBegin);
            categoryDataset.addValue(statistics.standardDeviation(),"Standard Deviation","" + (i+1)*rangeBegin);
        }

        // Question 3 Addition
        JFreeChart chart = ChartFactory.createBarChart(
                "Mean And Standard Deviation For " + stepNum + " Ranges",
                "Ranges","Values", // Title
                categoryDataset, PlotOrientation.VERTICAL, // Dataset
                true, // Show legend
                false, // Use tooltips
                false // Configure chart to generate URLs?

        );


        ChartFrame frame = new ChartFrame("Birthday Paradox",chart);
        frame.pack();
        frame.setVisible(true);

    }



    public static void main(String[] args) {


        System.out.println("Do you want to plot mean and standard deviation for question 1 or 2? (1/2 accepted only)");

        Scanner sc=new Scanner(System.in);
        String question = sc.nextLine();

        if(question.equals("1")){
            question_1();
        } else if(question.equals("2")){
            question_2(args);
        } else {
            System.out.print("Invalid entry!");
        }
    }
}