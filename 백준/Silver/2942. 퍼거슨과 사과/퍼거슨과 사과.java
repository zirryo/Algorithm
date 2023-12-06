import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int gcd = getGCD(R, G);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                list.add(i);
                if (gcd / i != i) {
                    list.add(gcd / i);
                }
            }
        }

        for (int x : list) {
            sb.append(x).append(" ").append(R / x).append(" ").append(G / x).append("\n");
        }

        System.out.println(sb);
    }
    private static int getGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (max % min == 0) return min;
        else return getGCD(max % min, min);
    }
}