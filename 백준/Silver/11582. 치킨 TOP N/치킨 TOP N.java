import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            original.add(Integer.parseInt(st.nextToken()));
        }
        int K = Integer.parseInt(br.readLine());
        int M = N / K;

        for (int i = 0; i < K; i++) {
            ArrayList<Integer> partList = new ArrayList<>(original.subList(M*i, M*(i+1)));
            Collections.sort(partList);
            result.addAll(partList);
        }

        for (int x : result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}