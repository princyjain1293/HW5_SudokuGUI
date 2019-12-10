package common;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void testValidatePerfectSquares() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";

        Validator validator= new Validator();
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        boolean actual=validator.validatePerfectSquares(sudokuReader.getBoard());
        assertEquals(true,actual);
    }

    @Test
    public void testInvalidValidatePerfectSquares() throws IOException {
        String inputPath="Input\\Puzzle-3X3-0001.txt";

        Validator validator= new Validator();
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        validator.validatePerfectSquares(sudokuReader.getBoard());
    }


    @Test
    public void testValidateValues() throws IOException {
        String inputPath="Input\\Puzzle-4x4-0101.txt";

        Validator validator= new Validator();
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        boolean actual=validator.validateValues(sudokuReader.getBoard());
        assertEquals(true,actual);
    }
}