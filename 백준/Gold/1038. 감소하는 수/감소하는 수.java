import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1); // 감소하는 수는 최대 1022개
        else {
            for(int i=0; i<=9; i++) {
                makeDescNum(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }
    private static void makeDescNum(long num, int depth) {
        if(depth > 10) return;
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            makeDescNum(num * 10 + i, depth + 1);
        }
    }
}