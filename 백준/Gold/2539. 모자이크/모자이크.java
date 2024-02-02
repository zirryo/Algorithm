import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int R, C, papers;
    static ArrayList<Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        papers = Integer.parseInt(br.readLine());

        int lo = 0, hi = Math.min(R, C);

        int x = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        for (int i=0; i<x; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(r, c));
            lo = Math.max(r, lo);
        }

        Collections.sort(nodes);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mosaic(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
    private static boolean mosaic(int mid) {
        int cnt = 0;
        int pre = 0;

        for (Node n : nodes) {
            if (pre < n.c) {
                cnt++;
                pre = n.c - 1 + mid;
            }

            if (cnt > papers) return false;
        }
        return true;
    }
    private static class Node implements Comparable<Node> {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Node node) {
            return this.c - node.c;
        }
    }
}