public class DigPow {
	
  public static long digPow(int n, int p) {
/*
This breaks a number n into its component digits, then raises each digit to consecutively higher powers p.
The sum of the digits raised to the powers is then taken and checked to see if it is a multiple of the original number n.
e.g. digPow(89, 1) = 1, since 8^1 + 9^2 = 89
Returns the multiple of n that is reached, or -1 if no multiple exists.
*/
    char[] digits = new Integer(n).toString().toCharArray();
    int sum = 0;
    for (int i = 0; i<digits.length; i++) {
      sum += Math.pow(Character.getNumericValue(digits[i]), p+i);
    }
    return sum%n == 0 ? sum/n : -1;
	}
	
}