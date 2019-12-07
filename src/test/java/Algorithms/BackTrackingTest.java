package Algorithms;

import model.SudokuReader;
import model.SudokuWriter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class BackTrackingTest {

    @Test
    public void testValidConstructor() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";
        String outputPath="Output\\Puzzle-4x4-0101.txt";

        SudokuReader sudokuReader= new SudokuReader();
        SudokuWriter sudokuWriter=new SudokuWriter();
        sudokuReader.getPuzzle(inputPath);
        SudokuAlgorithms sudokuAlgorithms= new BackTracking(sudokuReader.getBoard(),sudokuReader.getActualBoard(),sudokuReader.getSide(),sudokuReader.getDomain(),outputPath,sudokuWriter);
        sudokuAlgorithms.solveSudoku();
        String[][] actualPuzzle=sudokuAlgorithms.getPuzzle();
        String[][] puzzle= {{"2","4","3","1"},{"1","3","2","4"},{"3","1","4","2"},{"4","2","1","3"}};
        assertEquals(puzzle,actualPuzzle);
    }

    @Test
    public void testFindBlankLocation() {

    }

    @Test
    public void usedInRow() {
    }

    @Test
    public void usedInColumn() {
    }

    @Test
    public void usedInBox() {
    }

    @Test
    public void isSafe() {
    }

    @Test
    public void solveSudoku() {
    }

    @Test
    public void testPrintSolution() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";
        String outputPath="Output\\Puzzle-4x4-0101.txt";

        SudokuReader sudokuReader= new SudokuReader();
        SudokuWriter sudokuWriter= new SudokuWriter();
        sudokuReader.getPuzzle(inputPath);
        SudokuAlgorithms sudokuAlgorithms= new BackTracking(sudokuReader.getBoard(),sudokuReader.getActualBoard(),sudokuReader.getSide(),sudokuReader.getDomain(),outputPath,sudokuWriter);
        boolean solvable=sudokuAlgorithms.solveSudoku();
        sudokuAlgorithms.printSolution(solvable);
    }
}