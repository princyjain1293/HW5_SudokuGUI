
import javax.swing.JFrame;

import GUI.controller.Controller;

import GUI.view.View;


public class Driver {

    public static void main(String[] args) {

//        Game game = new Game(); // common
        View view = new View(); // view
        Controller controller = new Controller(view); // controller

        JFrame frame = new JFrame("Sudoku Solver");
        frame.add(view.getOuterPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}