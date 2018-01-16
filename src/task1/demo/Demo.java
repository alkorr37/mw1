package task1.demo;

import task1.domain.Faculty;
import task1.domain.Student;
import task1.domain.Subject;
import task1.domain.Univercity;

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

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to Univercity!");
		System.out.print("Please enter your name: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Student student = new Student(name);

		System.out.println(String.format("%s, please choose your faculty: ", name));
		int i = 1;
		for (Faculty faculty : univercity.getFaculties()) {
			System.out.println(String.format("%d: %s", i++, faculty.getName()));
		}
		Faculty faculty = univercity.getFaculties().get(scanner.nextInt() - 1);
		System.out.println(String.format("You chose %s faculty, good luck:)", faculty.getName()));

		System.out.println("Your subjects to pass:");
		i = 1;
		for (Subject subject : faculty.getSubjects()) {
			System.out.println(String.format("%d: %s", i++, subject.getName()));
		}

		System.out.println("Teacher is testing you.. ");
		Thread.sleep(2000);

		double averageGrade = 0;
		for (Subject subject : faculty.getSubjects()) {
			int grade = (int) (Math.random() * 4 + 2);
			averageGrade += grade;
			student.addGrade(subject, grade);
			System.out.println(String.format("%s: %d", subject.getName(), grade));
		}

		averageGrade /= faculty.getSubjects().size();
		System.out.println(String.format("Your average grade: %.1f", averageGrade));
		System.out.println(averageGrade >= faculty.getMinGrade() ?
			"Congrats! You successfully entered the univercity" :
			"Sorry, good luck next year");
	}
}
