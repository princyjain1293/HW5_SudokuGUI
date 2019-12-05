package Algorithms;
import java.io.IOException;

public abstract class SudokuAlgorithms {
    private double start;
    private double stop;
    //private long numberOfSteps;
    private boolean solvable;
    public String[][]board= null;

    protected void stopTimer() {
        if (start != 0) {
            stop = System.currentTimeMillis();
        }
        System.out.println("Total Time Taken: " + ((stop - start) / 1000) + " secs");
        //System.out.println("Number of Steps: " + numberOfSteps);

    }
    public double getTime(){return (stop - start) / 1000;}

    protected void startTimer() {
        start = System.currentTimeMillis();
        System.out.println(start);
    }



    public abstract boolean solveSudoku() throws IOException;
    public abstract String[][] printSolution(boolean solvable) throws IOException;
    public abstract String[][] getPuzzle();
    public final void solve() throws IOException {

        startTimer();
        solvable=solveSudoku();
        stopTimer();
        printSolution(solvable);

    }
}
