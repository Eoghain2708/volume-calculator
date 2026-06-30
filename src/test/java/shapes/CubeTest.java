package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CubeTest {
	
	double invalidEdgeLengthZero;
	double invalidEdgeLengthNegative;
	double validEdgeLength;
	Cube test;
	
	@BeforeEach
	void setUp() throws Exception {
		invalidEdgeLengthZero = 0;
		invalidEdgeLengthNegative = -1;
		validEdgeLength = 10;
		test = new Cube(validEdgeLength);
	}

	@Test
	void testCube() {
		Cube cube = new Cube(15);
		assertNotNull(cube);
		assertEquals(15, cube.getEdgeLength());
	}

	@Test
	void testRejectsNegativeEdgeLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cube(invalidEdgeLengthNegative);
		});
	}
	
	@Test
	void testRejectsZeroEdgeLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cube(invalidEdgeLengthZero);
		});
	}

	@Test
	void testCalculateVolume_OfEdgeLength_1() {
		Cube cube = new Cube(1);
		assertEquals(1, cube.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_OfEdgeLength_5() {
		Cube cube = new Cube(5);
		assertEquals(125, cube.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_ThrowsForInfinity() {
		double width = Math.cbrt(Double.MAX_VALUE);
		Cube cube = new Cube(width);
		assertThrows(ArithmeticException.class, cube::calculateVolume);
	}
}
