import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DemsoAm {
	public static void NegativeNumberInStrings(String str) {
        // Regex explanation:
        // -     : matches the minus sign literally
        // \\d+  : matches one or more digits (0-9)
        String regex = "-\\d+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        
        System.out.print("Negative numbers found: ");
        boolean found = false;
        
        // Loop through the string to find all matches
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }
        
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
   	public static void main(String [] args) {
		 String input = "abc-5xyz-12k9l--p";
        
        System.out.println("Input String: " + input);
        NegativeNumberInStrings(input);

		
	}
}
