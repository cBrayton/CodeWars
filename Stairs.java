public class Stairs {
  public static int NumberOfSteps(int n, int m)
  {
/*
Takes the number of stairs to go up n and the desired multiple of steps to take m.
Can go up stairs 1 or 2 stairs at a time per step, the goal is to go up with the least number of steps that is a multiple of m.
Returns the number of steps taken to go up n stairs (return value is a multiple of m).
*/
     if(n < m) {return -1;}
     if(n == m) {return m;}
     int steps = (n-m+1)/2;
     steps += m-(steps%m);
     if(steps*2 < n) {steps += m;} //correct for rounding error in int division
     return steps;
  }
}