import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int P, Q;
    static long N;
    static HashMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        System.out.println(solve(N));

    }
    static long solve(long x) {
        map.put(0L, 1L); // A0 = 1

        if(!map.containsKey(x)) { // 값을 모르는 경우 -> 계산하여 map 에 추가
            map.put(x, solve(x/P) + solve(x/Q));
        }

        return map.get(x); // 값을 아는 경우 -> 바로 리턴
    }

}