import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//12891
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] now = new int[4];
        int[] goal = new int[4];
        String s = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            now[alToNum(cur)]++;

            if (i < P - 1) continue;
            if (i >= P) {
                char pre = s.charAt(i-P);
                now[alToNum(pre)]--;
            }

            boolean make = true;
            for (int j = 0; j < 4; j++) {
                if (goal[j] > now[j]) {
                    make = false;
                    break;
                }
            }

            if (make) result++;
        }
        System.out.println(result);
    }
    private static int alToNum(char al) {
        if (al == 'A') return 0;
        else if(al == 'C') return 1;
        else if(al == 'G') return 2;
        else return 3;
    }
}