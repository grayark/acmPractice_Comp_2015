import java.util.*;

public class SimonSays {

    public static void main(String[] args) {
        Scanner theScanner = new Scanner(System.in);
        int n = theScanner.nextInt();
        theScanner.nextLine();
        for(int i = 0; i < n; i++) {
            String simon = theScanner.next();
            if(simon.equals("Simon")) {
                String says = theScanner.next();
                if(says.equals("says")) {
                    String rest = theScanner.nextLine();
                    System.out.println(rest);
                }
                else {
                    theScanner.nextLine();
                }
            }
            else {
                theScanner.nextLine();
            }
        }

	}
}
