import java.util.Arrays;

public class ConwayLife {

  public static int[][] getGeneration(int[][] cells, int generations) {
    /*
    Takes an initial board state for Conway's game of life, in the form of a 2d array of ints, where 0 is a dead cell and 1 is a live cell
    The progress of the board is taken following the rules of Conway's game of life for the given number of generations
    Returns a 2d array of ints showing the final state of the board
    */
    int[][] newCells = new int[cells.length+2][cells[0].length+2];
    for(int g = 1; g <= generations; g++) {
      for(int y = 0; y < cells.length; y++) {
        for(int x = 0; x < cells[0].length; x++) {
          newCells[y+1][x+1] = progressCell(cells, x, y);
        }
      }
      //Check borders to expand field.
      for(int y = 0; y < newCells.length; y++) {
        newCells[y][0] = progressCell(cells, -1, y-1);
        newCells[y][newCells[0].length-1] = progressCell(cells, newCells[0].length-2, y-1);
      }
      for(int x = 0; x < newCells[0].length; x++) {
        newCells[0][x] = progressCell(cells, x-1, -1);
        newCells[newCells.length-1][x] = progressCell(cells, x-1, newCells.length-2);
      }
      cells = cropField(newCells);
      newCells = new int[cells.length+2][cells[0].length+2];
    }
    //Crop field to what is populated
    cells = cropField(cells);
    return cells;
  }
  
  private static int progressCell(int[][] cells, int x, int y) {
    /*
    Takes the current board position, and the position of a single cell
    Returns the state of the given cell for the next board state, based on the rules for Conway's game of life
    */
    int numNeighbors = 0;
    boolean alive = false;
    for(int i = -1; i <= 1; i++) {
      for(int j = -1; j <= 1; j++) {
        if(y+i >= 0 && x+j >= 0 && y+i < cells.length && x+j < cells[0].length && cells[y+i][x+j] == 1) {
          if(i == 0 && j == 0) {alive = true;}
          else numNeighbors++;
        }
      }
    }
    if(numNeighbors == 3) {return 1;}
    if(alive && numNeighbors == 2) {return 1;}
    return 0;
  }

  private static int[][] cropField(int[][] cells) {
    /*
    Takes the current board and crops it to remove and rows or columns without any living cells
    Returns the cropped board with the same pattern, but no empty rows/columns along the borders
    */
    int[] zeroes = new int[cells[0].length];
    boolean x0Empty = true; boolean xEndEmpty = true;
    while(Arrays.equals(cells[0],zeroes)) {
      cells = Arrays.copyOfRange(cells, 1, cells.length);
    }
    while(Arrays.equals(cells[cells.length-1],zeroes)) {
      cells = Arrays.copyOfRange(cells, 0, cells.length-1);
    }
    while(x0Empty || xEndEmpty) {
      for(int y = 0; y < cells.length; y++) {
        if(cells[y][0] != 0) {x0Empty = false;}
        if(cells[y][cells[y].length-1] != 0) {xEndEmpty = false;}
      }
      if(x0Empty) {
        for(int y = 0; y < cells.length; y++) {
          cells[y] = Arrays.copyOfRange(cells[y] , 1, cells[y].length);
        }
      }
      if(xEndEmpty) {
        for(int y = 0; y < cells.length; y++) {
          cells[y] = Arrays.copyOfRange(cells[y] , 0, cells[y].length-1);
        }
      }
    }
    return cells;
  }
}