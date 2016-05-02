public class ASum {
	
  public static long findNb(long m) {
/*
The goal is to find the number n of cubes needed to construct a tower of volume m.
The tower is made up of n cubes, where the bottom cube has side length n,
and every successive cube has a side length 1 less than the cube below it.
Returns the number of cubes to make a tower with volume m,
or -1 if a tower of volume m can't be created with these cubes.
*/
    long sum = 0;
    long count = 0;
    while (sum < m) {
      count +=1;
      sum += count*count*count;
    }
    if (sum == m) {
      return count;
      }
      else return -1;
	}	
}