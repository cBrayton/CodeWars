import java.util.Arrays;

public class Decompose {

  public String decompose(long n) {
/*
Takes an integer n, squares n then finds a list of other squares that sum to n^2
Returns a string of strictly increasing numbers that when squared add up to n^2
e.g. decompose(11) = "1 2 4 10" (121 = 1+4+16+100)
*/
    StringBuilder ans = new StringBuilder();
    long temp = n*n;
    long test = n-1;
    while(temp > 0) {
      if(test <= 1 && temp > 1) { //check for impossible/incorrect solution
        test = Long.valueOf(ans.substring(0,ans.indexOf(" ")));
        temp += test*test;
        test--;
        ans.delete(0,ans.indexOf(" ")+1);
      }
      else if(test*test <= temp && test > 0) { //use test value if possible
        temp -= test*test;
        ans.insert(0, String.valueOf(test)+" ");
        test = Math.min((long)Math.floor(Math.sqrt(temp)),test-1);
      }
      else test--;
      if(temp == 0) { //success
        return ans.toString().trim();
      }
    }
    return ans.toString().trim();
  }
}