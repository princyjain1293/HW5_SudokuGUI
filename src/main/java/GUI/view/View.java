package GUI.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

import static java.awt.Component.CENTER_ALIGNMENT;

public class View {

    private static final int SIZE = 9;
    private JPanel outer;
    private JPanel sudokuPanel;
    private JPanel topPanel, bottomPanel;

    public JButton solveButton, resetButton, undoButton;
    public JLabel msgLabel;
    public JTextField[][] places;

    public View() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        outer = new JPanel(new BorderLayout(3, 3));
        setupTopPanel();
        setupBottomPanel();


        sudokuPanel = new JPanel(new GridLayout(SIZE, SIZE));
        places = new JTextField[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                places[r][c] = new JTextField("0");
                places[r][c].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                sudokuPanel.add(places[r][c]);
            }
        }
        outer.add(sudokuPanel);

        //buildSudoku();
    }

    private void setupTopPanel() {

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(outer.getWidth(), 30));
        solveButton = new JButton("Solve");
        resetButton = new JButton("Reset");
        undoButton = new JButton("Undo last cell");
        topPanel.add(solveButton);
        topPanel.add(resetButton);
        topPanel.add(undoButton);
        outer.add(topPanel, BorderLayout.NORTH);
    }

    private void setupBottomPanel() {

        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(outer.getWidth(), 30));
        msgLabel = new JLabel();
        msgLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(msgLabel, BorderLayout.CENTER);
        outer.add(bottomPanel, BorderLayout.SOUTH);
    }

//    private void buildSudoku() {
//
//        Insets buttonMargin = new Insets(25, 25, 25, 25);
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//
//                JButton b = new JButton();
//                b.setMargin(buttonMargin);
//                b.setBackground(Color.WHITE);
//                b.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
//                numButtons[j][i] = b;
//                sudokuPanel.add(numButtons[j][i]);
//            }
//        }
//    }

    public final JComponent getOuterPanel() {
        return outer;
    }

}