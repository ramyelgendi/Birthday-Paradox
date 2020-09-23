package com.company;
/**
 * The class BirthdayParadox is used to
 * simulate the Birthday paradox, it uses
 * the class Statistics to store the results of * the experiments (average, min, max, and stdev) *
 */
public class BirthdayParadox {
    /* Random generator */
    private static java.util.Random generator = new java.util.Random();

    /* The function runExperiments runs the series of experiments, and stores the result into a Statistics object.
    The parameter range is the size of the set from which random number are drawn.
    The parameter numberOfRuns is the number of experiments to run. The function returns
    a reference to a Statistics instance that holds the result of the experiment (min, max, average, stdev).
    */
    public static Statistics runExperiments(int range, int numberOfRuns){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        return null;
    }

    /* Runs a single experiment. The parameter range defines the size of the set from which the numbers are drawn.
    The method returns the number of random draws in the set that the method underwent before drawing an
    element of the set for the second time */
    private static int oneRun(int range){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        return 0;
    }

    /* Main method. The default size of the set is 365, and the experiment is run 50 times.
    Both numbers can be reset from the command line.
    This method runs the experiments and prints the resulting Statistics.
    The param args, if not empty, contains the runtime values for the size of the set and the number of runs
     */
    public static void main(String[] args) {
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    }
}