import java.util.List;
import java.util.ArrayList;

public class Josephus {
  public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
/*
This method takes a list of objects and an integer, and returns the objects in a reordered list.
The returned list is ordered by every kth element of the first list, cycling until the initial list is used up.
e.g. josephusPermutation({1,2,3,4,5,6,7},3) = {3,6,2,7,5,1,4}
*/
    int current = 0;
    List<T> answer= new ArrayList<T>();
    while (items.size() > 0) {
      current = (current-1+k)%items.size();
      answer.add(items.remove(current));
      }
    return answer;
  }
}