import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> students = new ArrayList<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            students.add(name);
            indexMap.put(name, i);
        }

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String liked = st.nextToken();
                int idx = indexMap.get(liked);
                inDegree[idx]++;
            }
        }

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Student(students.get(i), inDegree[i]));
        }

        list.sort((s1, s2) -> {
            if (s2.popularity != s1.popularity)
                return s2.popularity - s1.popularity; 
            return s1.name.compareTo(s2.name); 
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.name).append(" ").append(s.popularity).append("\n");
        }

        System.out.print(sb.toString());
    }

    static class Student {
        String name;
        int popularity;

        Student(String name, int popularity) {
            this.name = name;
            this.popularity = popularity;
        }
    }
}
