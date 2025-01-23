import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int minDist = Integer.MAX_VALUE;

        if (K == 1) {
            for (int shelter = 0; shelter < N; shelter++) {
                int maxDist = 0;
                for (int i = 0; i < N; i++) {
                    if (shelter == i) continue;
                    int dist = Math.abs(matrix[shelter][0] - matrix[i][0])
                            + Math.abs(matrix[shelter][1] - matrix[i][1]);
                    maxDist = Math.max(maxDist, dist);
                }
                minDist = Math.min(minDist, maxDist);
            }
        }

        if (K == 2) {
            for (int shelter = 0; shelter < N; shelter++) {
                for (int shelter2 = 0; shelter2 < N; shelter2++) {
                    if (shelter == shelter2) continue;
                    int maxDist = 0;
                    for (int i = 0; i < N; i++) {
                        if (shelter == i || shelter2 == i) continue;
                        int dist = Math.abs(matrix[shelter][0] - matrix[i][0])
                                + Math.abs(matrix[shelter][1] - matrix[i][1]);
                        int dist2 = Math.abs(matrix[shelter2][0] - matrix[i][0])
                                + Math.abs(matrix[shelter2][1] - matrix[i][1]);

                        maxDist = Math.max(maxDist, Math.min(dist2, dist));
                    }
                    minDist = Math.min(minDist, maxDist);
                }

            }
        }
        
        if (K == 3) {
            for (int shelter = 0; shelter < N; shelter++) {
                for (int shelter2 = 0; shelter2 < N; shelter2++) {
                    if (shelter == shelter2) continue;
                    for (int shelter3 = 0; shelter3 < N; shelter3++) {
                        if (shelter == shelter3 || shelter2 == shelter3) continue;
                        int maxDist = 0;
                        for (int i = 0; i < N; i++) {
                            if (shelter == i || shelter2 == i || shelter3 == i) continue;
                            int dist = Math.abs(matrix[shelter][0] - matrix[i][0])
                                    + Math.abs(matrix[shelter][1] - matrix[i][1]);
                            int dist2 = Math.abs(matrix[shelter2][0] - matrix[i][0])
                                    + Math.abs(matrix[shelter2][1] - matrix[i][1]);
                            int dist3 = Math.abs(matrix[shelter3][0] - matrix[i][0])
                                    + Math.abs(matrix[shelter3][1] - matrix[i][1]);
                            
                            maxDist = Math.max(maxDist, Math.min(Math.min(dist, dist2), dist3));
                        }
                        minDist = Math.min(minDist, maxDist);
                    }
                }
            }
            
        }

        System.out.println(minDist);
    }
}