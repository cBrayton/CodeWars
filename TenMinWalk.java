public class TenMinWalk {
  public static boolean isValid(char[] walk) {
/*
Tests whether a walk is 10 blocks long, ends where it began, and only travels in the cardinal directions.
Input is an array of lower case characters representing the cardinal directions (n,s,e,w).
*/
    if (walk.length != 10) {return false;}
    int up = 0; int right = 0;
    for (int i=0; i<10; i++) {
      switch (walk[i]) {
        case (char)'n' : up += 1;
          break;
        case (char)'s': up += -1;
          break;
        case (char)'e': right += 1;
          break;
        case (char)'w': right += -1;
          break;
        default: return false;
        }
    }
   return up==right && up==0 ? true : false;
  }
}