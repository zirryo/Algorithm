import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int maxLen = Math.max(a.length(), b.length());
        int[] arr1 = new int[maxLen+1];
        int[] arr2 = new int[maxLen+1];

        for(int i=a.length()-1, idx = 0; i>=0; i--, idx++) {
            arr1[idx] = a.charAt(i) - '0'; // 일의 자리 숫자부터 숫자로 변환하여 배열에 저장
        }

        for(int i=b.length()-1, idx = 0; i>=0; i--, idx++) {
            arr2[idx] = b.charAt(i) - '0'; // 일의 자리 숫자부터 숫자로 변환하여 배열에 저장
        }

        for(int i=0; i<maxLen; i++) {
            int val = arr1[i] + arr2[i];
            arr1[i] = val % 10;
            arr1[i+1] += (val / 10); // 더한 값이 10이상일 경우 올림수 발생
        }

        StringBuilder sb = new StringBuilder();
        if(arr1[maxLen] != 0) sb.append(arr1[maxLen]);
        for(int i=maxLen-1; i>=0; i--) sb.append(arr1[i]);
        System.out.println(sb);
    }
}
