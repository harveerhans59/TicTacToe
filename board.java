
class board
implements global {
public block[][] blocks;
private int state = 0;


public board() {
  this.blocks = new block[3][3];
  for (byte b = 0; b < 3; b++) {
    
    for (byte b1 = 0; b1 < 3; b1++)
    {
      this.blocks[b][b1] = new block();
    }
  } 
}

public void displayBoard() {
  System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");
  System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");
  System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");
}


public void displayPlayerSelectionBoard() {
  byte b1 = 1;
  for (byte b2 = 0; b2 < 3; b2++) {
    
    for (byte b = 0; b < 3; b++) {
      
      System.out.print((this.blocks[b2][b].getState() == 0) ? Integer.valueOf(b1) : this.blocks[b2][b]);
      b1++;
      if (b != 2) System.out.print("|"); 
    } 
    System.out.print("\n");
  } 
}



public int getState() { return updateState(); }






public int updateState() {
  int i = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonals();


  
  if (i != 0) {
    
    this.state = i;
  }
  else {
    
    this.state = checkDraw();
  } 
  return this.state;
}




private int checkDraw() {
  for (byte b = 0; b < 3; b++) {
    for (byte b1 = 0; b1 < 3; b1++) {
      if (this.blocks[b][b1].getState() == 0) return 0; 
    } 
  }  return 3;
}


private int checkRow(int paramInt) {
  if (this.blocks[paramInt][0].getState() != 0)
  {
    if (this.blocks[paramInt][0].getState() == this.blocks[paramInt][1].getState() && this.blocks[paramInt][1]
      .getState() == this.blocks[paramInt][2].getState())
      return this.blocks[paramInt][0].getState(); 
  }
  return 0;
}


private int checkCol(int paramInt) {
  if (this.blocks[0][paramInt].getState() != 0)
  {
    if (this.blocks[0][paramInt].getState() == this.blocks[1][paramInt].getState() && this.blocks[1][paramInt]
      .getState() == this.blocks[2][paramInt].getState())
      return this.blocks[0][paramInt].getState(); 
  }
  return 0;
}


private int checkDiagonals() {
  if (this.blocks[0][0].getState() != 0)
  {
    if (this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1]
      .getState() == this.blocks[2][2].getState()) {
      return this.blocks[0][0].getState();
    }
  }
  if (this.blocks[0][2].getState() != 0)
  {
    if (this.blocks[0][2].getState() == this.blocks[1][1].getState() && this.blocks[1][1]
      .getState() == this.blocks[2][0].getState()) {
      return this.blocks[0][2].getState();
    }
  }
  return 0;
}


public boolean makeMove(int paramInt1, int paramInt2) {
  byte b1 = 0, b2 = 0;
  
  if (paramInt1 < 1 || paramInt1 > 9) return false; 
  if (paramInt1 == 1) { b1 = 0; b2 = 0; }
   if (paramInt1 == 2) { b1 = 0; b2 = 1; }
   if (paramInt1 == 3) { b1 = 0; b2 = 2; }
   if (paramInt1 == 4) { b1 = 1; b2 = 0; }
   if (paramInt1 == 5) { b1 = 1; b2 = 1; }
   if (paramInt1 == 6) { b1 = 1; b2 = 2; }
   if (paramInt1 == 7) { b1 = 2; b2 = 0; }
   if (paramInt1 == 8) { b1 = 2; b2 = 1; }
   if (paramInt1 == 9) { b1 = 2; b2 = 2; }
  
  if (this.blocks[b1][b2].getState() == 0) {
    
    this.blocks[b1][b2].setState(paramInt2);
    return true;
  } 

  
  return false;
}
}