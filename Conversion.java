public class Conversion {

    public String solution(int n) {
/*
Takes an integer and outputs a string representing that integer in Roman numerals.
(This only produces accurate answers up to n = 3999.)
*/
        StringBuilder sol = new StringBuilder();
        while(n > 0) {
          if(n >= 1000) {sol.append("M"); n -= 1000;}
          else if(n >= 900) {sol.append("CM"); n -= 900;}
          else if(n >= 500) {sol.append("D"); n -= 500;}
          else if(n >= 400) {sol.append("CD"); n -= 400;}
          else if(n >= 100) {sol.append("C"); n -= 100;}
          else if(n >= 90) {sol.append("XC"); n -= 90;}
          else if(n >= 50) {sol.append("L"); n -= 50;}
          else if(n >= 40) {sol.append("XL"); n -= 40;}
          else if(n >= 10) {sol.append("X"); n -= 10;}
          else if(n >= 9) {sol.append("IX"); n -= 9;}
          else if(n >= 5) {sol.append("V"); n -= 5;}
          else if(n >= 4) {sol.append("IV"); n -= 4;}
          else if(n >= 1) {sol.append("I"); n -= 1;}
        }
        return sol.toString();
    }
}