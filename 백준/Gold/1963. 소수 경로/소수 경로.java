import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static boolean[] notPrime = new boolean[10000];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        isPrime();

        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int curPwd = Integer.parseInt(st.nextToken());
            int newPwd = Integer.parseInt(st.nextToken());
            int result = primePassword(curPwd, newPwd);
            if(result == -1) sb.append("Impossible\n");
            else sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int primePassword(int curPwd, int newPwd) {
        if(notPrime[newPwd]) return -1;
        if(curPwd == newPwd) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[10000];
        isVisited[curPwd] = true;
        queue.offer(new int[]{0, curPwd});

        while(!queue.isEmpty()) {
            int[] data = queue.poll();
            int step = data[0];
            int tempPwd = data[1];

            for(int i=0; i<4; i++) {
                int[] digits = numToArr(tempPwd);

                for(int d=0; d<=9; d++) {
                    if(d != digits[i]) {
                        digits[i] = d;

                        int changedPwd = arrToNum(digits);
                        if(changedPwd == newPwd) return step + 1; // 새비밀번호와 같다면 리턴
                        if(changedPwd>1000 && !notPrime[changedPwd] && !isVisited[changedPwd]) {
                            isVisited[changedPwd] = true;
                            queue.offer(new int[]{step+1, changedPwd});
                        }
                    }
                }
            }
        }
        return -1;
    }
    private static void isPrime() {
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i=2; i<10000; i++) {
            if(notPrime[i]) continue;
            for(int j=i+i; j<10000; j += i) {
                notPrime[j] = true;
            }
        }
    }

    private static int[] numToArr(int num) {
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int arrToNum(int[] arr) {
        int LEN = arr.length;
        String[] strArr = new String[LEN];

        for(int i=0; i<LEN; i++) strArr[i] = String.valueOf(arr[i]);
        return Integer.parseInt(String.join("", strArr));
    }

}