package shapes;

public final class Cube implements Calculable {
	private final double edgeLength;
	
	public Cube(double edgeLength) {
		validateEdgeLength(edgeLength);
		this.edgeLength = edgeLength;
	}
	
	public double getEdgeLength() {
		return edgeLength;
	}
	
	@Override
	public double calculateVolume() {
		double volume = Math.pow(edgeLength, 3);
		if (Double.isInfinite(volume)) {
			throw new ArithmeticException("Volume has exceeded representational limits");
		}
		return volume;
	}
	
	private static void validateEdgeLength(double edgeLength) {
		if (!(edgeLength > 0)) {
			throw new IllegalArgumentException("Edge length must be more than 0");
		}
	}

	
}
