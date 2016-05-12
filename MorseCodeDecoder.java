import java.util.Dictionary;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
/*
Decodes the bits of a morse code message.
Takes a string of 0's and 1's representing a morse code message
The sampling frequency of the message is unknown, so while standard dots would be "1" and dashes would be "111",
in a given message every ., -, or pause could be scaled up based on an unknown sample rate.
Returns a string of .'s and -'s represented by the string of bits.
*/
      bits = bits.replace("0", " ").trim().replace(" ", "0");
      String[] symbols = bits.split("0+");
      String[] spaces = bits.split("1+");
      StringBuilder message = new StringBuilder();
      int rate = Integer.MAX_VALUE;
      for(int i = 0; i < symbols.length; i++) {
        if(symbols[i].length() > 0 && symbols[i].length() < rate) {rate = symbols[i].length();}
      }
      //Checks the blank spaces for rate. Needed if message consists of only dashes
      for(int i = 0; i < spaces.length; i++) {
        if(spaces[i].length() > 0 && spaces[i].length() < rate) {rate = spaces[i].length();}
      }
      for(int i = 0; i*rate < bits.length(); i++) {
        message.append(bits.charAt(i*rate));
      }
      return message.toString().replace("0", " ").trim().replace("111", "-").replace("1", ".");
    }
    
    public static String decodeMorse(String morseCode) {
/*
Takes a string of morse code in the format ". .   --       . - ."
Requires a dictionary MorseCode that contains keys of letters in morse code and values of the letters they represent
Returns a decoded text string
*/
      StringBuilder translation = new StringBuilder();
      String[] words = morseCode.split("       ");
      for(int j = 0; j < words.length; j++) {
        String[] characters = words[j].split("   ");
        for(int i = 0; i < characters.length; i++) {
          characters[i] = characters[i].replace(" ", "");
          translation.append(MorseCode.get(characters[i]));
        }
        translation.append(" ");
      }
      return translation.toString().trim();
    }
}