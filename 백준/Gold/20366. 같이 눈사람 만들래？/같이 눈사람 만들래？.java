import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Snow> list = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                list.add(new Snow(i, j, arr[i] + arr[j]));
            }
        }

        Collections.sort(list);
        int result = 2_000_000_000;
        Snow first, second;

        for (int i = 1; i < list.size(); i++) {
            first = list.get(i);
            second = list.get(i-1);
            if (result <= Math.abs(first.sum - second.sum)) continue;
            if (first.a != second.a && first.a != second.b && first.b != second.a && first.b != second.b) {
                result = Math.abs(first.sum - second.sum);
            }
        }
        System.out.println(result);
    }
    private static class Snow implements Comparable<Snow> {
        int a;
        int b;
        int sum;

        public Snow(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }

        @Override
        public int compareTo(Snow snow) {
            return this.sum - snow.sum;
        }
    }
}
