package task1.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	private String name;
	private List<Subject> subjects;
	private List<Student> students;
	private double minGrade;

	public Faculty(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public Faculty addSubject(Subject subject) {
		subjects.add(subject);
		return this;
	}

	public Faculty addStudent(Student student) {
		students.add(student);
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

	public List<Student> getStudents() {
		return students;
	}

	public double getMinGrade() {
		return minGrade;
	}
}
