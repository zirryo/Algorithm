import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> menLikeTall = new ArrayList<>();
        List<Integer> menLikeShort = new ArrayList<>();
        List<Integer> womenLikeTall = new ArrayList<>();
        List<Integer> womenLikeShort = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (h > 0) menLikeTall.add(h);
            else menLikeShort.add(-h);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (h > 0) womenLikeTall.add(h);
            else womenLikeShort.add(-h);
        }

        Collections.sort(menLikeTall);
        Collections.sort(menLikeShort);
        Collections.sort(womenLikeTall);
        Collections.sort(womenLikeShort);

        int pairs = 0;
        pairs += matchPairs(menLikeTall, womenLikeShort);
        pairs += matchPairs(womenLikeTall, menLikeShort);

        System.out.println(pairs);
    }

    private static int matchPairs(List<Integer> likeTall, List<Integer> likeShort) {
        int count = 0;
        int i = 0, j = 0;
        while (i < likeTall.size() && j < likeShort.size()) {
            if (likeTall.get(i) < likeShort.get(j)) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
