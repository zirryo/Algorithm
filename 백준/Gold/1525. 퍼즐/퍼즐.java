import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String puzzle = "123456780";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String original = "";

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                String s = st.nextToken();
                original += s;
            }
        }

        // BFS 완전탐색 + 해시맵
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        q.add(original);
        map.put(original, 0);

        while(!q.isEmpty()) {
            String cur = q.poll();

            if(cur.equals(puzzle)) {
                System.out.println(map.get(puzzle));
                return;
            }

            int blank = cur.indexOf("0");
            int r = blank / 3; // 3*3 배열에서의 행
            int c = blank % 3; // 3*3 배열에서의 열

            for(int i=0; i<4; i++) {
                int r0 = r + dr[i];
                int c0 = c + dc[i];

                if(inRange(r0, c0)) {
                    int blank0 = r0*3 + c0; // 이동 후 빈칸의 위치
                    char temp = cur.charAt(blank0);

                    String next = cur.replace(temp, 'x').replace('0', temp).replace('x', '0');

                    if(!map.containsKey(next)) {
                        q.add(next);
                        map.put(next, map.get(cur) + 1);
                    }
                }
            }
        }
        System.out.println("-1");
    }
    
    private static boolean inRange(int r, int c) {
        return r<3 && r>=0 && c<3 && c>=0;
    }
}