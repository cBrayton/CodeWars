public class PerfectPower {
  public static int[] isPerfectPower(int n) {
/*
Tests whether an integer n is a perfect power,
perfect powers are any integer that is an integer power of another integer
e.g. 4(2^2) 9(3^2) 27(3^3) 243(3^5) are all perfect powers
Returns a pair of integers [a,b] such that n = a^b.
(If multiple possible values for a and b exist, the pair with the smallest a value is returned)
*/
    int upperBound = (int)Math.sqrt(n);
    int tempN = n;
    int j = 0;
    for(int i = 2; i <= upperBound; i++) {
      while(tempN%i == 0 && tempN > 1) {
        tempN = tempN/i;
        j++;
      }
      if(tempN == 1) {return new int[] {i,j};}
      tempN = n;
      j = 0;
    }
    return null;
  }
}