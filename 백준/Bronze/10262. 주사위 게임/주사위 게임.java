import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a3 = Integer.parseInt(st.nextToken());
        int b3 = Integer.parseInt(st.nextToken());
        int a4 = Integer.parseInt(st.nextToken());
        int b4 = Integer.parseInt(st.nextToken());

        int midVal1 = (b1 + a1) + (b2 + a2);
        int midVal2 = (b3 + a3) + (b4 + a4);


        if (midVal1 > midVal2) System.out.println("Gunnar");
        else if (midVal1 < midVal2) System.out.println("Emma");
        else System.out.println("Tie");
    }

}