package leetcode;

import java.util.List;

public class T648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] strs = sentence.split(" ");
        
        for(String word:dict)
            for(int i = 0; i < strs.length; i++)
                if(strs[i].startsWith(word))
                    strs[i] = word;
        
        return String.join(" ", strs);
    }
}
