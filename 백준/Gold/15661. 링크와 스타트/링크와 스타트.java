import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int[] start;
    static int[] link;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        start = new int[N];
        link = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0,0);
        System.out.println(min);
    }
    static void makeTeam(int startMembers, int linkMembers) {

        if(startMembers>=N || linkMembers>=N) return; // 계산 X, 제외 (팀당 최소 인원 1명)
        if(startMembers + linkMembers == N) {
            scoreDiff(startMembers, linkMembers);
            return;
        }

        start[startMembers] = startMembers + linkMembers;
        makeTeam(startMembers+1, linkMembers);
        if(startMembers == 0) return;
        link[linkMembers] = startMembers + linkMembers;
        makeTeam(startMembers, linkMembers+1);
    }

    static void scoreDiff(int startMembers, int linkMembers) {
        int startScore = 0;
        int linkScore = 0;

        for(int i=0; i<startMembers; i++) {
            for(int j=0; j<startMembers; j++) {
                startScore += arr[start[i]][start[j]];
            }
        }

        for(int i=0; i<linkMembers; i++) {
            for(int j=0; j<linkMembers; j++) {
                linkScore += arr[link[i]][link[j]];
            }
        }

        int result = Math.abs(startScore-linkScore);
        min = Math.min(result, min);
    }
}