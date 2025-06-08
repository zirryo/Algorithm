import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 초기 친구 관계 수

        boolean[][] friend = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = true;
            friend[b][a] = true;
        }

        List<Integer> result = new ArrayList<>();

        while (true) {
            boolean[][] newFriend = new boolean[N + 1][N + 1];
            int count = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || friend[i][j]) continue;
                    for (int k = 1; k <= N; k++) {
                        if (friend[i][k] && friend[k][j]) {
                            newFriend[i][j] = true;
                            newFriend[j][i] = true;
                            count++;
                            break;
                        }
                    }
                }
            }

            if (count == 0) break;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (newFriend[i][j]) {
                        friend[i][j] = true;
                    }
                }
            }

            result.add(count / 2);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        for (int c : result) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);

    }
}
