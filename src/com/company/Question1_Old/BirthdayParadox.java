
package com.company.Question1_Old;
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;


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
    private static int oneRun(int range) {


        int counter = 0;
        int draw;

        Stack<Integer> setStack = new Stack<>();
        setStack.clear();

        for (int  i=0;i<range;i++) {

            draw = generator.nextInt(range) + 1;

            if (setStack.isEmpty()) {
                setStack.push(draw);
                counter++;
                System.out.print(" " +draw);
            } else {
                if (setStack.contains(draw)) {
                    System.out.print(" "+draw);
                    counter++;
                    System.out.println(" Counter: " + counter);
                    return counter;
                } else if (!setStack.contains(draw)) {
                    setStack.push(draw);
                    counter++;
                    System.out.print(" " + draw);
                }
            }
        }

        counter=0;
        System.out.println(" Counter: " + counter);
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


    /* This method is used for only one range and number of experiments,
        with the plotting of each the mean and sd*/

    private static void oneRange()
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



//        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
//
//        categoryDataset.addValue(statistics.average(),"Mean","Mean");
//        categoryDataset.addValue(statistics.standardDeviation(),"SD","SD");
//
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Mean And SD For 1 Range(s)","Experiments","Values", // Title
//                categoryDataset, PlotOrientation.VERTICAL, // Dataset
//                true, // Show legend
//                true, // Use tooltips
//                false // Configure chart to generate URLs?
//
//        );
//
//
//        ChartFrame frame = new ChartFrame("Birthday Paradox",chart);
//        frame.pack();
//        frame.setVisible(true);

    }

    public static void main(String[] args) {

       oneRange();
    }


}