import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int result = numbers[(N - 1) / 2];
        System.out.println(result);
    }
}

/*
오름차순 정렬된 수열 A(x) = {b1, b2, b3, ...bn}
S(x) = |b1-x| + |b2-x| + |b3-x| + ... + |bn-x|
이때, S(x) 의 값이 최소가 되는 x 는 정렬된 수열의 중앙값.
 */

