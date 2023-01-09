import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Task> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int day = 0;
        int result = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            day = Math.max(day, d);
            list.add(new Task(d, w));
        }

        // 남은 일자가 가장 긴 날을 기준으로, 당일에 할 수 있는 가장 점수 높은 과제를 수행함.
        for(int i=day; i>0; i--) {
            Task temp = new Task(0, 0);
            for(Task t : list) {
                if(t.due >= i && t.score > temp.score) {
                    temp = t;
                }
            }
            result += temp.score;
            list.remove(temp);
        }

        System.out.println(result);
    }

}

class Task {

    int due;
    int score;

    public Task(int due, int score) {
        this.due = due;
        this.score = score;
    }
}