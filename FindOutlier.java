public class FindOutlier{
  static int find(int[] integers){
/*
This takes an array of integers that are all even or all odd except for one.
This returns the value of the parity outlier.
*/
  int even = 0; int odd = 0; int i = 0; int numEven = 0;
  while ((even == 0 || odd ==0) && i < integers.length) {
    if (integers[i]%2 == 0) {
    even=i;
    numEven++;
    }
    else {odd=i;}
    i++;
  }
  return numEven > 1 ? integers[odd] : integers[even];
  }
}