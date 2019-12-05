package model;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SudokuWriter {
    public final void  writeToText(String outputName, String[][] solution,String[][] board,String[] domain, int count, int size, double time, String type) throws IOException {
        File file = new File(outputName);
        FileWriter writer= new FileWriter(file);
        writeInput(writer,board,domain,size);
        writeOutput(writer,solution,size,time,count,type);
        writer.close();
    }
    public void writeInput(FileWriter writer, String[][] board, String[] domain, int size) throws IOException {
        writer.write(size);
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        for(int i=0;i<size;i++){
            writer.write(domain[i]+" ");
            writer.flush();
        }
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                writer.write(board[i][j] + " ");
                writer.flush();
            }
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        }
        writer.write(System.getProperty("line.separator"));
        writer.flush();
    }
    public void writeOutput(FileWriter writer, String[][] solution, int size, double time,int count, String type) throws IOException {
//        File file = new File(outputName);
//        FileWriter writer= new FileWriter(file);
        writer.write("Solution:");
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                writer.write(solution[i][j] + " ");
                writer.flush();
            }
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        }
        writer.write("Strategy Used: "+type);
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.write("Time taken: "+(time));
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.write("Number of Iterations Done: "+count);
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
    }
}
