package task5;

public class Chess {
	private String source;
	private String destination;

	public String getSource() {
		return source;
	}

	public Chess setSource(String source) {
		this.source = source.toUpperCase();
		return this;
	}

	public String getDestination() {
		return destination;
	}

	public Chess setDestination(String destination) {
		this.destination = destination.toUpperCase();
		return this;
	}

	public boolean test() {
		int srcX = source.charAt(0);
		int srcY = source.charAt(1);

		int dstX = destination.charAt(0);
		int dstY = destination.charAt(1);

		if (Math.abs(dstX - srcX) == 1 && Math.abs(dstY - srcY) == 2) {
			return true;
		} else {
			return Math.abs(dstX - srcX) == 2 && Math.abs(dstY - srcY) == 1;
		}
	}
}
