class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] validPronunciations = {"aya", "ye", "woo", "ma"};
        String[] invalidPronunciations = {"ayaaya", "yeye", "woowoo", "mama"};

        for (String word : babbling) {
            boolean hasInvalid = false;
            for (String invalid : invalidPronunciations) {
                if (word.contains(invalid)) {
                    hasInvalid = true;
                    break;
                }
            }
            if (hasInvalid) continue;

            for (String valid : validPronunciations) {
                word = word.replace(valid, " ");
            }

            if (word.replace(" ", "").isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}