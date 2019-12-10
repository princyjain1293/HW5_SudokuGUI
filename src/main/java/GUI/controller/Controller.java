package GUI.controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;


import javax.swing.JOptionPane;

import GUI.model.Cell;
import GUI.model.Game;
import GUI.view.View;
import com.sun.xml.internal.ws.util.StringUtils;


public class Controller {

    private static final int SIZE = 9;
    private Game game;
    private View view;
    private Cell[][] sudokuGrid;
    private Stack<ArrayList<Integer>> undoStack;

    public Controller(Game g, View v) {

        game = g;
        view = v;
        sudokuGrid = game.getGrid();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                view.numButtons[i][j].addActionListener(createActionListener(i, j));
//                view.numButtons[i][j].setText("");
//                view.numButtons[i][j].setFont(new Font("Helvetica", Font.PLAIN, 16)); // large font for initial values
//            }
//        }

        undoStack = new Stack<ArrayList<Integer>>();
        view.resetButton.addActionListener(resetActionListener());
        view.solveButton.addActionListener(solveActionListener());
        view.undoButton.addActionListener(undoActionListener());
        view.msgLabel.setText("Click on cells to enter values");
    }

    private void clickedUndoButton() {

        if (!undoStack.isEmpty()) {

            ArrayList<Integer> coordinates = undoStack.pop();
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            view.numButtons[x][y].setText(""); // undo view
            view.numButtons[x][y].setFont(new Font("Helvetica", Font.PLAIN, 16));
            sudokuGrid[y][x].resetValue(); // undo model
            view.msgLabel.setText("Undone cell");
        }
    }

    private boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private void clickedSudokuButton(int i, int j) {

        String s = (String) JOptionPane.showInputDialog(null, "Enter a value [1-9]:");

        if (s == null) { // user pressed Cancel
            return;
        }

        if (!isNumeric(s)) {
            view.msgLabel.setText("Invalid input");
            return;
        }

        int num = Integer.parseInt(s);
        if (num >= 1 && num <= SIZE) {
            view.numButtons[i][j].setText(s); // update view
            view.numButtons[i][j].setFont(new Font("Helvetica", Font.BOLD, 28)); // large font for initial values
            sudokuGrid[j][i].setValue(num); // update model

            // store coordinates for Undo functionality
            ArrayList<Integer> coordinates = new ArrayList<Integer>();
            coordinates.add(i);
            coordinates.add(j);
            undoStack.push(coordinates);
            view.msgLabel.setText("Value set to " + s);
        } else {
            view.msgLabel.setText("Invalid input");
        }
    }

    private void resetGame() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                view.numButtons[i][j].setText(""); // reset view
                view.numButtons[i][j].setFont(new Font("Helvetica", Font.PLAIN, 16));
                sudokuGrid[i][j].resetValue(); // reset model
                undoStack.clear();
            }
        }
        view.msgLabel.setText("Reset");
    }

    private void solveGame() {

        boolean result = game.solveSudoku();
        if (result) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int val = sudokuGrid[j][i].getValue();
                    String numString = String.valueOf(val);
                    view.numButtons[i][j].setText(numString); // set view
                }
            }
            view.msgLabel.setText("Solved");
        } else {
            view.msgLabel.setText("Invalid configuration");
        }
    }

    private ActionListener createActionListener(int i, int j) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clickedSudokuButton(i, j);
            }
        };
    }

    private ActionListener undoActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clickedUndoButton();
            }
        };
    }

    private ActionListener resetActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        };
    }

    private ActionListener solveActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                solveGame();
            }
        };
    }

}