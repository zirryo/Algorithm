class Solution {

    public String solution(String p) {
        return convert(p);
    }

    private String convert(String w) {
        if (w.isEmpty()) {
            return "";
        }

        int open = 0;
        int close = 0;
        int index = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                index = i + 1;
                break;
            }
        }

        String u = w.substring(0, index);
        String v = w.substring(index);

        if (isCorrect(u)) {
            return u + convert(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");          
            sb.append(convert(v));   
            sb.append(")");          

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }

            return sb.toString();
        }
    }

    private boolean isCorrect(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}