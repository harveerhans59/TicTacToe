import java.util.Random;

public class AdvancedAIPlayer
  extends player
  implements global
{
  public AdvancedAIPlayer(board paramboard, int paramInt, String paramString) { super(paramboard, paramInt, paramString); }

  
  public void play(board paramboard) {
    int i = 0;
    
    i = senseWin();
    if (i != 0) {
      
      paramboard.makeMove(i, this.playerSymbol);
      System.out.println(this.playerName + ": yes... I see a winning move at " + this.playerName + "!");
      
      return;
    } 
    
    if (i != 0) {
      
      paramboard.makeMove(i, this.playerSymbol);
      System.out.println(this.playerName + ": I am playing defense at " + this.playerName);
      
      return;
    } 
    i = randomLegal();
    paramboard.makeMove(i, this.playerSymbol);
    System.out.println(this.playerName + ": hmm... just a random move at " + this.playerName);
  }





  
  private int senseWin() {
    for (byte b = 0; b < 3; b = (byte)(b + 1)) {
      
      for (byte b1 = 0; b1 < 3; b1 = (byte)(b1 + 1)) {
        
        if (this.gameBoard.blocks[b][b1].getState() == 0) {





          
          byte b2 = 0;
          if (this.gameBoard.blocks[0][b1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (this.gameBoard.blocks[1][b1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (this.gameBoard.blocks[2][b1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if (this.gameBoard.blocks[b][0].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (this.gameBoard.blocks[b][1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (this.gameBoard.blocks[b][2].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if ((b == 0 && b1 == 2) || (b == 1 && b1 == 1) || (b == 2 && b1 == 0)) {
            
            if (this.gameBoard.blocks[0][2].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (this.gameBoard.blocks[2][0].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
          b2 = 0;
          if ((b == 0 && b1 == 0) || (b == 1 && b1 == 1) || (b == 2 && b1 == 2)) {
            
            if (this.gameBoard.blocks[0][0].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (this.gameBoard.blocks[2][2].getState() == this.playerSymbol) b2 = (byte)(b2 + 1); 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
        } 
      } 
    } 
    
    return 0;
  }



  
  private int randomLegal() {
    byte b1 = 0;
    int[] arrayOfInt = new int[9];
    Random random = new Random();
    byte b2;
    for (b2 = 0; b2 < 3; b2 = (byte)(b2 + 1)) {
      byte b;
      for (b = 0; b < 3; b = (byte)(b + 1)) {
        
        if (this.gameBoard.blocks[b2][b].getState() == 0) {
          
          b1 = (byte)(b1 + 1); arrayOfInt[b1] = 3 * b2 + 1 + b;
        } 
      } 
    } 

    
    return arrayOfInt[random.nextInt(b1)];
  }
}