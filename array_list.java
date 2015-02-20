import java.util.Scanner;
import java.util.*;
 
class array_list
{
   public static void main(String args[])
   {
    // create an array list
      ArrayList al = new ArrayList();
      System.out.println("Initial size of al: " + al.size());

      // add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");
      al.add(4,"A2");
      System.out.println("Size of al after additions: " + al.size());

      // display the array list
      System.out.println("Contents of al: " + al);
      // Remove elements from the array list
      al.remove("F");
      al.remove(2);
      System.out.println("Size of al after deletions: " + al.size());
      System.out.println("Contents of al: " + al);
	  
	  String sss="A2";
	  int indu=al.indexOf(sss);
	  System.out.println("\n\n\nindu   "+indu);
	  
	  char[] charArrays = new char[] {'1', '2', '3', 'A', 'B', 'C'};
 
		String newString1 = new String(charArrays);
		System.out.println("newString1 : " + newString1);
}
   
  }