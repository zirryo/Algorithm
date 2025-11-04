import java.io.*;
import java.util.*;

public class Main {
    static class Box {
        int p, w;
        Box(int p, int w) { this.p = p; this.w = w; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] priorityCount = new int[N + 1];

        Deque<Box> rail = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            rail.addLast(new Box(p, w));
            priorityCount[p]++;
        }

        Stack<Box> load = new Stack<>();
        Stack<Box> temp = new Stack<>();
        long cost = 0;
        int curPriority = M;

        while (!rail.isEmpty()) {
            Box curBox = rail.pollFirst();

            if (curBox.p != curPriority) {
                cost += curBox.w;
                rail.addLast(curBox);
            } else {
                while (!load.isEmpty() && load.peek().w < curBox.w && load.peek().p == curBox.p) {
                    cost += load.peek().w;
                    temp.push(load.pop());
                }

                load.push(curBox);
                cost += curBox.w;
                while (!temp.isEmpty()) {
                    cost += temp.peek().w;
                    load.push(temp.pop());
                }

                priorityCount[curPriority]--;
                if (priorityCount[curPriority] == 0) {
                    curPriority--;
                }
            }
        }

        System.out.println(cost);
    }
}
