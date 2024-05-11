import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(arr)).append("\n");
        }
        System.out.println(sb);
    }
    private static int solve(int[] arr) {
        int[] fifth = new int[201];
        int[] playerCnt = new int[201];
        Map<Integer, Integer> rankSum = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int curTeam = arr[i];
            playerCnt[curTeam]++;
            if (playerCnt[curTeam] == 5) fifth[curTeam] = i;
        }
        int rank = 0;
        for (int x : arr) {
            if (playerCnt[x] < 6) continue;
            rank++;
            playerCnt[x]++;
            if (playerCnt[x] > 10) continue;
            rankSum.put(x, rankSum.getOrDefault(x, 0) + rank);
        }

        List<Map.Entry<Integer, Integer>> result = rankSum.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return fifth[o1.getKey()] - fifth[o2.getKey()];
            } else {
                return o1.getValue() - o2.getValue();
            }
        }).collect(Collectors.toList());

        return result.get(0).getKey();
    }
}