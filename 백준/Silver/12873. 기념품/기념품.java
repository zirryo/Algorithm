import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            list.add(i);
        }

        int level = 1;
        int boj = 0;

        while (level < N) {
            int targetIdx = (--boj + getPow3(level, list.size())) % list.size();
            // 시작위치부터 1회이동 카운트
            if (targetIdx < 0) targetIdx += list.size();
            list.remove(targetIdx);
            boj = targetIdx;
            level++;
        }

        System.out.println(list.get(0));
    }
    private static int getPow3(int x, int mod) {
        int temp = x * x;
        temp %= mod;
        temp *= x;
        return temp % mod;
    }
}