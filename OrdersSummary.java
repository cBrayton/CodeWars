public class OrdersSummary { 
	
  public static String balanceStatements(String lst) {
/*
The input is a list of stock orders of the format "StockName 300 12.0 B",
where 300 is the quanitity of stock, 12.0 is the price, and B indicates to buy (S for sell).
Any number of stock orders can be concatenated together with commas between orders.
The output is a summary of the amount of money spent buying and selling stock in the format Buy: 12 Sell: 0.
For any orders that do not match the required pattern, the badly formed orders will be appended to the output.
e.g. Buy: 12 Sell: 0; Badly formed Company 15.0 S
*/
    if (lst.length() == 0) {return "Buy: 0 Sell: 0";}
    String[] orders = lst.split(", ");
    StringBuilder bad = new StringBuilder("; Badly formed ");
    int numBad = 0;
    double buySum = 0; double sellSum = 0;
    for (String order : orders) {
      String[] words = order.split(" ");
      if (words.length != 4 || !words[0].matches("\\S+") || !words[1].matches("\\d+") || !words[2].matches("\\d*\\.\\d+") || !words[3].matches("B|S")) {
        numBad++;
        bad.append(order); bad.append(" ;");
      }
      else if (words[3].equals("B")) {
        buySum += Double.parseDouble(words[1]) * Double.parseDouble(words[2]);
      }
      else sellSum += Double.parseDouble(words[1]) * Double.parseDouble(words[2]);
    }
    bad.insert(15,numBad); bad.insert(16,": ");
    if (numBad == 0) {bad.delete(0,bad.length());}
    //Create the string with floats showing 0 decimal places to avoid rounding errors in cast to int.
    String summary = String.format("Buy: %.0f Sell: %.0f",buySum,sellSum) + bad.toString();
    return summary;
	}
}