import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int j=0; j<M; j++) {
            if(binarySearch(Integer.parseInt(st.nextToken()))) result.append("1").append(" ");
            else result.append("0").append(" ");
        }
        System.out.println(result.deleteCharAt(result.length()-1));

    }
    static boolean binarySearch(int num) {
        int lIdx = 0;
        int rIdx = N -1;
        while (lIdx<=rIdx) {
            int mIdx = (lIdx + rIdx) / 2;
            int mid = arr[mIdx];
            if(num<mid) rIdx = mIdx -1;
            else if(num>mid) lIdx = mIdx + 1;
            else return true;
        }
        return false;
    }


}