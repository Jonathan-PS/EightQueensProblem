package solver;

public class EightQueenSolver {
    private int[][] queens = new int[][]{
    { 0, 0 },
    { 0, 0 },
    { 0, 0 },
    { 0, 0 },
    { 0, 0 },
    { 0, 0 },
    { 0, 0 },
    { 0, 0 }};
    
    // Rows and columns that have queens
    boolean[] takenRows = new boolean[] {false, false, false, false, false, false, false, false};
    boolean[] takenColumns = new boolean[] {false, false, false, false, false, false, false, false};

    public EightQueenSolver( int[] initialQueen) {
        queens[0] = initialQueen;

        // First queen takes its place
        takenRows[ queens[0][0] ] = true;
        takenColumns[ queens[0][1] ] = true;
    }


    public void solve() {
        placedAQueen(1);
    }


    private boolean placedAQueen(int ithQueen) {
        boolean ithQueenPlaced = false;
        boolean allGood = false;

        // FIND EMPTY ROW
        int i = 0; 
        while (takenRows[i] == true){
            i++;
            if (i>7) {
                //System.out.println("Queen "+ ithQueen + " false 1");
                return false;
            }
        } 

        // Work through each column:
        int j = 0;

        while(!allGood) {
            
            // FIND EMPTY COLUMN
            while (takenColumns[j] == true){
                j++;
                if (j>7) { // Failed to find any spots to put queen
                    //System.out.println("Queen"+ ithQueen + "false 2");
                    return false;
                }
            } 


            // CHECK DIAGONAL ATTACKS
            if(! onAnyDiagonals(ithQueen, i, j) ) {
                queens[ithQueen][0] = i;
                queens[ithQueen][1] = j;
                ithQueenPlaced = true;
                takenRows[i] = true;
                takenColumns[j] = true;
                //System.out.println("Queen "+  ithQueen + " FOUND a SPOT at " + i + j);
            } else {
                j++;
                if (j>7) { // Failed to find any spots to put queen
                    //System.out.println("Queen"+ ithQueen + "false 3");
                    return false;
                }
            }
            
            
            // RECURSIVELY PLACE NEXT QUEENS
            if(ithQueenPlaced == true && ithQueen == 7) {
                allGood = true;
                //System.out.println("ALL PLACED and everything goood!");
            }
            
            if (ithQueenPlaced == true && ithQueen < 7){  // Recursive part
                boolean returnSuccess = placedAQueen(ithQueen+1);
                if (!returnSuccess) {
                    ithQueenPlaced = false;
                    takenColumns[j] = false;
                    takenRows[i] = false;
                    j++;
                    if (j>7) { // Failed to find any spots to put queen
                        //System.out.println("Queen"+ ithQueen + "false ");
                        return false;
                    }
                } else {
                    allGood = true;
                }
            }
        }

        //System.out.println("Freedom!" + i);;
        return true;
    }

 
    public boolean onAnyDiagonals(int ithQueen, int row, int column) {
        for (int i = 0; i < ithQueen; i++) {
            if (onDiagonal(new int[]{row,column}, queens[i])) {
                return true;
            }
        }
        //System.out.println("On no diagonals");
        return false;
    }

    public boolean onDiagonal(int[] place1, int[] place2) {
        boolean diagonalCheck;
        int deltaRow = Math.abs(place1[0] - place2[0]);
        int deltaCol = Math.abs(place1[1] - place2[1]);
        if (deltaRow == deltaCol) {
            diagonalCheck = true; //Diagonal occupied 
            //System.out.println("true on diag");
        } else {
            diagonalCheck = false; //Diagonal free
            //System.out.println("false");
        }

        return diagonalCheck;
    }

    public void showBoard() {
        char[][] board = new char[8][8];

        //Initalize an empty board
        for (int i= 0; i < 8; i++) {
            char[] line = {'.','.','.','.','.','.','.','.'};
            board[i] = line;
        }

        for (int[] queen: queens) {
            board[ queen[0] ][ queen[1] ] = 'Q';
        }

        // PRINT TO TERMINAL
        System.out.println("  A B C D E F G H");
        System.out.println("  ---------------");

        int i = 8;
        for (char[] line: board) {
            System.out.print(i+ "|");
            for (char element: line) {
                System.out.print(element+ " ");
            }
            System.out.print("|" + i);

            i--;
            System.out.println();
        }
        System.out.println("  ---------------");
        System.out.println("  A B C D E F G H");

    }
}