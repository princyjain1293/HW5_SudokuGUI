package Algorithms;

import model.SudokuWriter;

import java.io.IOException;
import java.util.ArrayList;

public class OnlyOneValue extends SudokuAlgorithms {

    public String[][] puzzle;
    public int size;
    public String[] domain;
    public String outputFileName;
    SudokuWriter sudokuWriter;
    public int count=0;
    public String[][] board;

    public OnlyOneValue(String[][] puzzle,String[][] board, int size,String[] domain,String outputFileName,SudokuWriter sudokuWriter){
        this.puzzle=puzzle;
        this.size=size;
        this.domain=domain;
        this.outputFileName=outputFileName;
        this.sudokuWriter=sudokuWriter;
        this.board=board;
    }

    public boolean solveSudoku() throws IOException {
        int domainSum= 0;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<domain.length;i++){
           domainSum= domainSum+Integer.parseInt(domain[i]) ;
        }

        for(int i=0;i<puzzle.length;i++){
            for(int j=0;j<puzzle.length;j++){
                int sum =0;
                if(puzzle[i][j].equals("0")){
                sum=sum+0;
                }
                else{
                    sum=sum+Integer.parseInt(puzzle[i][j]);
                }

                list.add(Integer.toString(sum));
            }
        }

        for(int i=0;i<puzzle.length;i++){
            int count=0;
            for(int j=0;j<puzzle.length;j++){
                count++;
                if(puzzle[i][j].equals("0")&&count<2){
                    puzzle[i][j]=Integer.toString(domainSum-Integer.parseInt(list.get(j)));
                }
                if(count>1){
                    System.out.println("Cannot Solve with one value");
                    System.out.println("Moving to backtracking");
                    SudokuAlgorithms sudokuAlgorithmsNew= new BackTracking(puzzle,board,size,domain,outputFileName,sudokuWriter);
                    sudokuAlgorithmsNew.solve();
                    return false;
                }
            }
        }

        return true;

    }
    public String[][] printSolution(boolean solvable) throws IOException {
        if(solvable){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    System.out.print(puzzle[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("The sudoku puzzle is not solvable");
        }

        sudokuWriter.writeToText(outputFileName,puzzle,board,domain,count,size,super.getTime(),"Only one Value");

        return puzzle;

    }
    public String[][] getPuzzle(){
        return puzzle;
    }

}
