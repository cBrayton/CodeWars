public class DRoot {
  public static int digital_root(int n) {
/*
Finds the digital root of n by recursively summing the digits of n until the sum is only 1 digit
Returns the single digit root of n
e.g digital_root(12345) = 6 (1+2+3+4+5=15 -> 1+5 = 6) 
*/
    char[] digits = new Integer(n).toString().toCharArray();
    int sum = 0;
    while(digits.length > 1) {
      sum = 0;
      for (int i = 0; i<digits.length; i++) {
        sum += Character.getNumericValue(digits[i]);
      }
      digits = new Integer(sum).toString().toCharArray();
    }
    return sum;
  }
}