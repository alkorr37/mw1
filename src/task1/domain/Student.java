package task1.domain;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
	private Map<Subject, Integer> grades;
	private Faculty faculty;

	public Student(String name) {
		super(name);
		this.grades = new HashMap<>();
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void addGrade(Subject subject, Integer grade) {
		grades.put(subject, grade);
	}

	public Map<Subject, Integer> getGrades() {
		return grades;
	}
}
