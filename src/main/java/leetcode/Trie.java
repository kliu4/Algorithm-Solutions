package leetcode;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	char c;
	Map<Character, TrieNode> children = new HashMap<>();
	boolean hasWord;
	public TrieNode() {
		
	}
	public TrieNode(char c) {
		this.c = c;
	}
}
public class Trie {
	TrieNode root = new TrieNode();
	
	public void addWord(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			TrieNode newNode = cur.children.getOrDefault(c, new TrieNode(c));
			cur.children.put(c, newNode);
			cur = newNode;
		}
		cur.hasWord = true;
	}
	
	public TrieNode find(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				return null;
			} 
			cur = cur.children.get(c);
		}
		return cur;
	}
}
