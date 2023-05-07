import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(arr[0][1]);
        for(int i=1; i<N; i++) {
            if(room.peek() <= arr[i][0]) {
                room.poll();
            }
            room.add(arr[i][1]);
        }
        System.out.println(room.size());
    }
}