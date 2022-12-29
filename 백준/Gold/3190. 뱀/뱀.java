import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 시계방향(D)
    static LinkedList<int[]> snake;
    static HashMap<Integer, Character> turn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        snake = new LinkedList<>();
        turn = new HashMap<>();
        map[0][0] = 2;
        snake.add(new int[]{0, 0});

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1; // 사과
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn.put(x, c);
        }

        int nowDir = 0;
        int sec = 0;
        int[] head = {0, 0};

        while(true) {
            sec++;
            head[0] += dir[nowDir][0];
            head[1] += dir[nowDir][1];

            if(inRange(head[0], head[1])) {
                if(map[head[0]][head[1]] == 2) { // 뱀이 차지하고 있는 경우
                    break;
                }
                else if (map[head[0]][head[1]] < 2) { // 이동 가능한 경우
                    if(map[head[0]][head[1]] == 0) { // 사과가 없다면 꼬리 제거
                        int[] last = snake.removeFirst();
                        map[last[0]][last[1]] = 0;
                    }

                    map[head[0]][head[1]] = 2;
                    snake.add(new int[]{head[0], head[1]});
                }
            } else break; // 벽에 부딪히는 경우

            if(turn.containsKey(sec)) {
                if(turn.get(sec) == 'D') {
                    nowDir = (nowDir + 1) % 4;
                } else {
                    nowDir = (nowDir + 3) % 4;
                }
            }
        }
        System.out.println(sec);

    }
    
    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

}