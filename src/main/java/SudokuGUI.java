import Algorithms.BackTracking;
import Algorithms.SudokuAlgorithms;
import model.SudokuReader;
import model.SudokuWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SudokuGUI extends JPanel implements ActionListener {
    private static int SIZE=9 ;
    private static JFrame frame;
    private JPanel sudokuPanel;
    private JPanel optionsPanel;
    private JPanel algorithmPanel;
    private JTextField[][] places;
    private JButton backtrackingButton;
    private JButton dfsButton,onlyoneButton,stochasticButton;
    private JButton openButton;
    private JButton saveButton;
    private String[][] board;
    private String[] domain;
    private String[][] puzzle;

    public static File inputFile;
    public static File outputFile;

    SudokuWriter sw= new SudokuWriter();
    SudokuAlgorithms sudokuAlgorithms;

    public SudokuGUI() {
        super(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 400));
        init();
    }

    private void createAndShowUI() {
        frame = new JFrame("Sudoku Solver");
        frame.add(new SudokuGUI(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void showGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }

    private void init() {
        sudokuPanel = new JPanel(new GridLayout(SIZE, SIZE));
        optionsPanel = new JPanel(new FlowLayout());
        algorithmPanel= new JPanel(new FlowLayout());

        places = new JTextField[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                places[r][c] = new JTextField("0");
                places[r][c].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                sudokuPanel.add(places[r][c]);
            }
        }

        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        backtrackingButton= new JButton("Back Tracking");
        dfsButton= new JButton("Depth First Search");
        onlyoneButton= new JButton("Only One Value");
        stochasticButton= new JButton("Stochastic Search");

        openButton.addActionListener(this);
        saveButton.addActionListener(this);
        backtrackingButton.addActionListener(this);
        dfsButton.addActionListener(this);
        onlyoneButton.addActionListener(this);
        stochasticButton.addActionListener(this);

        optionsPanel.add(openButton);
        optionsPanel.add(saveButton);

        algorithmPanel.add(backtrackingButton);
        algorithmPanel.add(dfsButton);
        algorithmPanel.add(onlyoneButton);
        algorithmPanel.add(stochasticButton);

        add(sudokuPanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.SOUTH);
        add(algorithmPanel,BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton source = (JButton) actionEvent.getSource();

        if (source == openButton) {
            try {
                inputFile= openFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       if (source == saveButton) {
            try {
                outputFile =saveFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
       }

       if(source== backtrackingButton){
            sudokuAlgorithms= new BackTracking(puzzle,board,SIZE,domain,"ndkjsadk.txt",sw);
           try {
               sudokuAlgorithms.solve();
           } catch (IOException e) {
               e.printStackTrace();
           }
            board=sudokuAlgorithms.getPuzzle();
            updateSudoku();
       }
    }


    private File openFile() throws IOException, IllegalArgumentException {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showDialog(this, "Open");
        File file;

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return null;
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
                places[r][c].setText(board[r][c]);

            }
        }

        return file;
    }

    private File saveFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showDialog(this, "Save");
        BufferedWriter out = null;
        File file=null;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }

    private void updateSudoku(){
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                places[r][c].setText(board[r][c]);

            }
        }
    }
}