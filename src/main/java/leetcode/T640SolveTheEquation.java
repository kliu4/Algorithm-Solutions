package leetcode;

public class T640SolveTheEquation {
	public String solveEquation(String equation) {
		String[] parts = equation.split("=");
		String left = parts[0];
		String right = parts[1];
		int[] leftE = convert(left);
		int[] rightE = convert(right);

		// change to ax = b
		int a = leftE[0] - rightE[0];
		int b = rightE[1] - leftE[1];

		if (a == 0 && b == 0)
			return "Infinite solutions";
		else if (a == 0)
			return "No solution";
		else
			return "x=" + (b / a);
	}

	// convert to ax+b
	private int[] convert(String str) {
		int prev = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i <= str.length(); i++) {
			if (i == str.length() || str.charAt(i) == '+' || str.charAt(i) == '-') {
				String single = str.substring(prev, i);
				if (single.equals("x") || single.equals("+x")) {
					a++;
					prev = i;
					continue;
				} else if (single.equals("-x")) {
					a--;
					prev = i;
					continue;
				}
				if (single.equals(""))
					continue;
				if (single.contains("x"))
					a += Integer.parseInt(single.substring(0, single.length() - 1));
				else
					b += Integer.parseInt(single);
				prev = i;
			}
		}
		return new int[] { a, b };
	}
}
