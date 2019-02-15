package solver;

 
public class Main{

    public static void main(String[] args) {
        String input1, input2 = null;

        try {
            input1 = args[0];

            if( args.length > 1) {
                input2 = args[1];
            } 
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error: please provide coordinates on the form ");
            System.out.println("algebraic notation: a4 ");
            System.out.println("or :                0 1");
            return;
        }

        if (input2 == null) {
            String[] output = algebraicNotation(input1);
            input1 = output[0];
            input2 = output[1];
        }
        
        int[] initialQueen = {Integer.parseInt( input1), Integer.parseInt( input2)};
        EightQueenSolver solver = new EightQueenSolver(initialQueen);
        
        solver.solve();
        solver.showBoard();
    }

    public static String[] algebraicNotation(String input) {
        String cord1 = "" + input.charAt(0); // a letter
        String cord2 = "" + input.charAt(1); // a number

        //Integer cord2Int = Integer.valueOf( cord2 );
        //initalize initialColNumber
        int initialColNumber = -1;
        //convert letter to rownumber
        switch (cord1) {
            case "a": initialColNumber = 0;
            break;
            case "b": initialColNumber = 1;
            break;
            case "c": initialColNumber = 2;
            break;
            case "d": initialColNumber = 3;
            break;
            case "e": initialColNumber = 4;
            break;
            case "f": initialColNumber = 5;
            break;
            case "g": initialColNumber = 6;
            break;
            case "h": initialColNumber = 7;
            break;
            default: System.out.println("Please enter a co-ordinate following the algebraic notation, like a4 in the range a1 to h8");
        }

        int initialRowNumber = -1;
        switch (cord2) {
            case "1": initialRowNumber = 7;
            break;
            case "2": initialRowNumber = 6;
            break;
            case "3": initialRowNumber = 5;
            break;
            case "4": initialRowNumber = 4;
            break;
            case "5": initialRowNumber = 3;
            break;
            case "6": initialRowNumber = 2;
            break;
            case "7": initialRowNumber = 1;
            break;
            case "8": initialRowNumber = 0;
            break;
            default: System.out.println("Please enter a co-ordinate following the algebraic notation, like a4 in the range a1 to h8 ");
        }
    

        return new String[]{"" +initialRowNumber,"" + initialColNumber};
    }


    
}