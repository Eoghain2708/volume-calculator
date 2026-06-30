package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegularTetrahedronTest {
	
	double invalidEdgeLengthZero;
	double invalidEdgeLengthNegative;
	double validEdgeLength;
	RegularTetrahedron test;

	@BeforeEach
	void setUp() throws Exception {
		invalidEdgeLengthZero = 0;
		invalidEdgeLengthNegative = -1;
		validEdgeLength = 10;
		test = new RegularTetrahedron(validEdgeLength);
	}

	@Test
	void testRegularTetrahedron() {
		var tetra = new RegularTetrahedron(5);
		assertNotNull(tetra);
		assertEquals(5, tetra.getEdgeLength());
	}

	@Test
	void testRejectsNegativeEdgeLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RegularTetrahedron(invalidEdgeLengthNegative);
		});
	}
	
	@Test
	void testRejectsZeroEdgeLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RegularTetrahedron(invalidEdgeLengthZero);
		});
	}

	@Test
	void testCalculateVolume_OfEdge_1() {
		var tetra = new RegularTetrahedron(1);
		assertEquals(0.1178511301977579, tetra.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_OfEdge_5() {
		var tetra = new RegularTetrahedron(5);
		assertEquals(14.731391274719739, tetra.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_ThrowsForInfinity() {
		double edgeLength = Math.sqrt(Double.MAX_VALUE);
		var tetra = new RegularTetrahedron(edgeLength);
		assertThrows(ArithmeticException.class, tetra::calculateVolume);
	}

}
