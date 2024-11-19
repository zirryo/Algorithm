import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        String[] numToWord = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

        List<Pair> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            String word = toEnglish(i, numToWord);
            list.add(new Pair(i, word));
        }

        list.sort(Comparator.comparing(pair -> pair.word));

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).number).append(" ");
            if ((i + 1) % 10 == 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    public static String toEnglish(int num, String[] numToWord) {
        if (num < 10) {
            return numToWord[num];
        } else {
            return numToWord[num / 10] + " " + numToWord[num % 10];
        }
    }

    static class Pair {
        int number;
        String word;

        Pair(int number, String word) {
            this.number = number;
            this.word = word;
        }
    }
}
