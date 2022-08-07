import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] memberList = new String[N][2];

        int j=0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            memberList[i][0] = st.nextToken();
            memberList[i][1] = st.nextToken();
        }

        Arrays.sort(memberList, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(memberList[i][0]).append(" ").append(memberList[i][1]).append("\n");
        }
        System.out.println(sb);
    }


}