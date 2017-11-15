package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Employee;

public class T690EmployeeImportance {
	Map<Integer, Employee> map = new HashMap<>();

	public int getImportance(List<Employee> employees, int id) {
		for (Employee e : employees) {
			map.put(e.id, e);
		}

		return getImportance(id);
	}

	private int getImportance(int id) {
		if (!map.containsKey(id))
			return 0;
		Employee e = map.get(id);
		int importance = e.importance;
		for (int i : e.subordinates)
			importance += getImportance(i);
		return importance;
	}
}
