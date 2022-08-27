import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cross = 1; // 대각선에 포함되는 수의 개수
        int prevSum = 0; // 이전 대각선에 포함되는 수의 누적합

        while(true) {
            if (x <= cross + prevSum) {

                if (cross % 2 == 1) { // 대각선에 포함되는 수가 홀수일 경우, 우상향
                    System.out.println((cross + 1 - x + prevSum) + "/" + (x - prevSum));
                    break;
                } else { // 짝수일 경우, 좌하향
                    System.out.println((x - prevSum) + "/" + (cross + 1 - x + prevSum));
                    break;
                }

            } else {
                prevSum += cross;
                cross++;
            }
        }

    }
}