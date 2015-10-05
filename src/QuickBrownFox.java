/**
 * Created by gray on 15-10-03.
 */

import java.util.*;

public class QuickBrownFox {
    public static void main(String[] args) {
        Scanner theScanner = new Scanner(System.in);
        int n = theScanner.nextInt();
        theScanner.nextLine();
        for(int i = 0; i < n; i++) {
            String line = theScanner.nextLine();
            HashSet<Character> characters = new HashSet<Character>();
            for(int j = 0; j < line.length(); j++) {
                characters.add(Character.toLowerCase(line.charAt(j)));
            }
            StringBuilder builder = new StringBuilder();

            for(int j = 0; j < 26; j++) {
                char letter = (char)((int)'a' + j);
                if(!characters.contains(letter)) {
                    builder.append(letter);
                }
            }

            if(builder.length() < 1) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + builder.toString());
            }
        }
    }
}
