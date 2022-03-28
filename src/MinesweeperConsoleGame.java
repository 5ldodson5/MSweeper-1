import java.util.Scanner;

public class MinesweeperConsoleGame {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tiles;
        int mines;
        
        System.out.println("Please enter two positive numbers (# as in a #x# board | the # of mines): ");
        
        tiles = sc.nextInt();
        mines = sc.nextInt();
        
        System.out.println("Mines:9 'hidden':-1");
        System.out.println("");
        
        ControllerMap game = new ControllerMap(tiles, mines); // Creates the game
        game.populateMap();
        System.out.println("");
        System.out.println("Let's get started!");
        System.out.println("");
        int x = 0;
        game.printVisableMap();
        
        while (x != -1) { // Actually plays the game
        	int inputRow;
        	int inputColumn;
        	
        	
            System.out.println("");
            System.out.println("Please select a row/column to examine (zero-based indexing please): ");
            
            inputRow = sc.nextInt();
            inputColumn = sc.nextInt();
            
            int y = game.playerInteract(inputRow, inputColumn); // User input to select square
            
            if (y == 2) { // Response System: Win, Hit or Miss
                System.out.println("");
                System.out.println("You have hit a mine!");
                System.out.println("");
                game.printMap();
                System.exit(0); // Exits after the game is complete
            }
            if (y == 1) {
                System.out.println("");
                System.out.println("You won! Congratulations");
                System.out.println("");
                game.printMap();
                System.exit(0); // Exits after the game is complete
            }
            if (y == 0) {
                System.out.println("");
                System.out.println("Here is the board for reference. Play you next move wisely.");
                System.out.println("");
                game.printVisableMap(); // Continues if the game has not been completed. 
            }
        }
    }
}
