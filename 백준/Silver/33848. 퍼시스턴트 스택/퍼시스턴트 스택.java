import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = 0;
        Stack<Integer> original = new Stack<>();
        Stack<int[]> history = new Stack<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            switch (x) {
                case 1:
                    int y = Integer.parseInt(st.nextToken());
                    original.push(y);
                    idx++;
                    history.push(new int[]{1, y});
                    break;
                case 2:
                    history.push(new int[]{2, original.peek()});
                    original.pop();
                    break;
                case 3:
                    int z = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < z; j++){
                        int[] curr = history.pop();
                        if (curr[0] == 1){
                            original.pop();
                        } else if (curr[0] == 2){
                            original.push(curr[1]);
                        }
                    }
                    break;
                case 4:
                    sb.append(original.size()).append("\n");
                    break;
                case 5:
                    if (original.empty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(original.peek()).append("\n");
                    }
            }
        }

        System.out.println(sb);
    }
}