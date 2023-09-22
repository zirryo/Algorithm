import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, size;
    static char[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] ob = new int[3];
    static ArrayList<Node> list = new ArrayList<>();
    static List<Node> teacher = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') {
                    list.add(new Node(i, j));
                }
                else if (map[i][j] == 'T') {
                    teacher.add(new Node(i, j));
                }
            }
        }
        size = list.size();
        selectPosition(0, 0);
        System.out.println("NO");
    }
    private static void selectPosition(int depth, int idx) {
        if (depth == 3) {
            boolean result = installObstacle();

            if (result) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = idx; i < size; i++) {
            ob[depth] = i;
            selectPosition(depth + 1, idx + 1);
        }
    }
    private static boolean installObstacle() {
        boolean flag = true;
        char[][] copy = new char[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, N);
        }
        for (int x : ob) {
            Node y = list.get(x);
            copy[y.r][y.c] = 'O';
        }
        for (Node t : teacher) {
            for (int i = 0; i < 4; i++) {
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];

                while (!(nr < 0 || nc < 0 || nr >= N || nc >= N)) {
                    if (copy[nr][nc] == 'O') {
                        break;
                    } else if (copy[nr][nc] == 'S') {
                        flag = false;
                        break;
                    } else {
                        nr += dr[i];
                        nc += dc[i];
                    }
                }
            }
        }

        return flag;
    }
}
class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}