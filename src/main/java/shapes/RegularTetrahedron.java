package shapes;

public final class RegularTetrahedron implements Calculable {
	
	private final double edgeLength;
	
	public RegularTetrahedron(double edgeLength) {
		validateEdgeLength(edgeLength);
		this.edgeLength = edgeLength;
	}
	
	public double getEdgeLength() {
		return edgeLength;
	}
	
	@Override
	public double calculateVolume() {
		double volume = (Math.pow(edgeLength, 3)) / (6 * Math.sqrt(2));
		if (Double.isInfinite(volume)) {
			throw new ArithmeticException("Volume has exceeded representation limits");
		}
		return volume;
	}
	
	private static void validateEdgeLength(double length) {
		if (!(length > 0)) {
			throw new IllegalArgumentException("Edge length must be more than 0");
		}
	}
	
}
