import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            if(num1==0) break;
            int num2 = Integer.parseInt(st.nextToken());
            findRelation(num1, num2);
        }
        System.out.println(sb);

    }

    static void findRelation(int num1, int num2) {
        if(num2%num1 == 0 ) sb.append("factor" + "\n");
        else if (num1%num2 == 0) sb.append("multiple" + "\n");
        else sb.append("neither" + "\n");
    }
}
