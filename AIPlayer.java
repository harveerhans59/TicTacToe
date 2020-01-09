
import java.util.Random;


public class AIPlayer
  extends player
  implements global
{
  public AIPlayer(board paramboard, int paramInt, String paramString) { super(paramboard, paramInt, paramString); }

  
  public void play(board paramboard) {
    int i = 0;
    
    i = randomLegal();
    paramboard.makeMove(i, this.playerSymbol);
    System.out.println(this.playerName + ": hmm... just a random move at " + i);
  }

  private int senseWin() {
    for (byte b = 0; b < 3; b++) {
      
      for (byte b1 = 0; b1 < 3; b1++) {
        
        if (this.gameBoard.blocks[b][b1].getState() == 0) {
          
          byte b2 = 0;
          if (this.gameBoard.blocks[0][b1].getState() == this.playerSymbol) b2++; 
          if (this.gameBoard.blocks[1][b1].getState() == this.playerSymbol) b2++; 
          if (this.gameBoard.blocks[2][b1].getState() == this.playerSymbol) b2++; 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if (this.gameBoard.blocks[b][0].getState() == this.playerSymbol) b2++; 
          if (this.gameBoard.blocks[b][1].getState() == this.playerSymbol) b2++; 
          if (this.gameBoard.blocks[b][2].getState() == this.playerSymbol) b2++; 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if ((b == 0 && b1 == 2) || (b == 1 && b1 == 1) || (b == 2 && b1 == 0)) {
            
            if (this.gameBoard.blocks[0][2].getState() == this.playerSymbol) b2++; 
            if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) b2++; 
            if (this.gameBoard.blocks[2][0].getState() == this.playerSymbol) b2++; 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
          b2 = 0;
          if ((b == 0 && b1 == 0) || (b == 1 && b1 == 1) || (b == 2 && b1 == 2)) {
            
            if (this.gameBoard.blocks[0][0].getState() == this.playerSymbol) b2++; 
            if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) b2++; 
            if (this.gameBoard.blocks[2][2].getState() == this.playerSymbol) b2++; 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
        } 
      } 
    } 
    
    return 0;
  }
/*
  private int senseLoss() {
    boolean bool;
    if (this.playerSymbol == 1) {
      bool = true;
    } else {
      bool = true;
    } 
    for (byte b = 0; b < 3; b++) {
      
      for (byte b1 = 0; b1 < 3; b1++) {
        
        if (this.gameBoard.blocks[b][b1].getState() == 0) {
      
          byte b2 = 0;
          if (this.gameBoard.blocks[0][b1].getState() == bool) b2++; 
          if (this.gameBoard.blocks[1][b1].getState() == bool) b2++; 
          if (this.gameBoard.blocks[2][b1].getState() == bool) b2++; 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if (this.gameBoard.blocks[b][0].getState() == bool) b2++; 
          if (this.gameBoard.blocks[b][1].getState() == bool) b2++; 
          if (this.gameBoard.blocks[b][2].getState() == bool) b2++; 
          if (b2 == 2) return 3 * b + 1 + b1;
          
          b2 = 0;
          if ((b == 0 && b1 == 2) || (b == 1 && b1 == 1) || (b == 2 && b1 == 0)) {
            
            if (this.gameBoard.blocks[0][2].getState() == bool) b2++; 
            if (this.gameBoard.blocks[1][1].getState() == bool) b2++; 
            if (this.gameBoard.blocks[2][0].getState() == bool) b2++; 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
          b2 = 0;
          if ((b == 0 && b1 == 0) || (b == 1 && b1 == 1) || (b == 2 && b1 == 2)) {
            
            if (this.gameBoard.blocks[0][0].getState() == bool) b2++; 
            if (this.gameBoard.blocks[1][1].getState() == bool) b2++; 
            if (this.gameBoard.blocks[2][2].getState() == bool) b2++; 
            if (b2 == 2) return 3 * b + 1 + b1;
          
          } 
        } 
      } 
    } 
    
    return 0;
  }
**/

  
  private int randomLegal() {
    byte b2 = 0;
    int[] arrayOfInt = new int[9];
    Random random = new Random();
    
    for (byte b1 = 0; b1 < 3; b1++) {
      
      for (byte b = 0; b < 3; b++) {
        
        if (this.gameBoard.blocks[b1][b].getState() == 0)
        {
          arrayOfInt[b2++] = 3 * b1 + 1 + b;
        }
      } 
    } 

    
    return arrayOfInt[random.nextInt(b2)];
  }
}