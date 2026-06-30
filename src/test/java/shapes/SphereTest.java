package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SphereTest {
	
	
	double invalidRadiusNegative;
	double invalidRadiusZero;
	double validRadius;
	double radiusWillExceedInfinity;
	
	Sphere test;

	@BeforeEach
	void setUp() throws Exception {
		invalidRadiusNegative = -1;
		invalidRadiusZero = 0;
		radiusWillExceedInfinity = 5.643803094e102;
		validRadius = 3;
		test = Sphere.ofRadius(validRadius);
	}

	@Test
	void testOfRadiusHappy() {
		Sphere sph = Sphere.ofRadius(10);
		assertNotNull(sph);
		assertEquals(10, sph.getRadius());
	}
	
	@Test
	void rejectsNegativeRadius() {
		assertThrows(IllegalArgumentException.class, () -> {
			Sphere.ofRadius(invalidRadiusNegative);
		});
	}
	
	@Test
	void rejectsZeroRadius() {
		assertThrows(IllegalArgumentException.class, () -> {
			Sphere.ofRadius(invalidRadiusZero);
		});
	}
	@Test
	void testCalculateVolume_RadiusOf_1() {
		Sphere sph = Sphere.ofRadius(1);
		assertEquals(4.1887902047863905, sph.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_RadiusOf_5() {
		Sphere sph = Sphere.ofRadius(5);
		assertEquals(523.5987755982989, sph.calculateVolume(), 1e-10);
	}
	
	@Test
	void testCalculateVolume_ThrowsForInfinity() {
		Sphere sph = Sphere.ofRadius(radiusWillExceedInfinity);
		assertThrows(ArithmeticException.class, sph::calculateVolume);
	}

}
