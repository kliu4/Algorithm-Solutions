package leetcode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class T208ImplementTrie {
	class Node {
		public char c;
		public boolean isWord;
		public Node[] nodes = new Node[26];

		public Node(char c) {
			this.c = c;
		}

		public Node() {
		}
	}

	Node root;

	/** Initialize your data structure here. */
	public T208ImplementTrie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node thisNode = root;

		for (char c : word.toCharArray()) {
			if (thisNode.nodes[c - 'a'] == null)
				thisNode.nodes[c - 'a'] = new Node(c);
			thisNode = thisNode.nodes[c - 'a'];
		}

		thisNode.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node node = find(word);
		return node != null && node.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node node = find(prefix);
		return node != null;
	}

	public Node find(String prefix) {
		Node thisNode = root;

		for (char c : prefix.toCharArray()) {
			if (thisNode.nodes[c - 'a'] == null)
				return null;
			thisNode = thisNode.nodes[c - 'a'];
		}

		return thisNode;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 100000000; i++)
			list.add(1);

		long time1 = System.currentTimeMillis();
		int sum = 0;
		for (int i : list)
			sum += i;
		long time2 = System.currentTimeMillis();
		list.stream().reduce(0, Integer::sum);
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
}
