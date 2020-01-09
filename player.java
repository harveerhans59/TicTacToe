
abstract class player
{
  public int playerSymbol;
  public board gameBoard;
  public String playerName;
  
  public abstract void play(board paramboard);
  
  public player(board paramboard, int paramInt, String paramString) {
    this.gameBoard = paramboard;
    this.playerSymbol = paramInt;
    this.playerName = paramString;
  }


  
  public String toString() { return this.playerName; }
}