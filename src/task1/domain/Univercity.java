package task1.domain;

import java.util.ArrayList;
import java.util.List;

public class Univercity {
	private List<Faculty> faculties = new ArrayList<>();

	public Univercity addFaculty(Faculty faculty) {
		this.faculties.add(faculty);
		return this;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}
}
