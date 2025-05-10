import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P = new int[5];
    static ArrayList<Integer>[] levels = new ArrayList[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            levels[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken());
            levels[level].add(time);
        }

        List<Integer> selected = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Integer> list = levels[i];
            Collections.sort(list);
            for (int j = 0; j < P[i]; j++) {
                selected.add(list.get(j));
            }
        }
        int total = 0;
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < P[i]; j++) {
                sub.add(levels[i].get(j));
            }
            Collections.sort(sub); 
            for (int j = 0; j < sub.size(); j++) {
                total += sub.get(j);
                if (j > 0) {
                    total += sub.get(j) - sub.get(j - 1);
                }
            }
            if (i > 0 && P[i] > 0) {
                total += 60; 
            }
        }

        System.out.println(total);
    }
}
