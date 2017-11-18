package leetcode;

import java.util.TreeMap;

public class T726NumberOfAtoms {
	public String countOfAtoms(String formula) {
		TreeMap<String, Integer> map = countOfAtoms(formula, 1);
		String s = "";
		for (String atom : map.keySet())
			s += (map.get(atom) == 1 ? atom : atom + map.get(atom));
		return s;
	}

	private int[] getCount(String formula, int i) {
		String s = "";
		while (i < formula.length() && formula.charAt(i) <= '9' && formula.charAt(i) >= '0') {
			s += formula.charAt(i);
			i++;
		}
		return new int[] { s.equals("") ? 1 : Integer.parseInt(s), i };
	}

	private String getAtom(String formula, int i) {
		String s = "" + formula.charAt(i++);
		while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
			s += formula.charAt(i);
			i++;
		}
		return s;
	}

	private void addMap(TreeMap<String, Integer> map1, TreeMap<String, Integer> map2) {
		for (String atom : map2.keySet())
			map1.put(atom, map1.getOrDefault(atom, 0) + map2.get(atom));
	}

	public TreeMap countOfAtoms(String formula, int count) {
		TreeMap<String, Integer> map = new TreeMap<>();

		for (int i = 0; i < formula.length();) {
			if (formula.charAt(i) == '(') {
				int leftB = 1;
				int j = i + 1;
				for (; j < formula.length() && leftB != 0; j++) {
					if (formula.charAt(j) == '(')
						leftB++;
					if (formula.charAt(j) == ')')
						leftB--;
				}

				String subFormula = formula.substring(i + 1, j - 1);
				int[] subCount = getCount(formula, j);
				addMap(map, countOfAtoms(subFormula, subCount[0]));
				i = subCount[1];
			}
			if (i < formula.length() && formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z') {
				String atom = getAtom(formula, i);
				i = i + atom.length();
				int[] subCount = getCount(formula, i);
				map.put(atom, map.getOrDefault(atom, 0) + subCount[0]);
				i = subCount[1];
			}
		}

		if (count != 1) {
			for (String atom : map.keySet())
				map.put(atom, map.get(atom) * count);
		}

		return map;
	}
}
