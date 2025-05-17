import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isSG = new boolean[2 * n + 1];
        PriorityQueue<Integer> SG = new PriorityQueue<>();
        PriorityQueue<Integer> GS = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(br.readLine());
            SG.add(card);
            isSG[card] = true;
        }

        for (int i = 1; i <= 2 * n; i++) {
            if (!isSG[i]) {
                GS.add(i);
            }
        }

        boolean turn = true;
        Integer tableCard = null;

        while (!SG.isEmpty() && !GS.isEmpty()) {
            if (turn) {
                if (tableCard == null) {
                    tableCard = SG.poll();
                } else {
                    Integer next = findCard(SG, tableCard);
                    if (next != null) {
                        tableCard = next;
                    } else {
                        tableCard = null;
                    }
                }
            } else {
                if (tableCard == null) {
                    tableCard = GS.poll();
                } else {
                    Integer next = findCard(GS, tableCard);
                    if (next != null) {
                        tableCard = next;
                    } else {
                        tableCard = null;
                    }
                }
            }
            turn = !turn;
        }
        
        System.out.println(GS.size());
        System.out.println(SG.size());

    }

    static Integer findCard(PriorityQueue<Integer> pq, int value) {
        List<Integer> buffer = new ArrayList<>();
        Integer result = null;

        while (!pq.isEmpty()) {
            int card = pq.poll();
            if (card > value) {
                result = card;
                break;
            }
            buffer.add(card);
        }

        for (int c : buffer) {
            pq.add(c);
        }

        return result;
    }
}
