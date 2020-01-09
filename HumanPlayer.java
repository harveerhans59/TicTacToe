import java.util.Scanner;


class HumanPlayer
  extends player
{
  public HumanPlayer(board paramboard, int paramInt, String paramString) { super(paramboard, paramInt, paramString); }




  
  public void play(board paramboard) {
    boolean bool;
    Scanner scanner = new Scanner(System.in);
    
    this.gameBoard = paramboard;

    
    do {
      System.out.println("GameBot: Please enter your move by selecting a number from the available moves: ");
      paramboard.displayPlayerSelectionBoard();
      
      int i = scanner.nextInt();
      bool = paramboard.makeMove(i, this.playerSymbol);
      if (bool) continue;  System.out.println("GameBot: Invalid move! try again...");
    }
    while (!bool);
  }
}
