package task1.domain;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
	private Map<Subject, Integer> grades;

	public Student(String name) {
		super(name);
		this.grades = new HashMap<>();
	}

	public void addGrade(Subject subject, Integer grade) {
		grades.put(subject, grade);
	}
}
