public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private void markSpots(int r, int c, int shift) {
    for(int s = 1;r+s >= 0 && r+s < board.length && c+s >= 0 && c+s < board[0].length;s++) {
      board[r+s][c+s] += shift;
    }
    for(int s = 1;r+s >= 0 && r+s < board.length && c+s >= 0 && c+s < board[0].length;s++) {
      board[r-s][c+s] += shift;
    }
    for(int s = 1;c+s >= 0 && c+s < board[0].length;s++) {
      board[r][c+s] += shift;
    }
  }








}
