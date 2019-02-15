package solver;


public class Main{

    public static void main(String[] args) {

        int[] initialQueen = {Integer.parseInt( args[0]), Integer.parseInt( args[1])};
        
        EightQueenSolver solver = new EightQueenSolver(initialQueen);

        solver.solve();
    
    }
}