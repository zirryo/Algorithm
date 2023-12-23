import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[] mooArr = {' ', 'm', 'o', 'o'};
    static char result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mooGame(N, 0, 3);
        System.out.println(result);
    }
    private static void mooGame(int m, int depth, int len) {
        if (m <= 3) { // 최소단위로 분할된 경우
            result = mooArr[m];
            return;
        }
        int nextLen = len * 2 + depth + 4;

        if (nextLen < m) { // 차수를 늘려야 하는 경우
            mooGame(m, depth+1, nextLen);
        } else {
            if (m > len + depth + 4) { // 뒤쪽 - S(depth-1) 에 속하는 경우
                mooGame(m - len - depth - 4, 0, 3);
            } else { // 가운데에 속하는 경우 ( 첫글자 m, 나머지는 모두 o)
                if (m == len + 1) result = 'm';
                else result = 'o';
            }
        }
    }
}