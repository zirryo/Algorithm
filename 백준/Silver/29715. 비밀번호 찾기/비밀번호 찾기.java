import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, Y;
    static int[] password;
    static boolean[] used;
    static Set<Integer> candidate = new HashSet<>();
    static int tryCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 비밀번호 자릿수
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); // 비밀번호 1회 입력 소요 시간
        Y = Integer.parseInt(st.nextToken()); // 3회 실패시 대기 시간

        password = new int[N + 1]; // 1-based index
        used = new boolean[10];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a != 0) {
                password[a] = b;
                used[b] = true;
            } else {
                candidate.add(b);
            }
        }

        solve(1);

        if (tryCount == 0) {
            System.out.println(0);
        } else {
            long totalTime = (long) tryCount * X + (long) ((tryCount - 1) / 3) * Y;
            System.out.println(totalTime);
        }
    }

    static void solve(int depth) {
        if (depth == N + 1) {
            for (int num : candidate) {
                boolean found = false;
                for (int i = 1; i <= N; i++) {
                    if (password[i] == num) {
                        found = true;
                        break;
                    }
                }
                if (!found) return;
            }
            tryCount++;
            return;
        }

        if (password[depth] != 0) {
            solve(depth + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                password[depth] = i;
                solve(depth + 1);
                password[depth] = 0;
                used[i] = false;
            }
        }
    }
}