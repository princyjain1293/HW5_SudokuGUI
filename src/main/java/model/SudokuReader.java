package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SudokuReader {
    public String[][] puzzle = null;
    public String[] domain = new String[0];
    public int side=0;
    public String[][]  board=null;
    public void getPuzzle(String inputFileName) throws IOException {

        //List<String> domain = new ArrayList<>();



            BufferedReader br = new BufferedReader(new FileReader(inputFileName));

            side = Integer.valueOf(br.readLine());
            double sq= Math.sqrt(side);
            if(sq-Math.floor(sq)!=0){
                System.out.println("Array must be a perfect square");
                System.exit(1);
            }
            domain = null;
            domain = br.readLine().split(" ");
            for (String c : domain) {
                System.out.print(c + " ");
            }
            System.out.println();

            String line = br.readLine();
            puzzle = new String[side][];
            board = new String[side][];
            puzzle[0] = readRow(line, side);
            board[0] = readRow(line, side);

            int rowNum = 1;
            while ((line = br.readLine()) != null) {
                if (rowNum >= side) {
                    System.out.println("Puzzle is not apt");
                    System.exit(1);
                }
                puzzle[rowNum] = readRow(line, side);
                board[rowNum++] = readRow(line, side);
            }



        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (puzzle[i][j].equals("-")) {
                    puzzle[i][j] = "0";
                }
                System.out.print(puzzle[i][j]);
            }

            System.out.println();
        }

    }
    public static String[] readRow(String line, int side){
        String[] row= new String[side];
        String[] elements= line.split(" ");
        if(elements.length!=side){
            System.out.println("Bad Puzzle");
            System.exit(1);
        }
        for(int i=0;i<elements.length;i++){
            row[i]=elements[i];
        }
        return row;
    }
    public int getSide(){return side;}
    public String[][] getBoard(){return puzzle;}
    public String[] getDomain(){return domain;}
    public String[][] getActualBoard(){return board;}
}
