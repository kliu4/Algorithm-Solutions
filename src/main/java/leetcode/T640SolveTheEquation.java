package leetcode;

public class T640SolveTheEquation {
	public String solveEquation(String equation) {
		String[] parts = equation.split("=");
		int[] leftE = convert(parts[0]);
		int[] rightE = convert(parts[1]);

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
	private int[] convert(String equation) {
		int a = 0;
		int b = 0;
		String[] strs = equation.split("(?=[+-])");
		for (String str : strs) {
			if (str.equals("x") || str.equals("+x"))
				a++;
			else if (str.equals("-x"))
				a--;
			else if (str.contains("x"))
				a += Integer.parseInt(str.substring(0, str.length() - 1));
			else
				b += Integer.parseInt(str);
		}
		return new int[] { a, b };
	}
}
