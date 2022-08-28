import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0,0);
        System.out.println(min);
    }
    static void makeTeam(int idx, int cnt) {
        // idx 현재 위치, cnt 재귀의 깊이(팀원수)
        if(cnt == N/2) {
            // 절반만 방문하여, 방문(start)/비방문(link)으로 팀 구분
            scoreDiff();
            return;
        }
        for(int i=idx; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true; // 방문이력 없을 경우 방문하여, 방문으로 표시
                makeTeam(i+1, cnt+1);
                visited[i] = false; // 재귀 끝난 후, 다시 방문하지 않음으로 표시
            }
        }

    }

    static void scoreDiff() {
        int start = 0;
        int link = 0;

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i]==true && visited[j]==true) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(visited[i]==false && visited[j]==false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int result = Math.abs(start-link);

        if(result==0) {
            // result 가 0인 경우 더 이상 값을 구할 필요없으므로 실행 종료
            System.out.println(result);
            System.exit(0);
        }
        min = Math.min(result, min);
    }
}