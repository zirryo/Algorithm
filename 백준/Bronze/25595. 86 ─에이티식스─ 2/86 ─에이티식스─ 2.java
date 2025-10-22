import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;


        int sinA = 0;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    sinA = ((i + j)) % 2;
                }
            }
        }

        boolean flag = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    int region = (i + j) % 2;

                    if (region == sinA) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag) {
            System.out.println("Lena");
        } else {
            System.out.println("Kiriya");
        }
    }
}