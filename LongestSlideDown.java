import java.util.Arrays;

public class LongestSlideDown {
 
    public static int longestSlideDown(int[][] pyramid) {
/*
Takes a pyramid shaped array of integer arrays of the form [row][column] with [0][0] at the top of the pyramid.
The function finds the path from the top to the bottom of the pyramid with the highest sum.
*/
      for(int i = pyramid.length-1; i > 0; i--) {
        for(int j = 0; j < pyramid[i].length-1; j++) {
          if(pyramid[i][j] > pyramid[i][j+1]) {
            pyramid[i-1][j] += pyramid[i][j];
          }
          else pyramid[i-1][j] += pyramid[i][j+1];
        }
      }
      return pyramid[0][0];
    }
}