import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static long MOD = 1000000007;
    public static long[][] origin = {{1,1}, {1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long[][] A = {{1,1}, {1,0}};
        /*
         *                n
         *       | 1   1 |    | F(n+1)  F(n)  |
         * A^n = |       |  = |               |
         *       | 1   0 |    |  F(n)  F(n-1) |
         */
        System.out.println(pow(A, N-1)[0][0]);
    } 

    public static long[][] pow(long[][] A, long exp) {
        if(exp <= 1) return A;

        long[][] temp = pow(A, exp/2);

        temp = multiple(temp, temp);

        if(exp % 2 == 1) temp = multiple(temp, origin);
        return temp;
    }

    public static long[][] multiple(long[][] o1, long[][] o2) {
        long[][] temp = new long[2][2];
        temp[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        temp[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        temp[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        temp[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
        return temp;
    }
}