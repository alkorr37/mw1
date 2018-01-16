package task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Task4 {
	public static void main(String[] args) {
		PasswordChooser pwd = new PasswordChooser();
		try {
			FileReader fileReader = new FileReader("/Users/alkor/work/alevel/mw1/src/task4/logins.txt");
			Scanner scanner = new Scanner(fileReader);
			String pattern = "\\s+";
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] passwordArr = line.split(pattern);
				if (passwordArr.length > 1) {
					pwd.addPassword(passwordArr[1]);
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pwd.getTop10Pwd());
	}
}
