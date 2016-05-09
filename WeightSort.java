import java.util.Hashtable;
import java.util.Arrays;
import java.util.LinkedList;

public class WeightSort {
	
	public static String orderWeight(String strng) {
/*
Takes a string of integers separated by spaces
Returns the same integers in a string sorted by the sum of their digits
e.g orderWeight("30 54 60 101") = "101 30 60 54"
*/
    if(!strng.trim().contains(" ")) {return strng;}
    System.out.println(strng);
    StringBuilder answer = new StringBuilder();
    String[] weights = strng.split(" ");
    long[] values = new long [weights.length];
    Hashtable<Long,LinkedList> strVal = new Hashtable();
    Arrays.sort(weights);
    for(int i = 0; i < weights.length; i++) {
      values[i] = Long.decode(weights[i]).longValue();
      int j = 1;
      int weight = 0;
      while(values[i]/Math.pow(10,j) > 0) {
        weight += (values[i]%Math.pow(10,j))/Math.pow(10,j-1);
        values[i] -= values[i]%Math.pow(10,j);
        j++;
      }
      values[i] = weight;
      LinkedList<String> val = new LinkedList();
      if(strVal.containsKey(values[i])) {
        val = strVal.get(values[i]);
      }
      val.add(weights[i]);
      strVal.put(values[i],val);
    }
    Arrays.sort(values);
    for(int i = 0; i < values.length; i++) {
      if(strVal.containsKey(values[i])) {
        for(int h = 0; h < strVal.get(values[i]).size(); h++) {
          answer.append(strVal.get(values[i]).get(h));
          answer.append(" ");
        }
        strVal.remove(values[i]);
      }
    }
    return answer.toString().trim();
	}
}