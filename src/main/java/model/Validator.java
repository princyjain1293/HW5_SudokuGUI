package model;

public class Validator {
    public static boolean validatePerfectSquares(String[][] board){
        double length = Math.sqrt(board.length);
        double width=Math.sqrt(board[0].length);
        if((length - Math.floor(length)) != 0 && (width - Math.floor(width)) != 0){
            System.out.println("Not a valid puzzle: Perfect Square Required");
            System.exit(1);
        }
        return true;
    }

    public static boolean validateValues(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char ch = board[i][j].charAt(0);
                if(board[i][j].isEmpty()|| Character.isLetterOrDigit(ch)==false){
                    System.out.println("Not a valid puzzle: Only Numbers and Alphabets allowed");
                    System.exit(1);
                }
            }
        }
        return true;
    }


}
