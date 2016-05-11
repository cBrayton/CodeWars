import java.util.List;
import java.util.Arrays;

public class Consecutives {
    
    public static List<Integer> sumConsecutives(List<Integer> s) {
/*
Takes a list of Integers, then adds together any consecutive repeats
Returns a list of Integers with all consecutive numbers added together
e.g. sumConsecutives({1, 1, 1, 3, 5, 5, 6, 5}) = {3,3,10,6,5}
*/
        Integer[] ans = new Integer[s.size()];
        int j = 0; int count = 1;
        for(int i = 0; i < s.size(); i++) {
          if(i+1 < s.size() && s.get(i) == s.get(i+1)) {count++;}
          else {
            ans[j++] = new Integer(s.get(i)*count);
            count = 1;
          }
        }
        return Arrays.asList(Arrays.copyOf(ans,j));
    }

}