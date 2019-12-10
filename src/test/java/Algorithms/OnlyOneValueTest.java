package Algorithms;

import common.SudokuReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OnlyOneValueTest {

    @Test
    public void testValidConstructor() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";


        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        SudokuAlgorithms sudokuAlgorithms= new OnlyOneValue(sudokuReader.getBoard(),sudokuReader.getActualBoard(),sudokuReader.getSide(),sudokuReader.getDomain());
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
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        SudokuAlgorithms sudokuAlgorithms= new OnlyOneValue(sudokuReader.getBoard(),sudokuReader.getActualBoard(),sudokuReader.getSide(),sudokuReader.getDomain());
        boolean solvable=sudokuAlgorithms.solveSudoku();
        sudokuAlgorithms.printSolution(solvable);
    }
}