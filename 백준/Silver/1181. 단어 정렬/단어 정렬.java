// 1181 단어정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] wordArr = new String[N];
        for(int i=0; i<N; i++) {
            wordArr[i] = br.readLine();
        }

        Arrays.sort(wordArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()) {
                    return o1.compareTo(o2);
                } // 두 문자열의 길이가 같을 경우 사전 순 정렬
                else return o1.length() - o2.length();
                // 두 문자열의 길이가 다를 경우 길이 오름차순 정렬
            }
        });
        StringBuilder result = new StringBuilder();
        result.append(wordArr[0]);
        for(int i=1; i< wordArr.length; i++) {
            if(!wordArr[i].equals(wordArr[i-1])) {
                result.append("\n").append(wordArr[i]);
            }

        }
        System.out.println(result);

    }
}