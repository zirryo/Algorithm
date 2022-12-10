import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if(N<=K) {
            System.out.println(0);
            System.exit(0);
        }

        int result = 0;

        int[] position = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) position[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(position);

        List<Integer> distance = new ArrayList<>();

        for(int i=0; i<N-1; i++) distance.add(position[i+1] - position[i]);
        Collections.sort(distance);
        // 간격이 큰 K개의 위치에 기지국 설치
        for(int i=0; i<N-K; i++) result += distance.get(i);

        System.out.println(result);
    }

}