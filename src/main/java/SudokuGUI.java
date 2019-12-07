import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SudokuGUI extends JPanel implements ActionListener {
    private static final int SIZE = 9;
    private static JFrame frame;
    private JPanel sudokuPanel;
    private JPanel optionsPanel;
    private JTextField[][] places;
    private JButton openButton;
    private JButton saveButton;
    public File inputFile;
    public File outputFile;

    public SudokuGUI() {
        super(new BorderLayout());
        this.setPreferredSize(new Dimension(600, 600));
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

        places = new JTextField[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                places[r][c] = new JTextField("");
                places[r][c].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                sudokuPanel.add(places[r][c]);
            }
        }

        openButton = new JButton("Open");
        saveButton = new JButton("Save");

        openButton.addActionListener(this);
        saveButton.addActionListener(this);

        optionsPanel.add(openButton);
        optionsPanel.add(saveButton);

        add(sudokuPanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton source = (JButton) actionEvent.getSource();

        if (source == openButton) {
            try {
               inputFile= openFile();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

       if (source == saveButton) {
            try {
                outputFile =saveFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        }


    private File openFile() throws FileNotFoundException, IllegalArgumentException {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showDialog(this, "Open");
        File file=null;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
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
}