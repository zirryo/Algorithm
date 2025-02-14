import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Character> colors = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            String color = sc.next();
            int number = sc.nextInt();

            colors.add(color.charAt(0));
            numbers.add(number);
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }
        
        Collections.sort(numbers);
        
        boolean isSameColor = new HashSet<>(colors).size() == 1;
        
        boolean isConsecutive = true;
        for (int i = 1; i < 5; i++) {
            if (numbers.get(i) != numbers.get(i - 1) + 1) {
                isConsecutive = false;
                break;
            }
        }

        // 가장 큰 숫자 찾기
        int maxNumber = numbers.get(4);

        // 숫자 빈도 분석
        List<Integer> frequency = new ArrayList<>(countMap.values());
        Collections.sort(frequency, Collections.reverseOrder());

        int maxScore = 0;

        // 900점 규칙: 같은 색 && 연속적인 숫자
        if (isSameColor && isConsecutive) {
            maxScore = Math.max(maxScore, 900 + maxNumber);
        }

        // 800점 규칙: 4장이 같은 숫자
        if (frequency.contains(4)) {
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 4) {
                    maxScore = Math.max(maxScore, 800 + key);
                    break;
                }
            }
        }

        // 700점 규칙: 3장이 같은 숫자 && 2장이 같은 숫자
        if (frequency.contains(3) && frequency.contains(2)) {
            int three = 0, two = 0;
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 3) {
                    three = key;
                } else if (countMap.get(key) == 2) {
                    two = key;
                }
            }
            maxScore = Math.max(maxScore, 700 + three * 10 + two);
        }

        // 600점 규칙: 같은 색
        if (isSameColor) {
            maxScore = Math.max(maxScore, 600 + maxNumber);
        }

        // 500점 규칙: 숫자가 연속적
        if (isConsecutive) {
            maxScore = Math.max(maxScore, 500 + maxNumber);
        }

        // 400점 규칙: 3장이 같은 숫자
        if (frequency.contains(3)) {
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 3) {
                    maxScore = Math.max(maxScore, 400 + key);
                    break;
                }
            }
        }

        // 300점 규칙: 2장이 같은 숫자 & 다른 2장이 같은 숫자
        if (frequency.contains(2) && Collections.frequency(frequency, 2) == 2) {
            int highPair = 0, lowPair = 0;
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 2) {
                    if (key > highPair) {
                        lowPair = highPair;
                        highPair = key;
                    } else {
                        lowPair = key;
                    }
                }
            }
            maxScore = Math.max(maxScore, 300 + highPair * 10 + lowPair);
        }

        // 200점 규칙: 2장이 같은 숫자
        if (frequency.contains(2)) {
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 2) {
                    maxScore = Math.max(maxScore, 200 + key);
                    break;
                }
            }
        }

        // 100점 규칙: 그 외, 가장 큰 숫자
        maxScore = Math.max(maxScore, 100 + maxNumber);
        
        System.out.println(maxScore);
    }
}
