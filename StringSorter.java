import java.util.*;
import java.io.*;

class StringSorter implements Runnable {
	
	private String[] arr;
	private Thread t;
	
	public void run() {
		read();
		sort();
		write();
	}
	
	public void letsgo() {
		if (t == null) {
			t = new Thread(this, "String Sorter");
			t.start();
		}
	}
	
	public void read() {
		try {
			Scanner sc = new Scanner(new File("dictionary.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			arr = lines.toArray(new String[]{});
			sc.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void write() {
		try {
			PrintStream writer = new PrintStream(new File("output1.txt"));
			for(int i = 0; i < arr.length; i++) {
				writer.println(arr[i]);
			}
			writer.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void sort() {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (arr[j-1].compareTo(arr[j]) > 0) {
					swap(j);
				}
			}
		}
	}
	
	private void swap(int j) {
		String temp = arr[j-1];
		arr[j-1] = arr[j];
		arr[j] = temp;
	}
}