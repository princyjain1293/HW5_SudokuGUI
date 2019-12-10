package gui.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import algorithms.*;
import gui.view.View;
import common.SudokuReader;

public class Controller extends JPanel {

    private static int SIZE = 9;
    private View view;
    private String[][] board;
    private String[] domain;
    private String[][] puzzle;
    private SudokuAlgorithms sudokuAlgorithms;
    public Controller( View v) {
        view = v;
        view.resetButton.addActionListener(resetActionListener());
        view.loadButton.addActionListener(loadActionListener());
        view.backtrackingButton.addActionListener(backTrackingActionListener());
        view.dfsButton.addActionListener(dfsActionListener());
        view.stochasticButton.addActionListener(stochasticActionListener());
        view.onlyoneButton.addActionListener(onlyOneActionListener());
    }

    private void loadFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showDialog(this, "Open");
        File file;
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

        file = fileChooser.getSelectedFile();
        String inputFileName=file.getName();
        String inputPath="Input\\"+inputFileName;
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        board= sudokuReader.getBoard();
        SIZE = sudokuReader.getSide();
        domain= sudokuReader.getDomain();
        puzzle=sudokuReader.getActualBoard();

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                View.places[r][c].setText(board[r][c]);

            }
        }
    }

    private ActionListener loadActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
    private ActionListener resetActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetGrid();
            }
        };
    }
    private ActionListener backTrackingActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuAlgorithms=new BackTracking(board,puzzle,SIZE,domain);
                try {
                    sudokuAlgorithms.solve();
                    updateGrid();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }

    private ActionListener dfsActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuAlgorithms=new DepthFirstSearch(board,puzzle,SIZE,domain);
                try {
                    sudokuAlgorithms.solve();
                    updateGrid();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }

    private ActionListener stochasticActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuAlgorithms=new StochasticSearch(board,puzzle,SIZE,domain);
                try {
                    sudokuAlgorithms.solve();
                    updateGrid();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
    private ActionListener onlyOneActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuAlgorithms=new OnlyOneValue(board,puzzle,SIZE,domain);
                try {
                    sudokuAlgorithms.solve();
                    updateGrid();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }

    private void updateGrid(){
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                View.places[r][c].setText(board[r][c]);
            }
        }
    }
    private void resetGrid(){
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                View.places[r][c].setText("");
            }
        }
    }

}