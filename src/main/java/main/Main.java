package main;


import java.util.List;


import shapes.Cube;
import shapes.RegularTetrahedron;
import shapes.Sphere;

public class Main {

	public static void main(String[] args) {
		List<Sphere> spheres = List.of(Sphere.ofRadius(1), Sphere.ofRadius(5));
		List<Cube> cubes = List.of(new Cube(1), new Cube(5));
		List<RegularTetrahedron> regTetras = List.of(new RegularTetrahedron(1), new RegularTetrahedron(5));
		
		System.out.println("Spheres:");
		for (var sph : spheres) {
			System.out.printf("Radius: %.2f - Volume %.2f %n", sph.getRadius(), sph.calculateVolume());
		}
		
		System.out.println("");
		System.out.println("Cubes:");
		for (var cube : cubes) {
			System.out.printf("Edge length: %.2f - Volume %.2f %n", cube.getEdgeLength(), cube.calculateVolume());
		}
		
		System.out.println("");
		System.out.println("Regular Tetrahedrons:");
		for (var rt : regTetras) {
			System.out.printf("Edge length: %.2f - Volume %.2f %n", rt.getEdgeLength(), rt.calculateVolume());
		}
	}

}
