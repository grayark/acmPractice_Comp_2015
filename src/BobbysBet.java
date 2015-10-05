import java.util.Scanner;

/**
 * Created by gray on 15-10-03.
 */
public class BobbysBet {
    static double ComputeP(int R, int S) {
        double s = (double)S;
        double r = (double)R;
        return ((s + 1) - r) / s;
    }

    static double ComputeSum(int x, int y, double p) {
        double sum = 0.0;
        for(int i = x; i <= y; i++) {
            double chance = NChooseK(y, i) * Math.pow(p, (double)i) * Math.pow(1.0 - p, y - i);
            sum += chance;
        }
        return sum;
    }

    static int NChooseK(int n, int k) {
        int result = 1;
        for(int i = k+1; i <= n; i++) {
            result *= i;
        }
        for(int i = 2; i <= (n-k); i++) {
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner theScanner = new Scanner(System.in);
        int n = theScanner.nextInt();
        for(int c = 0; c < n; c++) {
            int R = theScanner.nextInt();
            int S = theScanner.nextInt();
            int X = theScanner.nextInt();
            int Y = theScanner.nextInt();
            int W = theScanner.nextInt();

            double p = ComputeP(R, S);
            double sum = ComputeSum(X, Y, p);
            if((sum * W) > 1.0000005) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
