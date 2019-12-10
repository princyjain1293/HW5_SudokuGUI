package GUI.controller;

import GUI.view.View;
import org.junit.Test;

import javax.swing.*;

public class ControllerTest {

    @Test
    public void validControllerTest(){
        View view = new View(); // view
        Controller controller = new Controller(view); // controller

        JFrame frame = new JFrame("Sudoku Solver");
        frame.add(view.getOuterPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

}