public class Xbonacci {

  public double[] xbonacci(double[] signature, int n) {
/*
Takes a signature of X doubles as a starting seed for a variant fibonacci sequence that sums the previous X elements.
Returns the first n elements of the sequence, including the signature.
If n is less than the number of elements in the signature, then only the first n elements of the signature are returned.
*/
      // hackonacci me
      int sigLength = signature.length;
      double[] seq = new double[n];
      double sum = 0;
      for(int i = 0; i<sigLength && i<n; i++) {
        seq[i] = signature[i];
        sum += signature[i];
      }
      for(int i = sigLength; i<n; i++) {
        seq[i]=sum;
        sum = sum*2 - seq[i-sigLength]; 
      }
      //System.out.printf("Final value is %f",seq[n-1]);
      return seq;
  }
}