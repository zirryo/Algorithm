// 클래스명은 항상 Main 으로 제출
// 1620 나는야 포켓몬 마스터/집합과 맵/08.09
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> intKey = new HashMap<>();
        HashMap<String, Integer> strKey = new HashMap<>();

        for(int i=1; i<=N; i++) {
            String pokeMon = br.readLine();
            intKey.put(i, pokeMon);
            strKey.put(pokeMon,i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String question = br.readLine();
            if(isNumeric(question)) sb.append(intKey.get(Integer.parseInt(question))).append("\n");
            else sb.append(strKey.get(question)).append("\n");
        }
        System.out.println(sb);


    }
    static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}