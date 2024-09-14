import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> universeMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] planets = new int[M];
            for (int j = 0; j < M; j++) {
                planets[j] = Integer.parseInt(st.nextToken());
            }
            
            String rankString = Arrays.toString(compressCoordinates(planets));
            universeMap.put(rankString, universeMap.getOrDefault(rankString, 0) + 1);
        }

        int sameUniverseCount = 0;
        for (int count : universeMap.values()) {
            if (count > 1) {
                sameUniverseCount += count * (count - 1) / 2; 
            }
        }
        
        System.out.println(sameUniverseCount);
    }
    
    private static int[] compressCoordinates(int[] planets) {
        int M = planets.length;
        int[] sortedPlanets = planets.clone();
        Arrays.sort(sortedPlanets);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        
        for (int value : sortedPlanets) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }
        
        int[] rankArray = new int[M];
        for (int i = 0; i < M; i++) {
            rankArray[i] = rankMap.get(planets[i]);
        }

        return rankArray;
    }
}
