import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String id;
        long mid;
        long total;
        boolean isCandidate;

        Student(String id, long mid, long X, long Y) {
            this.id = id;
            this.mid = mid;
            this.isCandidate = id.startsWith("2024");
            long finalScore = Y - (X - mid);
            if (finalScore < 0) finalScore = 0;
            this.total = mid + finalScore;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String myId = st.nextToken();
        long myMid = Long.parseLong(st.nextToken());

        List<Student> candidates = new ArrayList<>();
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            long mid = Long.parseLong(st.nextToken());
            Student s = new Student(id, mid, X, Y);
            if (s.isCandidate) candidates.add(s);
        }
        
        int candidateCount = candidates.size() + 1;
        
        if (candidateCount <= M) {
            System.out.println("YES");
            System.out.println(0);
            return;
        }
        
        candidates.sort((a, b) -> Long.compare(b.total, a.total));

        long cutoff = candidates.get(M - 1).total;

        long needTotal = cutoff;
        long myMaxTotal = myMid + Y;

        if (myMaxTotal < needTotal) {
            System.out.println("NO");
            return;
        }

        long needK = needTotal - myMid;
        if (needK < 0) needK = 0; 
        System.out.println("YES");
        System.out.println(needK);
    }
}
