class Solution {
    public String solution(String[] survey, int[] choices) {
        int RT = 0;
        int CF = 0;
        int JM = 0;
        int AN = 0;
        for(int i=0; i<survey.length; i++) {
            int val = choices[i];
            switch (survey[i]) {
                case "RT" : {
                    if(choices[i] < 4) RT += (4-val);
                    else if(choices[i] > 4) RT -= (val-4);
                    break;
                }
                case "TR" : {
                    if(choices[i] < 4) RT -= (4-val);
                    else if(choices[i] > 4) RT += (val-4);
                    break;
                }
                case "CF" : {
                    if(choices[i] < 4) CF += (4-val);
                    else if(choices[i] > 4) CF -= (val-4);
                    break;
                }
                case "FC" : {
                    if(choices[i] < 4) CF -= (4-val);
                    else if(choices[i] > 4) CF += (val-4);
                    break;
                }
                case "JM" : {
                    if(choices[i] < 4) JM += (4-val);
                    else if(choices[i] > 4) JM -= (val-4);
                    break;
                }
                case "MJ" : {
                    if(choices[i] < 4) JM -= (4-val);
                    else if(choices[i] > 4) JM += (val-4);
                    break;
                }
                case "AN" : {
                    if(choices[i] < 4) AN += (4-val);
                    else if(choices[i] > 4) AN -= (val-4);
                    break;
                }
                case "NA" : {
                    if(choices[i] < 4) AN -= (4-val);
                    else if(choices[i] > 4) AN += (val-4);
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        return result.append(RT >= 0 ? "R" : "T").append(CF >= 0 ? "C" : "F")
                .append(JM >= 0 ? "J" : "M").append(AN >= 0 ? "A" : "N").toString();
    }
}