/* Tarea, Análisis de algorítmos: Vargas Aldaco Alejandro */

public class Main {

	public static void main(String[] args) {
		int k = 21;
		int t = 2;
		int i = 1;
		int r = k;
		while(k != 1) {
			if(k % t == 0) {
				k = k / t;
				if (i != 1) System.out.print("*");
				System.out.print(t);
				i++;
			} else {
				t = t * t > k ? k : t + 1;
			}
		}
		System.out.print(" = " + r);
	}

}
