
import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class Solution {
  
 public static List<String> wrapLines(String[] words, int maxLen) {
   
   ArrayList<String> totalLines = new ArrayList<>();
   StringBuilder currentLine = new StringBuilder();
   
   for(String word: words) {
     if(currentLine.length() + (currentLine.length() > 0 ? 1 : 0) + word.length() <= maxLen) { 
       if(currentLine.length() > 0) {
         currentLine.append("-");
       } 
       currentLine.append(word);
       } else {
         totalLines.add(currentLine.toString());
         currentLine = new StringBuilder(word);
       }
       
   }
   
   if(currentLine.length() > 0) {
     totalLines.add(currentLine.toString());
   }
   
   return totalLines;
   
 }
  
  public static void main(String[] argv) {
    String[] words1 = {"The","day","began","as","still","as","the","night","abruptly","lighted","with","brilliant","flame"};
    String[] words2 = {"Hello"};
    String[] words3 = {"Hello", "Hello"};
    String[] words4 = {"Well", "Hello", "world"};
    String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
    String[] words6 = {"a", "b", "c", "d"};
    
    System.out.println(wrapLines(words1, 13));
    System.out.println(wrapLines(words1, 12));
    System.out.println(wrapLines(words1, 20));
    System.out.println(wrapLines(words2, 5));
    System.out.println(wrapLines(words2, 30));
    System.out.println(wrapLines(words3, 5));
    System.out.println(wrapLines(words4, 5));
    System.out.println(wrapLines(words5, 20));
    System.out.println(wrapLines(words6, 20));
    System.out.println(wrapLines(words6, 4));
    System.out.println(wrapLines(words6, 1));
    
  }
}
