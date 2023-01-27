import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int INF = 10_000;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        K = 0;
        dist = new int[N+1][N+1];

        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                if(i != j) dist[i][j] = INF; // Floyd Warshall 배열 초기화
            }
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        // 플로이드 - 와샬 : 모든 정점간의 최단 거리를 구함
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        boolean[] isVisited = new boolean[N+1];
        ArrayList<Integer> heads = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(isVisited[i]) continue;

            ArrayList<Integer> committee = new ArrayList<>();

            // 위원회 구성
            for(int j=1; j<=N; j++) {
                if(!isVisited[j] && dist[i][j] != INF) {
                    committee.add(j);
                    isVisited[j] = true;
                }
            }

            int head = committee.get(0); // 위원회의 대표
            int headTime = INF; // 위원회 대표의 의사 전달 시간

            for(Integer com : committee) { // 특정인이 대표가 될 경우
                int time = 0;
                for(int k=1; k<=N; k++) {
                    if(dist[com][k] != INF && time < dist[com][k]) {
                        // 같은 위원회에 속한 사람 && 의사 전달 시간이 갱신되는 경우 (최댓값)
                        time = dist[com][k];
                    }
                }

                if(time < headTime) { // 더 짧은 의사 전달 시간을 가진다면 -> 대표 변경
                    head = com;
                    headTime = time;
                }
            }
            heads.add(head);
        }

        Collections.sort(heads); // 대표번호를 오름차순으로 정렬

        sb.append(heads.size()).append("\n");
        for(Integer head : heads) sb.append(head).append("\n");
        System.out.println(sb);
    }
}