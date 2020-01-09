
import java.util.Random;
import java.util.Scanner;


class game implements global
{
  board gameBoard;
  player playerX;
  player playerO;
  int turn;
  boolean done = false;
  
  public game() {
    Scanner scanner = new Scanner(System.in);
    this.gameBoard = new board();
    String str1 = "player1", str2 = "player2";
    int i = 0;
    
    System.out.println("--------------------------------------");
    System.out.println("XoXoXoooo     Tic            ooooXoXoX");
    System.out.println("XoXoXoooo         Tac        ooooXoXoX");
    System.out.println("XoXoXoooo            Toe     ooooXoXoX");
    System.out.println("--------------------------------------\n");
    System.out.println("  Written by Dr. Ziad Kobti (c)2018   \n");
    System.out.println("--------------------------------------\n");
    
    while (!this.done) {
      
      System.out.println("GameBot: Welcome to TicTacToe for the Java 212 Kobti class.");
      System.out.println("GameBot: Please select a game option: [1] Human vs Human [2] Human vs AI [3] AI vs AI");
      i = scanner.nextInt();
      
      switch (i) {
        
        case 1:
          System.out.print("GameBot: Please enter human player X name: ");
          str1 = scanner.next().trim();
          System.out.print("GameBot: Please enter human player O name: ");
          str2 = scanner.next().trim();
          this.done = true;
          continue;
        case 2:
          System.out.print("GameBot: Please enter human player X name: ");
          str1 = scanner.next().trim();
          System.out.print("GameBot: Please enter AI player O name: ");
          str2 = scanner.next().trim();
          
          System.out.println("KobtiBot: yeah...right! you many not name me... I AM KobtiBot");
          System.out.println("KobtiBot: don't worry " + str1 + ", my level of difficulty is set to NOVICE!\n");
          str2 = "KobtiBot";
          
          this.done = true;
          continue;
        case 3:
          System.out.print("GameBot: Please enter Novice AI player X name: ");
          str1 = scanner.next().trim();
          System.out.print("GameBot: Please enter Advanced AI player O name: ");
          str2 = scanner.next().trim();
          
          this.done = true;
          continue;
      } 
      
      System.out.println("GameBot: Please enter a valid selection...");
    } 


    
    if (i == 1) {
      
      this.playerX = new HumanPlayer(this.gameBoard, 1, str1);
      this.playerO = new HumanPlayer(this.gameBoard, 2, str2);
    }
    else if (i == 2) {
      
      this.playerX = new HumanPlayer(this.gameBoard, 1, str1);
    this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, str2);
    }
    else {
      
      this.playerX = new AIPlayer(this.gameBoard, 1, str1);
    this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, str2);
    } 
    
    System.out.println("GameBot: Game initiated: " + str1 + " VS. " + str2 + "\n");
  }

  
  public void start() {
    Random random = new Random();
    boolean bool = false;
    
    this.turn = random.nextInt(2) + 1;
    
    if (this.turn == 1) {
      System.out.println("GameBot: " + this.playerX.playerName + " wins the coin toss... X will start\n");
    } else {
      System.out.println("GameBot: " + this.playerO.playerName + " wins the coin toss... O will start\n");
    } 
    
    while (!bool) {
      
      if (this.turn == 1) {
        
        System.out.println("GameBot: Player X's Turn, go ahead " + this.playerX.playerName + ":");
        this.playerX.play(this.gameBoard);
      }
      else {
        
        System.out.println("GameBot: Player O's Turn, go ahead " + this.playerO.playerName + ":");
        this.playerO.play(this.gameBoard);
      } 
      
      if (this.gameBoard.getState() != 0) bool = true;
      
      if (!bool) {
        
        if (this.turn == 1) {
          this.turn = 2; continue;
        } 
        this.turn = 1;
      } 
    } 
    
    this.gameBoard.displayBoard();
    if (this.gameBoard.getState() == 3) {
      System.out.println("GameBot: It is a DRAW! no winner...");
    } else if (this.turn == 1) {
      System.out.println("GameBot: The winner is player " + this.playerX);
    } else {
      System.out.println("GameBot: The winner is player " + this.playerO);
    } 
  }
}