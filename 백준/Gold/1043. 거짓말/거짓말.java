import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 파티에 참가하는 전체 인원
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        boolean[] knowTruth = new boolean[N+1];
        if(K != 0) {
            for(int i=0; i<K; i++) knowTruth[Integer.parseInt(st.nextToken())] = true; // 진실을 아는 사람 == true
        }

        HashSet<Integer>[] parties = new HashSet[M+1];
        for (int i = 1; i <= M; i++) {
            parties[i] = new HashSet<>();
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int p=1; p<=M; p++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken()); // p번째 파티의 참가 인원 수
            int temp = Integer.parseInt(st.nextToken());

            if(people<=1) {
                parties[p].add(temp); // 파티 참가자 추가
                continue;
            }

            for(int j=1; j<people; j++) { 
                int a = temp;
                int b = Integer.parseInt(st.nextToken());

                if(find(a) != find(b)) union(a, b); // 연관 관계 생성
                parties[p].add(b); // 파티 참가자 추가
            }
        }
        
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(knowTruth[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= N; j++){
                    if (find(j)==root) {
                        knowTruth[j] = true; // parent 가 같은 경우 진실을 알게됨
                        visited[j] = true; // 같은 곳을 다시 방문하지 않기 위해 토글
                    }
                }
            }
        }
 
        int result = 0;
        for (int i = 1; i <= M; i++) {
            boolean flag = false;
            for (int person : parties[i]) {
                if(knowTruth[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++; // 모든 파티 참석자가 false 면 카운트
        }

        System.out.println(result);
    }
    
    public static int find(int idx) { // parent 를 찾음
        if(parent[idx]==idx) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) { // parent 변경
        int parentB = find(b);
        parent[parentB] = a;
    }
}