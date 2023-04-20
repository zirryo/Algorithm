import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 전체 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 종류
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[n];

        for(int i=0; i<n; i++) sushi[i] = Integer.parseInt(br.readLine());

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<k; i++) {
            q.add(sushi[i]);
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }
        for(int i=0; i<n; i++) { // i는 연속먹기 시작점
            int tmp = map.size();
            if(!map.containsKey(c)) tmp++;
            result = Math.max(result, tmp);

            if(i == n-1) break;

            int idx = i+k;
            if(idx > n-1) idx -= n;

            int key = q.poll();
            int val = map.get(key);
            if(val == 1) map.remove(key);
            else map.put(sushi[i], map.get(sushi[i])-1);
            map.put(sushi[idx], map.getOrDefault(sushi[idx], 0) + 1);
            q.add(sushi[idx]);
        }
        System.out.println(result);
    }
}