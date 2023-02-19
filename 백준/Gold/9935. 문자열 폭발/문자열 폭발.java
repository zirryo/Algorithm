import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static final String empty = "FRULA";
    static String original, explosion;
    public static void main(String[] args) throws IOException {
        init();

        StringBuilder result = new StringBuilder();
        int exLen = explosion.length();

        for(int i = 0; i< original.length(); i++) { // 연쇄 폭발을 효과적으로 처리하는 방식
            char cur = original.charAt(i);
            result.append(cur);

            if(result.length() >= exLen) { // 문자열을 하나씩 더해서 폭발 문자열보다 길어지면
                boolean flag = true;
                for(int j=0; j<exLen; j++) {
                    char exChar = explosion.charAt(j);
                    char oriChar = result.charAt(result.length() - exLen + j);
                    if(exChar != oriChar) {
                        flag = false;
                        break;
                    }
                }
                if(flag) result.delete(result.length()-exLen, result.length()); // 문자열 폭발
            }
        }
        if(result.length() == 0) System.out.println(empty);
        else System.out.println(result);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        original = br.readLine();
        explosion = br.readLine();
    }
}