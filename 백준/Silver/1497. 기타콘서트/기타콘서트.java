import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기타
        int M = Integer.parseInt(st.nextToken()); // 곡
        long[] guitar = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String available = st.nextToken();
            long bit = 0;
            for (int j = 0; j < M; j++) {
                if (available.charAt(j) == 'Y') {
                    bit |= (1L << j);
                }
            }
            guitar[i] = bit;
        }

        int maxSong = 0;
        int minGuitar = N+1;

        for (int i = 0; i < (1 << N); i++) {
            int tempGuitar = 0;
            long tempResult = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    tempResult |= guitar[j];
                    tempGuitar++;
                }
            }

            int totalSong = Long.bitCount(tempResult);
            if (totalSong > maxSong) {
                maxSong = totalSong;
                minGuitar = tempGuitar;
            } else if (totalSong == maxSong && minGuitar > tempGuitar) {
                minGuitar = tempGuitar;
            }
        }

        if (maxSong == 0) System.out.println(-1);
        else System.out.println(minGuitar);
    }
}