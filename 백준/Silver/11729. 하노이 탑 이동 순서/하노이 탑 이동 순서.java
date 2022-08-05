import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, k)-1);
        sb.append("\n");
        hanoi(k,1,2,3);
        System.out.println(sb);

    }
    // k : 원판 개수, from : 현재 원판의 위치, visit : 중간에 방문하는 위치, to : 원판의 목적
    static void hanoi (int k, int from, int visit, int to){
        if(k==1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(k-1,from,to,visit);
        sb.append(from + " " + to + "\n");
        hanoi(k-1,visit,from,to);
    }
}
