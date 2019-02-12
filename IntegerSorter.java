import java.util.*;
import java.io.*;

class IntegerSorter implements Runnable {
	
	private int[] iarr = new int[100000];
	private Thread t;
	
	public void run() {
		generate();
		sort();
		write();
	}
	
	public void letsgo() {
		if (t == null) {
			t = new Thread(this, "Integer Sorter");
			t.start();
		}
	}
	
	public void generate() {
		for (int i = 0; i < 100000; i++) {
			iarr[i] = (int)(Math.random() * 100000);
		}
	}
	
	public void write() {
		try {
			PrintStream writer = new PrintStream(new File("output2.txt"));
			for(int i = 0; i < iarr.length; i++) {
				writer.println(iarr[i]);
			}
			writer.close();
			/*FileOutputStream file = new FileOutputStream("output2.txt");
			for (int i = 0; i < iarr.length; i++)
				file.write(iarr[i]);
			file.close();*/
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void sort() {
		int n = iarr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (iarr[j-1] > iarr[j]) {
					swap(j);
				}
			}
		}
	}
	
	private void swap(int j) {
		int temp = iarr[j-1];
		iarr[j-1] = iarr[j];
		iarr[j] = temp;
	}
}