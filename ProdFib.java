public class ProdFib {	
	
	public static long[] productFib(long prod) {
/*
Determines if two consecutive Fibonacci numbers can be multiplied together to equal prod.
Returns the two Fibonacci numbers and 1 if possible e.g. productFib(6) = [2, 3, 1]
Otherwise returns the two Fibonacci numbers that have a product closest to prod and 0 e.g. productFib(7) = [2, 3, 0]
*/
    long lowFib = 0; long hiFib = 1;
    long[] ans = new long[3];
    while(lowFib*hiFib <= prod) {
      if(lowFib * hiFib == prod) {
        ans[0] = lowFib; ans[1] = hiFib; ans[2] = 1;
        return ans;
      }
      hiFib += lowFib;
      lowFib = hiFib - lowFib;
    }
    ans[0] = lowFib; ans[1] = hiFib; ans[2] = 0;
		return ans;
   }
}