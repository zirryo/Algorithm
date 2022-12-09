import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, result;
    static String[] word;
    static List<Character> characterList = new ArrayList<>();
    static int[] matchedNum; // char list 의 인덱스에 맞게 숫자 매칭
    static boolean[] isVisited = new boolean[10]; // 0~9 까지 숫자를 사용했는지 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 단어의 개수
        word = new String[N];

        for(int i=0; i<N; i++) {
            word[i] = br.readLine();
            for(int j=0; j<word[i].length(); j++) {
                if(!characterList.contains(word[i].charAt(j))) {
                    characterList.add(word[i].charAt(j)); // 모든 단어에 포함된 알파벳 리스트 취합
                }
            }
        }

        matchedNum = new int[characterList.size()];

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth) {

        if(depth == characterList.size()) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                int temp = 0;
                for(int j=0; j< word[i].length(); j++) {
                    temp *= 10;
                    temp += matchedNum[characterList.indexOf(word[i].charAt(j))];
                    // 수의 맨앞자리부터 합하고 10씩 곱하여 자릿수를 올림
                    // 0 -> 3 -> 30 -> 35 -> 350 -> 352 -> 3520 ....
                }
                sum += temp;
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<10; i++) {
            if(isVisited[i]) continue;

            isVisited[i] = true;
            matchedNum[depth] = i;
            dfs(depth+1);
            matchedNum[depth] = 0;
            isVisited[i] = false;
        }
    }
}