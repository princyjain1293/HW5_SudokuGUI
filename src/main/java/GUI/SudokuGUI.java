package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI implements ActionListener {
    JButton submit= new JButton("Submit");
    JLabel status= new JLabel("---");
    private static int[][] array;
    private static int[][] sudoku;
    public static JTextField[][] index= new JTextField[9][9];
    public SudokuGUI(){
        JFrame jFrame= new JFrame("Sudoku");
        jFrame.setSize(500,500);
        submit.addActionListener(this);
        JPanel board= new JPanel();
        JPanel panel= new JPanel();
        board.setLayout(new GridLayout(9,9));
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                index[i][j]= new JTextField(1);
                index[i][j].setText(""+sudoku[i][j]);
                if(sudoku[i][j]!=0)
                    index[i][j].setEditable(false);
                board.add(index[i][j]);
            }
        }
        jFrame.getContentPane().add(board);
        jFrame.getContentPane().add(submit,"South");
        jFrame.getContentPane().add(status,"North");
        jFrame.setVisible(true);
    }
    public static int[][] submit(){
        int[][]result = new int[9][9];
        for (int i =0;i<9;i++)
            for (int j=0;j<9;j++){
                try {
                    result[i][j]=Integer.parseInt(index[i][j].getText());
                }catch (Exception e){
                    result[i][j]=-1;
                }
            }
        return result;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            int[][] temp = submit();
            write(temp);
        }
    }


}
