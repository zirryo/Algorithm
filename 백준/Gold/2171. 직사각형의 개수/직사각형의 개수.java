import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] combined = new long[N];
        long offset = 1000000000L;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()) + offset;
            long y = Long.parseLong(st.nextToken()) + offset;
            combined[i] = (x << 32) | y;
        }
        
        Arrays.sort(combined);

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long p1 = combined[i];
                long p2 = combined[j];

                long x1 = p1 >> 32;
                long y1 = p1 & 0xFFFFFFFFL;
                long x2 = p2 >> 32;
                long y2 = p2 & 0xFFFFFFFFL;
                
                if (x1 != x2 && y1 != y2) {
                    // 찾고자 하는 나머지 두 점 생성
                    long p3 = (x1 << 32) | y2;
                    long p4 = (x2 << 32) | y1;
                    
                    if (Arrays.binarySearch(combined, p3) >= 0 &&
                            Arrays.binarySearch(combined, p4) >= 0) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count / 2);
    }
}