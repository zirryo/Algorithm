import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findSecondBig(0, 0, N));
    }
    private static int findSecondBig(int r, int c, int size) {
        if (size == 2) {
            int[] temp = new int[4];
            int idx = 0;
            for (int i = r; i < r+2; i++) {
                for (int j = c; j < c+2; j++) {
                    temp[idx++] = arr[i][j];
                }
            }
            Arrays.sort(temp);
            return temp[2]; // 두번째로 큰 수 리턴
        } else {
            int[] temp = new int[4];
            size /= 2;
            temp[0] = findSecondBig(r, c, size);
            temp[1] = findSecondBig(r, c+size, size);
            temp[2] = findSecondBig(r+size, c, size);
            temp[3] = findSecondBig(r+size, c+size, size);
            Arrays.sort(temp);
            return temp[2];
        }
    }
}