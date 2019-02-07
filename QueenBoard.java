public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
	if(size >= 0) {
		board = new int[size][size];
	}
  }
  
  public boolean addQueen(int r, int c) {
	if(board[r][c] == 0) {
		board[r][c] == -1;
		markSpots(r,c,1);
		return true;
	}
	else {
		return false;
	}
  }
  
  public boolean removeQueen(int r, int c) {
	if(board[r][c] == -1) {
		board[r][c] == 0;
		markSpots(r,c,-1);
		return true;
	}
	else {
		return false;
	}
  }

  public void markSpots(int r, int c, int shift) {
    for(int s = 1;r+s >= 0 && r+s < board.length && c+s >= 0 && c+s < board[0].length;s++) {
      board[r+s][c+s] += shift;
    }
    for(int s = 1;r-s >= 0 && r-s < board.length && c+s >= 0 && c+s < board[0].length;s++) {
      board[r-s][c+s] += shift;
    }
    for(int s = 1;c+s >= 0 && c+s < board[0].length;s++) {
      board[r][c+s] += shift;
    }
  }
  
  


  public String toString() {
    String out = "";
    for(int r = 0;r<board.length;r++) {
      for(int c = 0;c<board[r].length;c++) {
        if(board[r][c] == -1) {
			out += "Q ";
		}
		else {
			out += "_ ";
		}
      }
	  if(r != board.length-1) {
		out += "\n";
	  }
    }
	return out;
  }

  public static void main(String[] args) {
	  QueenBoard board = new QueenBoard(6);
	  System.out.println(board);
	  board.markSpots(2,2,1);
	  System.out.println(board);
  }




}
