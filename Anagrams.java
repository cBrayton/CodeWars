import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
  public BigInteger listPosition(String word) {
/*
Finds the position of the given word in an alphabetical list of all the possible anagrams made from the word (including non-words).
Takes a string as the word
Returns a BigInteger representing the words position in the list.
*/
    BigInteger sum = BigInteger.ZERO;
    char[] letters = word.toCharArray();
    int numLettersBefore = 0;
    for(int i = 0; i < letters.length-1; i++) { //Look through the word and count number of letters that occur earlier in the alphabet than the current letter
      for(int j = i+1; j < letters.length; j++) {
        if(letters[i] > letters[j]) {numLettersBefore++;}
      }
      char[] sortedLetters = Arrays.copyOfRange(letters, i, letters.length);
      Arrays.sort(sortedLetters);
      int[] uniqueLetterCount = countDuplicates(sortedLetters);
      //Multiply the number of letters that occur before the current letter by the number of anagrams that can be made with all remaining letters.
      //Anagram formula is n!/m1!m2!m3!... = (sortedLetters.length-1)!/uniqueLetterCount!
      sum = sum.add(BigInteger.valueOf((long)numLettersBefore).multiply(permutations(sortedLetters.length-1,uniqueLetterCount)));
      numLettersBefore = 0;
    }
    return sum.add(BigInteger.ONE); //add one because 1-indexed.
  }

  private BigInteger factorial(int n) {
/*
Finds the factorial of n, with the difference that 0! = 0 instead of 1.
*/
  //not quite factorial since 0! technically equals 1, but I need it to be 0.
    if(n == 0) {return BigInteger.ZERO;}
    BigInteger product = BigInteger.ONE;
    for(int i = n; i > 0; i--) {
      product = product.multiply(BigInteger.valueOf((long)i));
    }
    return product;
  }

  private BigInteger permutations(int n, int[] m) {
/*
The number of permutations possible for a word of lenght n with letter repetitions given by the array m.
Uses the formula n!/m1!m2!m3!...etc.
Returns a BigInteger
*/
    if(n == 0) {return BigInteger.ZERO;}
    BigInteger product = BigInteger.ONE;
    for(int i = n; i > 0; i--) {
      product = product.multiply(BigInteger.valueOf((long)i));
    }
    for(int i =0; i < m.length; i++) {
      product = product.divide(factorial(m[i]));
    }
    return product;
  }

  private int[] countDuplicates(char[] sortedLetters) {
/*
Returns an array of ints that lists the number of occurrences of each letter in a sorted list of letters.
The input array needs to be sorted.
The returned array doesn't specify what letters have which counts, only the count of each separate letter.
*/
    char lastLetter = sortedLetters[0];
    int[] counts = new int[sortedLetters.length];
    int currentCount = 1;
    int numUniqueLetters = 0;
    for(int i = 1; i < sortedLetters.length; i++) {
      if(sortedLetters[i] == lastLetter) {
        currentCount++;
        }
      if(sortedLetters[i] != lastLetter) {
        counts[numUniqueLetters] = currentCount;
        currentCount = 1;
        lastLetter = sortedLetters[i];
        numUniqueLetters++;
      }
    }
    counts[numUniqueLetters] = currentCount;
    return Arrays.copyOf(counts,numUniqueLetters+1);
  }
  
}