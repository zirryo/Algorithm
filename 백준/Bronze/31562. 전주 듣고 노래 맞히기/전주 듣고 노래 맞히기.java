import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, List<String>> nameNotes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String title = st.nextToken();
            String note = st.nextToken() + " " + st.nextToken() + " " + st.nextToken();
            if (!nameNotes.containsKey(note)) {
                nameNotes.put(note, new ArrayList<>(List.of(title)));
            } else {
                nameNotes.get(note).add(title);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (nameNotes.containsKey(question)) {
                List<String> titles = nameNotes.get(question);

                if (titles.size() > 1) {
                    sb.append("?\n");
                } else {
                    sb.append(titles.get(0)).append("\n");
                }
            } else {
                sb.append("!\n");
            }
        }

        System.out.println(sb);
    }


}