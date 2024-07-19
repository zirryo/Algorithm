import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] burger = new int[b];
        int[] side = new int[c];
        int[] drink = new int[d];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            side[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(burger);
        Arrays.sort(side);
        Arrays.sort(drink);
        int total = Arrays.stream(burger).sum() + Arrays.stream(side).sum() + Arrays.stream(drink).sum();
        int minCnt = Math.min(b, Math.min(c, d));
        int setPrice = arrSum(burger, minCnt) + arrSum(side, minCnt) + arrSum(drink, minCnt);

        System.out.println(total);
        System.out.println(total - (int) (setPrice * 0.1));
    }

    private static int arrSum(int[] arr, int cnt) {
        int sum = 0;
        for (int i = arr.length-1; i >= arr.length-cnt; i--) {
            sum += arr[i];
        }
        return sum;
    }

}