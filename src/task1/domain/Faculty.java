package task1.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	private String name;
	private List<Subject> subjects;
	private double minGrade;

	public Faculty(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
	}

	public Faculty addSubject(Subject subject) {
		subjects.add(subject);
		return this;
	}

	public Faculty setMinGrade(Double grade) {
		this.minGrade = grade;
		return this;
	}

	public String getName() {
		return name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public double getMinGrade() {
		return minGrade;
	}
}
