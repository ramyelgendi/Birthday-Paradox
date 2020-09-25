
package com.company.Question_3;
import java.util.ArrayList; // List of Draws
import java.util.Random; // Randomizer
import java.util.Scanner; // Input

// JFree
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BirthdayParadox {
    private static Random generator = new Random();

    public static Statistics runExperiments(int range, int numberOfRuns) {
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

    private static void question_1(String[] args)
    {
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

        // Question 3 Addition
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        categoryDataset.addValue(statistics.average(),"Mean","Mean");
        categoryDataset.addValue(statistics.standardDeviation(),"Standard Deviation","Standard Deviation");

        // Question 3 Addition
        JFreeChart chart = ChartFactory.createBarChart(
                "Mean And Standard Deviation For 1 Range",
                "Ranges","Values", // Title
                categoryDataset, PlotOrientation.VERTICAL, // Dataset
                true, // Show legend
                false, // Use tooltips
                false // Configure chart to generate URLs?

        );

        ChartFrame frame = new ChartFrame("Birthday Paradox Problem For One Range",chart);
        frame.pack();
        frame.setVisible(true);

    }

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
        System.out.println("Birthday Paradox Program For Series Of Ranges");
        System.out.println("Range Begin: "+rangeBegin+"\nRange End: "+rangeEnd+"\nNumOfRuns: "+numberofruns+"\n");

        int stepNum = rangeEnd/rangeBegin;

        Statistics statistics;
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset(); // Question 3 Addition


        for(int i = 0 ; i<stepNum;i++) {

            System.out.println("Range "+(i+1)*rangeBegin);
            statistics = runExperiments((i+1)*rangeBegin,numberofruns);
            System.out.print(statistics.toString());

            // Question 3 Addition
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

        ChartFrame frame = new ChartFrame("Birthday Paradox Problem For Series Of Ranges",chart);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        // If there are 2 arguments passed, it will process as question 1, if 3 arguments, it will process as question 2.
        // Other than that it will ask the user to specify.

        switch (args.length){
            case 2 -> question_1(args);
            case 3 -> question_2(args);
            default -> {
                while (true){
                    System.out.println("Do you want to plot mean and standard deviation for question 1 or 2? (1/2 accepted only) OR (exit to end program)");
                    Scanner sc = new Scanner(System.in);
                    String question = sc.nextLine();
                    switch (question) {
                        case "1" -> question_1(args);
                        case "2" -> question_2(args);
                        case "exit" -> System.exit(0);
                        default -> System.out.print("Invalid entry!");
                    }
                }
            }
        }
    }
}