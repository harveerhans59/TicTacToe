
class block
implements global
{
private int state = 0;

public boolean setState(int paramInt) {
  if (isValidState(paramInt)) {
    
    this.state = paramInt;
    return true;
  } 

  return false;
}

public int getState() { return this.state; }

public boolean isValidState(int paramInt) { return (paramInt == 2 || paramInt == 1); }

public String toString() {
  if (this.state == 0)
    return " "; 
  if (this.state == 1) {
    return "x";
  }
  return "o";
}
}
