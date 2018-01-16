package task2;

import java.util.Scanner;

public class Task2 {
	private static int maxCount = 10;
	private static int minNum = 1;
	private static int maxNum = 100;

	public static void main(String[] args) {
		int num = (int)(Math.random()*(maxNum - minNum) + minNum);
		System.out.println("Number already generated. Guess it");
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do {
			System.out.print(String.format("Please enter number (you have %d attempts remained): ", maxCount - i));
			int test = sc.nextInt();
			if (test > num) {
				System.out.println(test + " is bigger then Number.");
			} else if (test < num) {
				System.out.println(test + " is less then Number.");
			} else {
				System.out.println("You're right!");
				return;
			}
			i++;
		} while (i < maxCount);
		System.out.println("You reached max attempts :(");
	}
}
