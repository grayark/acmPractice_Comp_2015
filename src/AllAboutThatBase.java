import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by gray on 15-10-03.
 */
public class AllAboutThatBase {
    static HashMap<Character, Integer> characterToInt = new HashMap<Character, Integer>();
    static String intToCharacter = "0123456789abcdefghijklmnopqrstuvwxyz";

    static Long ParseLong(String s, int base) {
        if(base == 1) {
            if(s.matches("1+")) {
                return (long)s.length();
            } else {
                return null;
            }
        } else {
            long sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int value = characterToInt.get(c);
                sum *= base;
                if (value < base) {
                    sum += value;
                } else {
                    return null;
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 36; i++) {
            characterToInt.put(intToCharacter.charAt(i), i);
        }

        Scanner theScanner = new Scanner(System.in);
        int n = theScanner.nextInt(); theScanner.nextLine();
        for(int casenum = 0; casenum < n; casenum++) {
            String[] parts = theScanner.nextLine().split(" ");
            boolean invalid = true;
            StringBuilder valids = new StringBuilder();
            for(int i = 1; i <= 36; i++) {
                Long a = ParseLong(parts[0], i);
                Long b = ParseLong(parts[2], i);
                Long c = ParseLong(parts[4], i);
                if(a == null || b == null || c == null) {
                    continue;
                } else {
                    String op = parts[1];
                    double left = 0.0;
                    double right = (double)c;
                    if(op.equals("+")) {
                        left = (double)a + (double)b;
                    } else if(op.equals("-")) {
                        left = (double)a - (double)b;
                    } else if(op.equals("*")) {
                        left = (double)a * (double)b;
                    } else if(op.equals("/")) {
                        left = (double)a / (double)b;
                    }

                    if(left == right) {
                        if(i == 36) {
                            valids.append('0');
                        } else {
                            valids.append(intToCharacter.charAt(i));
                        }
                        invalid = false;
                    }
                }
            }
            if(invalid) {
                System.out.println("invalid");
            } else {
                System.out.println(valids.toString());
            }
        }
    }
}
