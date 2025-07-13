import java.util.ArrayList;
import java.util.List;

public class TextJutification {
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();

            int i =0;

            while(i < words.length){
                StringBuilder line = new StringBuilder();
                int len = 0;
                int j = i;

                while(j < words.length && len + words[j].length() + (j - i) <= maxWidth){
                    len += words[j].length();
                    j++;
                }

                int gap = j - i - 1;
                int spaces = maxWidth - len;

                if(j == words.length || gap == 0){
                    for(int k=i; k<j-1; k++){
                        line.append(words[k]);
                        line.append(" ");
                    }
                    line.append(words[j-1]);
                    while(line.length() < maxWidth){
                        line.append(" ");
                    }
                }else{
                    int spaceEach = spaces / gap;
                    int extra = spaces % gap;
                    for(int k=i; k<j-1; k++){
                        line.append(words[k]);
                        for(int l=0; l<spaceEach; l++){
                            line.append(" ");
                        }

                        if(extra > 0){
                            //System.out.println(words[k] + " " + extra);
                            line.append(" ");
                            extra--;
                        }
                        //System.out.println(extra);
                    }

                    line.append(words[j-1]);
                }

                //System.out.println(line.toString());
                result.add(line.toString());
                i = j;
            }

            return result;
        }
    }
}
