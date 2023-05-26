import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sour;
    static int[] bitter;
    static int result = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        select();
        System.out.println(result);
    }
    private static void select() {
        ArrayList<Integer> list;
        for (int k = 1; k < (1 << n); k++) {
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((1 << i & k) != 0) {
                    list.add(i);
                }
            }
            cook(list);
        }
    }
    private static void cook(ArrayList<Integer> arrayList) {
        int s = 1;
        int b = 0;

        for (int idx : arrayList) {
            s *= sour[idx];
            b += bitter[idx];
        }

        int diff = Math.abs(s - b);
        result = Math.min(result, diff);
    }
}