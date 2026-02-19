import java.io.*;
import java.util.*;

public class Main {
    static class Restriction implements Comparable<Restriction> {
        int start, end;
        Restriction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Restriction o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M == 0) {
            System.out.println(N + 1);
            return;
        }

        List<Restriction> restrictions = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            restrictions.add(new Restriction(c, d));
        }

        Collections.sort(restrictions);

        List<Restriction> merged = new ArrayList<>();
        int curS = restrictions.get(0).start;
        int curE = restrictions.get(0).end;

        for (int i = 1; i < M; i++) {
            Restriction next = restrictions.get(i);
            if (next.start < curE) {
                curE = Math.max(curE, next.end);
            } else {
                merged.add(new Restriction(curS, curE));
                curS = next.start;
                curE = next.end;
            }
        }
        merged.add(new Restriction(curS, curE));

        long totalWalk = N + 1;
        for (Restriction restriction : merged) {
            totalWalk += 2L * (restriction.end - restriction.start);
        }

        System.out.println(totalWalk);
    }
}