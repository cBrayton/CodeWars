import java.lang.Exception.*;

public class User {
/*
Class sets up a rank based user system. Ranks can range from -8 to 8 excluding 0.
Progress between ranks is measured on a scale from 0 to 100.
e.g. Rank 8 Progress 100 rolls over to Rank 7 Progress 0
Progress is achieved by completing "acts" with their own ranks from -8 to 8 excluding 0.
An act 1 less than the current user rank is worth 1 progresss point;
an act equal to the current rank is worth 3 progress points,
and acts higher than the current rank are worth the difference in ranks squared times 10.
e.g. A rank -7 user completes a rank -3 act and gains (4*4)*10=160 progress for 1 rank and 60 progress.
*/
  public int rank =-8;
  public int progress =0;  
  
  public void incProgress(int act) {
    int exp=0;
    if (act < -8 || act > 8 || act == 0) {throw new IllegalArgumentException();}
    if (act > 0 && rank < 0) {act--;}
    if (act < 0 && rank > 0) {act++;}
    switch (act - rank) {
      case -1: exp = 1; break;
      case 0: exp = 3; break;
      case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
      case 9: case 10: case 11: case 12: case 13: case 14: case 15:
        exp = 10* (rank-act)*(rank-act); break;
      default: exp = 0;break;
      }
    progress += exp;
    if (progress > 100) {
      if (rank < 0 && rank + progress/100 >= 0) {rank++;}
      rank = rank + progress/100;
      progress= progress%100;
    }
    if (rank ==0) {rank++;}
    if (rank ==8) {progress = 0;}
    return;
  }
}