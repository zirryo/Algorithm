import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] nutrition; // 매년 더해지는 양분 정보
    static int[][] ground; // 해당 위치의 영양 상태
    static ArrayList<Integer>[][] trees;
    static List<Tree> deadTrees;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nutrition = new int[N][N];
        ground = new int[N][N];
        trees = new ArrayList[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(ground[i], 5);
            for(int j=0; j<N; j++) {
                nutrition[i][j] = Integer.parseInt(st.nextToken());
                trees[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees[x-1][y-1].add(z);
        }

        while (K-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(totalTrees());
    }
    private static void spring() {
        deadTrees = new LinkedList<>();
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                for(int k = 0; k < trees[r][c].size(); k++) {
                    int age = trees[r][c].get(k);
                    if(ground[r][c] >= age) {
                        trees[r][c].set(k, age+1);
                        ground[r][c] -= age;
                    } else {
                        deadTrees.add(new Tree(r, c, age));
                        trees[r][c].remove(k--);
                    }
                }
            }
        }
    }
    private static void summer() {
        for(Tree t : deadTrees) {
            ground[t.r][t.c] += (t.age / 2);
        }
    }
    private static void fall() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                for(int t : trees[r][c]) {
                    if(t % 5 != 0) continue;
                    for(int k = 0; k < 8; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if(nr < 0 || nr >=N || nc < 0 || nc >= N) continue;
                        trees[nr][nc].add(0, 1);
                    }
                }
            }
        }
    }
    private static void winter() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                ground[r][c] += nutrition[r][c];
            }
        }
    }
    private static int totalTrees() {
        int answer = 0;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                answer += trees[r][c].size();
            }
        }
        return answer;
    }
    private static class Tree {
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
}