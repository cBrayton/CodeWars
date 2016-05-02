import java.lang.StringBuilder;
import java.util.Arrays;
public class CompleteThePattern {
    public static String pattern ( int n) {
/*
Takes a number, n, and returns a multiline string with a pattern based on the number.
The pattern is a list of all numbers from n to 1 on the first line,
with every subsequent line removing the lowest number from the end.
*/
         //Happy Coding ^_^
      if (n<1) {return "";}
      StringBuilder numbers = new StringBuilder();
      StringBuilder patternString = new StringBuilder();
      for (int i=0; i<n; i++) {
        numbers.append(n-i);
        patternString.insert(0,numbers.toString()+"\n");
      }
      patternString.deleteCharAt(patternString.lastIndexOf("\n"));
      return patternString.toString();
    }
}