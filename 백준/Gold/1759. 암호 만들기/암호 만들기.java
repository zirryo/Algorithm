import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1759 암호만들기
public class Main {
    static int L;
    static int C;
    static char[] cArr;
    static char[] candidate;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cArr = new char[L];
        candidate = new char[C];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            candidate[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(candidate);
        codeMaker(0,0);
        System.out.println(sb);
    }
    static void codeMaker(int x, int depth) {
        if(depth==L) {
            if(isValid()) sb.append(cArr).append("\n");
            return;
        }
        for(int i=x; i<C; i++) {
            cArr[depth] = candidate[i];
            codeMaker(i+1, depth+1);
        }
    }
    static boolean isValid() {
        int vowel = 0;
        int consonant = 0;

        for(char c : cArr) {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') vowel++;
            else consonant++;
        }
        if(vowel>=1 && consonant>=2) return true;
        return false;
    }
}