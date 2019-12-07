package Algorithms;

import model.SudokuReader;
import model.SudokuWriter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SudokuAlgorithmsTest {

    @Test
    public void testStopTimer() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";
        String outputPath="Output\\Puzzle-4x4-0101.txt";

        SudokuReader sudokuReader= new SudokuReader();
        SudokuWriter sudokuWriter=new SudokuWriter();
        sudokuReader.getPuzzle(inputPath);
        SudokuAlgorithms sudokuAlgorithms= new BackTracking(sudokuReader.getBoard(),sudokuReader.getActualBoard(),sudokuReader.getSide(),sudokuReader.getDomain(),outputPath,sudokuWriter);
        sudokuAlgorithms.solve();
        assertEquals(0.002,sudokuAlgorithms.getTime(),1.0);
    }

    @Test
    public void testStartTimer() {
    }

    @Test
    public void solve() {
    }
}