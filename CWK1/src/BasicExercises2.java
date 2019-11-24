import java.util.Scanner;
public class BasicExercises2 {
	 public static void main(String[] args) {
        
	        Scanner UserInput = new Scanner(System.in);
	        
	        System.out.println("Enter first string: ");
	        String string1 = UserInput.nextLine();
	        
	        System.out.println("Enter second string: ");
	        String string2 = UserInput.nextLine();
	        // reference link: https://www.geeksforgeeks.org/java-string-indexof/ Number 3
	        if (string2.indexOf(string1) != -1) { // String indexOf(String str) : This method returns the index within this string of the first occurrence of the specified substring. If it does not occur as a substring, -1 is returned.
	            System.out.println(string1 + " is a substring of " + string2);
	        }
	        else{
	            System.out.println(string1 + " is not a substring of " + string2);
	        }
	    }
}
