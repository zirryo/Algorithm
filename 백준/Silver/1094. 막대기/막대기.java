import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = Integer.bitCount(N);

        System.out.println(result);

    }
    /* 비트마스크
    - 비트 연산에 사용되는 데이터
    - 다중 비트들은 싱글비트 연산 작업에서 켜고 끄거나 상호반전 시킬 수 있음
    - 집합의 배열을 인덱스로 표현하여 적은 메모리와 빠른 시간으로 문제 해결 가능
     */
}