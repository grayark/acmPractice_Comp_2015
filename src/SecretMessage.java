import java.util.Scanner;

/**
 * Created by gray on 15-10-03.
 */

//import java.util.*;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner theScanner = new Scanner(System.in);

        int n = theScanner.nextInt();
        theScanner.nextLine();
        for(int l = 0; l < n; l++) {
            String line = theScanner.nextLine();
            int square = 1;
            int dim = 1;
            for(int i = 1; (i * i) < line.length(); i++) {
                dim = i + 1;
            }

            char[][] matrix = new char[dim][];
            for(int i = 0; i < dim; i++) {
                matrix[i] = new char[dim];
            }

            int index = 0;
            for(int i = 0; i < dim; i++) {
                for(int j = 0; j < dim; j++) {
                    if(index < line.length()) {
                        matrix[i][j] = line.charAt(index);
                        index += 1;
                    }
                    else {
                        matrix[i][j] = '*';
                    }
                }
            }

            for(int j = 0; j < dim; j++) {
                for (int i = dim - 1; i >= 0; i--) {
                    if(matrix[i][j] != '*') {
                        System.out.print(matrix[i][j]);
                    }
                }
            }

            System.out.println();
        }
    }
}
