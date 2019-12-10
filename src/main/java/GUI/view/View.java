package GUI.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

import static java.awt.Component.CENTER_ALIGNMENT;

public class View {

    private static int SIZE = 9;
    private JPanel outer;
    private JPanel sudokuPanel;
    private JPanel topPanel, bottomPanel;

    public JButton resetButton, loadButton;
    public JButton backtrackingButton, dfsButton, stochasticButton,onlyoneButton;

    public static JTextField[][] places;

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
                places[r][c] = new JTextField("");
                places[r][c].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                sudokuPanel.add(places[r][c]);
            }
        }
        outer.add(sudokuPanel);

    }

    private void setupTopPanel() {

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(outer.getWidth(), 30));
        resetButton = new JButton("Reset");
        loadButton = new JButton("Load");
        topPanel.add(resetButton);
        topPanel.add(loadButton);
        outer.add(topPanel, BorderLayout.NORTH);
    }

    private void setupBottomPanel() {

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(outer.getWidth(), 30));
        backtrackingButton= new JButton("Back Tracking");
        dfsButton = new JButton("Depth First Search");
        stochasticButton= new JButton("Stochastic Search");
        onlyoneButton= new JButton("Only One Possibility");
        bottomPanel.add(backtrackingButton, BorderLayout.CENTER);
        bottomPanel.add(dfsButton);
        bottomPanel.add(stochasticButton);
        bottomPanel.add(onlyoneButton);
        outer.add(bottomPanel, BorderLayout.SOUTH);
    }

    public final JComponent getOuterPanel() {
        return outer;
    }

}