import java.util.Arrays;
import java.util.*;

class GapInPrimes {
    
    public static long[] gap(int g, long m, long n) {
/*
Input is an int g for the size of the gap, and m and n for the range to look in for the prime gap.
Output is an array of two consecutive primes that have a gap of g, or null if no such primes exist.
*/
       long[] primes = generator(m,n);
       for (int i=0; i<primes.length-1;i++) {
         if(primes[i]>=m && primes[i]==primes[i+1]-g) {return Arrays.copyOfRange(primes,i,i+2);}
       }
       return null;
    }
    
    private static long[] generator(long m, long n) {
    //Seive took too long and wasn't reused appropriately during
    //testing. Will use a normal prime generator.
    long[] primes = new long[(int)(n-m)];
    int numPrimes = 0;
    boolean prime = true;
    for (int i =(int)m; i<(int)n; i++) {
      prime = true;
      for (int j = 2; j<Math.sqrt((double)i)+1;j++) {
        if(i%j==0) {prime=false; break;}
        }
      if(prime==true) {primes[numPrimes]=(long)i; numPrimes++;}
      }
    return Arrays.copyOfRange(primes,0,numPrimes);
    }
    
    private static long[] seive(long m, long n) {
    //NB: This is not used in the current version of GapInPrimes.
    //Create an array of primes up to the number n, which will
    //be used to check for prime gaps.
    //The array is trimmed to start at m.
    //This would work better if successive tests used the same seive.
    long[] primes = new long[(int)n/2+1];
    long j = 3;
    long newJ = 0;
    primes[0] = 1; primes[1]=2; //add special case primes
    for (int i = 2; i<=(int)(n+1)/2; i++){//populate array with odd numbers
      primes[i] = (long)(2*i)-1;
      }
   while (j<n) {
      for (int i = (int)n/2; primes[i]>j; i--){
        if (primes[i]%j==0) {
          primes[i]=0;
          }
        else if(primes[i] > j) {newJ = primes[i];}
        else continue;
        }
      Arrays.sort(primes);
      if(j == newJ) {j++;} else j=newJ;
      }
      for(int index = 0; index < n/2+1;index++) {
        if (primes[index]>=m) {
          primes = Arrays.copyOfRange(primes,index,(int)n/2+1);
          break;
        }
      }
    return primes;
    }
}