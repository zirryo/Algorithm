import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // (1 ≤ N ≤ 1,000,000)
    static Vector[] arr;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new Vector[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Vector(s, e);
        }
    }
    private static int solve() {
        Arrays.sort(arr);
        int result = 0;
        int l = arr[0].s;
        int r = arr[0].e;

        for(int i=1; i<N; i++) {
            if(r < arr[i].s) { // 새로운 선분이 시작되는 경우
                result += r-l;
                l = arr[i].s;
                r = arr[i].e;
            } else if (r >= arr[i].s) { // 기존 선분을 연장하는 경우
                r = Math.max(r, arr[i].e); // 기존 선분에 포함되는 경우도 있으므로 기존 끝과 새로운 선분의 끝을 비교
            }
        }

        return result + r - l; // 최종 길이 리턴
    }
    private static class Vector implements Comparable<Vector> {
        int s;
        int e;

        public Vector(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Vector v) {
            if(this.s == v.s) return this.e - v.e;
            return this.s - v.s;
        }
    }
}

/* 스윕 라인 알고리즘(Sweep line algorithm)
- 정렬된 순서대로 처리되는 이벤트의 집합으로 문제를 모델링하는 알고리즘
- 한쪽 방향에서 시작해서 다른 방향으로 차근차근 해결해 나가는 기법
 */