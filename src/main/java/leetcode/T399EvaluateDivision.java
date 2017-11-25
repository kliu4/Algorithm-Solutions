package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T399EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] result = new double[queries.length];
		if (queries.length == 0)
			return result;

		Map<String, Integer> map = new HashMap<>();

		int id = 0;

		for (int i = 0; i < equations.length; i++) {
			for (int j = 0; j < 2; j++) {
				String term = equations[i][j];
				if (!map.containsKey(term)) {
					map.put(term, id);
					id++;
				}
			}
		}

		double[][] matrix = new double[id][id];

		for (int i = 0; i < equations.length; i++)
			matrix[i][i] = 1;

		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			int indexA = map.get(equation[0]);
			int indexB = map.get(equation[1]);
			matrix[indexA][indexB] = values[i];
			matrix[indexB][indexA] = 1.0 / values[i];
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != 0)
					continue;
				for (int k = 0; k < matrix.length; k++) {
					if (matrix[i][k] == 0 || matrix[k][j] == 0)
						continue;
					matrix[i][j] = matrix[i][k] * matrix[k][j];
					break;
				}
			}
		}

		for (int i = 0; i < queries.length; i++) {
			String a = queries[i][0];
			String b = queries[i][1];
			if (!map.containsKey(a) || !map.containsKey(b))
				result[i] = -1;
			else {
				int indexA = map.get(a);
				int indexB = map.get(b);
				result[i] = matrix[indexA][indexB] == 0 ? -1 : matrix[indexA][indexB];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		new T399EvaluateDivision().calcEquation(new String[][] { { "A", "B" }, { "B", "C" } },
				new double[] { 2.0, 3.0 }, new String[][] { { "A", "C" }, { "B", "C" } });

	}
}
