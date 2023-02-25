import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean[] notPrime;
    static ArrayList<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 4,000,000)
        notPrime = new boolean[N+1];
        isPrime();

        int result = 0;
        int point1 = 0;
        int point2 = 0;
        int sum = 0;

        while(true) {
            if(sum >= N) sum -= primeList.get(point1++);
            else if(point2 >= primeList.size()) break;
            else sum += primeList.get(point2++);

            if(sum == N) result++;
        }
        System.out.println(result);
    }
    private static void isPrime() {
        for(int i=1; i<=Math.sqrt(N); i++) {
            if(i <= 1) notPrime[i] = true;
            if(notPrime[i]) continue;
            for(int j=i+i; j<=N; j+=i) {
                notPrime[j] = true;
            }
        }
        for(int i=1; i<=N; i++) {
            if(!notPrime[i]) primeList.add(i);
        }
    }
}