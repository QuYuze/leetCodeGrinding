package Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplySubstitutions {

    public static class Solution1{

        HashMap<String, String> map;
        public String apply(List<String[]> replacements,String text){
            map = new HashMap<>();
            String result = "";

            for(String[] entry: replacements){
                map.put(entry[0], entry[1]);
            }

            result = dfs(text);

            return  result;
        }

        private String dfs(String text){
            int i = text.indexOf("%");
            if(i == -1){
                return  text;
            }
            int j = text.indexOf("%", i+1);
            if (j== -1){
                return text;
            }
            String key = text.substring(i+1, j);
            String replace = dfs(map.getOrDefault(key, ""));
            return  text.substring(0, i) + replace + dfs(text.substring(j+1));
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<String[]> replacements = new ArrayList<>();
        replacements.add(new String[]{"A","bce"});
        replacements.add(new String[]{"B","ace"});
        replacements.add(new String[]{"C","abc%B%"});
        String text = "%A%_%B%_%C%";

        String result = solution1.apply(replacements, text);
        System.out.println(result);
    }
}




