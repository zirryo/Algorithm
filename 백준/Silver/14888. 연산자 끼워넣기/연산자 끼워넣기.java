import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        insertOperator(numbers[0],1 );
        System.out.println(max);
        System.out.println(min);
    }
    public static void insertOperator(int num, int idx) {
        if(idx == N) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0: insertOperator(num + numbers[idx], idx+1); break;
                    case 1: insertOperator(num - numbers[idx], idx+1); break;
                    case 2: insertOperator(num * numbers[idx], idx+1); break;
                    case 3: insertOperator(num / numbers[idx], idx+1); break;
                }
                operator[i]++;
            }
        }
    }
}