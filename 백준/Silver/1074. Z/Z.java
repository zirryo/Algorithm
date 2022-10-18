import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long cnt = 0;
    static int N, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N);
        getCount(0, 0, size);
    }
    // 4분할 재귀
    static void getCount(int row, int col, int size) {
        if(size==1) {
            System.out.println(cnt);
            return;
        }
        int tempSize = size / 2;

        if(R < row+tempSize && C < col+tempSize) {
            getCount(row, col, tempSize);
        }
        else if(R < row+tempSize && C >= col+tempSize) {
            cnt += (size*size / 4);
            getCount(row, col+tempSize, tempSize);
        }
        else if(R >= row+tempSize && C < col+tempSize) {
            cnt += ((size*size) / 4) * 2;
            getCount(row+tempSize, col, tempSize);
        }
        else if(R >= row+tempSize && C >= col+tempSize) {
            cnt += ((size*size) / 4) * 3;
            getCount(row+tempSize, col+tempSize, tempSize);
        }
    }
}