import java.util.ArrayList;
public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
	if(size >= 0) {
		board = new int[size][size];
	}
  }

  private boolean addQueen(int r, int c) {
	if(board[r][c] == 0) {
		board[r][c] = -1;
		markSpots(r,c,1);
		return true;
	}
	else {
		return false;
	}
  }

  private boolean removeQueen(int r, int c) {
	if(board[r][c] == -1) {
		board[r][c] = 0;
		markSpots(r,c,-1);
		return true;
	}
	else {
		return false;
	}
  }

  private void markSpots(int r, int c, int shift) {
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

  private int[][] copy(int[][] ary) {
	int[][] out = new int[ary.length][ary.length];
	for(int r = 0;r<ary.length;r++) {
      for(int c = 0;c<ary[r].length;c++) {
		out[r][c] = ary[r][c];
	  }
	}
	return out;
  }

  private void solveH(ArrayList<int[][]> ary,int r,int c) {
	if(c == board.length-1 && r<board.length && board[r][c] == 0) {
		addQueen(r,c);
		ary.add(copy(board));
		removeQueen(r,c);
		solveH(ary,r+1,c);
	}
	if(c != board.length-1 && r<board.length && board[r][c] == 0) {
		addQueen(r,c);
		solveH(ary,0,c+1);
		removeQueen(r,c);
		solveH(ary,r+1,c);
	}
	if(r<board.length && board[r][c] != 0) {
		solveH(ary,r+1,c);
	}
  }

  public boolean solve() {
	board = new int[board.length][board.length];
	ArrayList<int[][]> solutions =  new ArrayList<int[][]>();
    solveH(solutions,0,0);
    if(solutions.size() > 0) {
      board = solutions.get(0);
      return true;
    }
    else {
      return false;
    }
  }

  public int countSolutions() {
	board = new int[board.length][board.length];
    ArrayList<int[][]> solutions =  new ArrayList<int[][]>();
    solveH(solutions,0,0);
    return solutions.size();
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

}
