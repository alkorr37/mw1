package task1.demo;

import task1.domain.Faculty;
import task1.domain.Student;
import task1.domain.Subject;
import task1.domain.Univercity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	private static Univercity univercity;

	static {
		Subject english = new Subject("English");
		Subject chemistry = new Subject("Chemistry");
		Subject math = new Subject("Math");
		Subject history = new Subject("History");

		Faculty kit = new Faculty("KIT")
			.setMinGrade(4.3)
			.addSubject(math)
			.addSubject(english);

		Faculty ekonom = new Faculty("EKONOM")
			.setMinGrade(4.4)
			.addSubject(history)
			.addSubject(math);

		Faculty cf = new Faculty("CF")
			.setMinGrade(3.9)
			.addSubject(history)
			.addSubject(chemistry);

		univercity = new Univercity()
			.addFaculty(kit)
			.addFaculty(ekonom)
			.addFaculty(cf);
	}

	private static List<Student> initStudents() {
		List<Student> studentList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Please enter students name: (0 to exit): ");
			String name = scanner.next();
			if ("0".equals(name)) {
				break;
			}
			studentList.add(new Student(name));
		} while (true);
		scanner.close();
		return studentList;
	}

	private static void initFaculties(List<Student> students) {
		Scanner scanner = new Scanner(System.in);
		for (Student student: students) {
			System.out.println(String.format("Please choose %s's faculty: ", student.getName()));
			int i = 1;
			for (Faculty faculty : univercity.getFaculties()) {
				System.out.println(String.format("%d: %s", i++, faculty.getName()));
			}
			Faculty faculty = univercity.getFaculties().get(scanner.nextInt() - 1);
			student.setFaculty(faculty);
		}
		scanner.close();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to Univercity!");

		List<Student> studentList = initStudents();
		initFaculties(studentList);

		Scanner sc = new Scanner(System.in);
		System.out.println("\nStudent grades:");
		for (Student student: studentList) {
			System.out.println(student.getName());
			int i = 1;
			for (Subject subject : student.getFaculty().getSubjects()) {
				System.out.print(String.format("%d: %s. Grade: ", i++, subject.getName()));
				student.addGrade(subject, sc.nextInt());
			}
			System.out.println();
		}
		sc.close();

		for (Student student: studentList) {
			double averageGrade = 0;
			for (Integer val: student.getGrades().values()) {
				averageGrade += val;
			}
			averageGrade /= student.getGrades().size();
			if (averageGrade >= student.getFaculty().getMinGrade()) {
				student.getFaculty().addStudent(student);
			}
		}

		for (Faculty faculty: univercity.getFaculties()) {
			System.out.println(String.format("Faculty: '%s'. Students:", faculty.getName()));
			int i = 1;
			for (Student student: faculty.getStudents()) {
				System.out.println(String.format("\t%d: %s", i, student.getName()));
			}
			System.out.println();
		}
	}
}
