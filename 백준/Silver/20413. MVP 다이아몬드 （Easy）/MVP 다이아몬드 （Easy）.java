import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] expLimits = new int[4];
        for (int i = 0; i < 4; i++) {
            expLimits[i] = Integer.parseInt(st.nextToken());
        }

        char[] input = br.readLine().toCharArray();
        int[] grade = new int[input.length];
        for (int i = 0; i < grade.length; i++) {
            switch (input[i]) {
                case 'B' : {
                    grade[i] = 0;
                    break;
                }
                case 'S' : {
                    grade[i] = 1;
                    break;
                }
                case 'G' : {
                    grade[i] = 2;
                    break;
                }
                case 'P' : {
                    grade[i] = 3;
                    break;
                }
                case 'D' : {
                    grade[i] = 4;
                    break;
                }
            }
        }
        int result = 0;
        int pre = 0;
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                if (input[i] == 'D') {
                    result += expLimits[3];
                } else {
                    result += expLimits[grade[i]] - 1;
                    pre = expLimits[grade[i]] - 1;
                }
            } else {
                if (input[i] == 'D') {
                    result += expLimits[3];
                } else {
                    result += expLimits[grade[i]] - 1 - pre;
                    pre = expLimits[grade[i]] - 1 - pre;
                }
            }
        }

        System.out.println(result);
    }
}