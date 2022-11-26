import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] isVisited;
    static String[] words;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[26];
        words = new String[N];

        if(K < 5) {
            System.out.println(result);
            System.exit(0);
        } else if (K >= 26) {
            System.out.println(N);
            System.exit(0);
        }

        // 다섯개의 알파벳은 반드시 알아야 함
        isVisited[0] = true; // a
        isVisited['n' - 'a'] = true;
        isVisited['t' - 'a'] = true;
        isVisited['i' - 'a'] = true;
        isVisited['c' - 'a'] = true;

        for(int i=0; i<N; i++) {
            String s = br.readLine().replaceAll("anta", "").replaceAll("tica", "");
            words[i] = s;
        }
        canLearn(0, 0);
        System.out.println(result);

    }
    static void canLearn(int a, int depth) {

        if(depth == K-5) { // 더 이상 단어를 배울 수 없음
            int cnt = 0;
            for(int i=0; i<N; i++) {
                boolean flag = true;
                for(int j=0; j<words[i].length(); j++) {
                    if(!isVisited[words[i].charAt(j) - 'a']) { // 배우지 않은 알파벳이 있을 경우 카운트에서 제외
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            result = Math.max(cnt, result);
            return;
        }

        for(int i=a; i<26; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                canLearn(i, depth+1);
                isVisited[i] = false;
            }
        }
    }
}