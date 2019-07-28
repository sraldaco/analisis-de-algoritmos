import java.util.concurrent.ThreadLocalRandom;

/*
 * @autor alex aldaco
 */

public class Main {

	public static void main(String[] args) {
		int k = ThreadLocalRandom.current().nextInt(1, 21);
        int n = 50 * k;
        int[] array  = new int[n];
        int[] qArray = new int[n];
        int[] sArray = new int[n];
        for(int i = 0; i < n; i++) {
        	int element = ThreadLocalRandom.current().nextInt(0, 2 * n);
            array[i] = qArray[i] = sArray[i] = element;
        }
        double timeQSort = QuickSort.sort(qArray);
        double timeShSort = ShellSort.sort(sArray);
        System.out.println("\n\n\n\t|------------------------------------------|");
        System.out.format("\t|%5s |%10s |%10s |%10s |\n","#", "Original", "ShellSort", "QuickSort");
        System.out.println("\t|------------------------------------------|");
        for(int i = 0; i < n; i++) {
        	System.out.format("\t|%5d |%10d |%10d |%10d |\n",i+1, array[i], sArray[i], qArray[i]);
        	System.out.println("\t|------------------------------------------|");
        }
        System.out.format("\t|%17s |%10s |%10s |\n","Tiempo aprox:",timeShSort, timeQSort);
        System.out.println("\t|------------------------------------------|");
	}

}
