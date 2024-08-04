import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static int[] weight, arr;
    static boolean[] notPrime;
    static Set<Integer> sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N];
        arr = new int[M];
        sum = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, 0);
        int minSum = Collections.min(sum);
        int maxSum = Collections.max(sum);
        notPrime = new boolean[maxSum + 1];
        checkPrime(minSum, maxSum);

        StringBuilder sb = new StringBuilder();
        for (int x : sum) {
            if (!notPrime[x]) {
                sb.append(x).append(" ");
            }
        }

        if (sb.length() > 0) System.out.println(sb);
        else System.out.println(-1);
    }
    static void permutation(int idx, int depth) {
        if (depth == M) {
            sum.add(Arrays.stream(arr).sum());
            return;
        }
        for (int i = idx; i < N; i++) {
            arr[depth] = weight[i];
            permutation(i + 1, depth + 1);
        }
    }
    static void checkPrime(int min, int max) {
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}