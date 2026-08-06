class Solution {
    public String solution(String new_id) {
        String s = new_id.toLowerCase();

        s = s.replaceAll("[^a-z0-9-_.]", "");

        s = s.replaceAll("[.]{2,}", ".");

        s = s.replaceAll("^[.]|[.]$", "");

        if (s.isEmpty()) {
            s = "a";
        }

        if (s.length() >= 16) {
            s = s.substring(0, 15).replaceAll("[.]$", "");
        }

        if (s.length() <= 2) {
            char lastChar = s.charAt(s.length() - 1);
            while (s.length() < 3) {
                s += lastChar;
            }
        }

        return s;
    }
}