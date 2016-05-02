public class DeltaBits {
    public static int convertBits(int a, int b) {
      //Counts the number of bits that would need to be flipped
      //to convert between a and b.
      int val = a^b;
      return Integer.bitCount(val);
    }
}