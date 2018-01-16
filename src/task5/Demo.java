package task5;

public class Demo {
	public static void main(String[] args) {
		Chess chess = new Chess()
			.setSource("A6")
			.setDestination("c7");

		System.out.println(String.format("move from %s to %s is %s", chess.getSource(), chess.getDestination(),
			chess.test() ? "possible" : "impossible"));
	}
}
