import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] dpMin;
    static int[][] dpMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[3];
        dpMax = new int[2][3];
        dpMin = new int[2][3];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        dpMin[0][0] = arr[0];
        dpMin[0][1] = arr[1];
        dpMin[0][2] = arr[2];
        dpMax[0][0] = arr[0];
        dpMax[0][1] = arr[1];
        dpMax[0][2] = arr[2];

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            dpMax[1][0] = arr[0] + Math.max(dpMax[0][0], dpMax[0][1]);
            dpMax[1][1] = arr[1] + Math.max(Math.max(dpMax[0][0], dpMax[0][1]), dpMax[0][2]);
            dpMax[1][2] = arr[2] + Math.max(dpMax[0][1], dpMax[0][2]);

            dpMax[0][0] = dpMax[1][0];
            dpMax[0][1] = dpMax[1][1];
            dpMax[0][2] = dpMax[1][2];

            dpMin[1][0] = arr[0] + Math.min(dpMin[0][0], dpMin[0][1]);
            dpMin[1][1] = arr[1] + Math.min(Math.min(dpMin[0][0], dpMin[0][1]), dpMin[0][2]);
            dpMin[1][2] = arr[2] + Math.min(dpMin[0][1], dpMin[0][2]);

            dpMin[0][0] = dpMin[1][0];
            dpMin[0][1] = dpMin[1][1];
            dpMin[0][2] = dpMin[1][2];
        }

        int max = Math.max(Math.max(dpMax[0][0], dpMax[0][1]), dpMax[0][2]);
        int min = Math.min(Math.min(dpMin[0][0], dpMin[0][1]), dpMin[0][2]);

        System.out.println(max + " " + min);

    }

}