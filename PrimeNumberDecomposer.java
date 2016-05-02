import java.util.Arrays;

class PrimeNumberDecomposer {
  /**
     Return value: List of all prime factors of a given number n
  */
  public static Long[] getAllPrimeFactors(long n) {
    if(n <= (long)0) {return new Long[] {};}
    if(n == (long)1) {return new Long[] {(Long)(long)1};}
    Long[] primeFactors = new Long[(int)Math.sqrt(n)];
    long currentval = n;
    int count = 0;
    for(int i = 2; i<=currentval; i++) {
      if(currentval%i == 0) {
        primeFactors[count] = (Long)(long)i;
        count++;
        currentval = currentval/i;
        i--; //Decrement counter, to check for multiple of the same factor.
        if(currentval ==1) {break;}
      }
    }
    return Arrays.copyOf(primeFactors,count);
  }
  /**
     Return value: List containing two lists, first containg all prime factors without duplicates,
     second containing the count, how often each prime factor occured.
     Return code always contains two lists.
     
     e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 5 occurs 2 times, 
  */
  public static Long[][] getUniquePrimeFactorsWithCount(long n) {
    if(n <= (long)0) {return new Long[][] {{},{}};}
    if(n == (long)1) {return new Long[][] {{(Long)(long)1},{(Long)(long)1}};}
    Long[] factors = getAllPrimeFactors(n);
    Long[] uniqueFactors = new Long[factors.length];
    Long[] counts = new Long[factors.length];
    int factorCount = 1;
    int numOfFactors = 0;
    for(int i = 0; i < factors.length; i++) {
      if(i+1 < factors.length && factors[i] == factors[i+1]) { //First check ensures don't run off the array.
        factorCount++;
      }
      else {
        uniqueFactors[numOfFactors] = factors[i];
        counts[numOfFactors] = (Long)(long)factorCount;
        numOfFactors++;
        factorCount = 1;
      }
    }
    return new Long[][] {Arrays.copyOf(uniqueFactors,numOfFactors),Arrays.copyOf(counts,numOfFactors)};
  }
  /**
     Return value: List containing product of same prime factors,
     e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
  */
  public static Long[] getPrimeFactorPotencies(long n) {
    if(n <= (long)0) {return new Long[] {};} //Edge cases
    if(n == (long)1) {return new Long[] {(Long)(long)1};}
    Long[][] factorPowers = getUniquePrimeFactorsWithCount(n);
    Long[] answer = new Long[factorPowers[0].length];
    for(int i = 0; i < factorPowers[0].length; i++) {
      answer[i] = (Long)(long)Math.pow(factorPowers[0][i],factorPowers[1][i]);
    }
    return answer;
  }
}