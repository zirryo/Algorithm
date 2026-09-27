import java.util.*;

class Solution {

    static class Task {
        String name;
        int start;
        int playtime;

        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int start = parseTime(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, playtime));
        }

        tasks.sort((a, b) -> Integer.compare(a.start, b.start));

        List<String> result = new ArrayList<>();
        Deque<Task> stopStack = new ArrayDeque<>(); 

        for (int i = 0; i < tasks.size() - 1; i++) {
            Task current = tasks.get(i);
            Task next = tasks.get(i + 1);

            int availableTime = next.start - current.start;

            if (current.playtime <= availableTime) {
                result.add(current.name);
                int remTime = availableTime - current.playtime;

                while (!stopStack.isEmpty() && remTime > 0) {
                    Task stopped = stopStack.peek();

                    if (stopped.playtime <= remTime) {
                        remTime -= stopped.playtime;
                        result.add(stopStack.pop().name);
                    } else {
                        stopped.playtime -= remTime;
                        remTime = 0;
                    }
                }
            } else {
                current.playtime -= availableTime;
                stopStack.push(current);
            }
        }

        result.add(tasks.get(tasks.size() - 1).name);

        while (!stopStack.isEmpty()) {
            result.add(stopStack.pop().name);
        }

        return result.toArray(new String[0]);
    }

    private int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}