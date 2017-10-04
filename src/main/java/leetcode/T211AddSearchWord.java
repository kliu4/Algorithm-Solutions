package leetcode;

import java.util.HashSet;
import java.util.Set;

public class T211AddSearchWord {
	Set[] setArray = new Set[61];

    /** Initialize your data structure here. */
    public T211AddSearchWord() {
        for(int i = 0; i <= 60; i++)
            setArray[i] = new HashSet<String>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        if(len > 60)
            len = 60;
        setArray[len].add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        if(len > 60)
            len = 60;
        Set<String> set = setArray[len];
        if(!word.contains("."))
            return set.contains(word);
        for(String str:set){
            if(str.matches(word))
                return true;
        }
        return false;
    }
}
