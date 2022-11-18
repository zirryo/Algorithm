import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long area = 0;
    static Pos[] positions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 점의 수
        positions = new Pos[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            positions[i] = new Pos(x, y);
        }

        for(int i=1; i<N-1; i++) {
            area += ccw(positions[0], positions[i], positions[i+1]);
        }

        area = Math.abs(area); // area 면적이므로 절댓값을 취함

        if(area % 2 == 0) System.out.println(area/2 + ".0");
        else System.out.println(area/2 + ".5"); // 정수를 2로 나누는 경우이므로 소숫점 이하는 항상 0 아니면 5

    }
    // CCW 알고리즘 활용 
    private static long ccw(Pos p1, Pos p2, Pos p3) {
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x*p1.y) - (p1.y*p2.x) - (p2.y*p3.x) - (p3.y*p1.x));
    }
    
    public static class Pos {
        long x;
        long y;

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

}