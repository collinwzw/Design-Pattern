package single_responsibility_principle;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;

public class Journal {
	private final List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addentries(String text) {
		entries.add("" + (++count) + ":" + text);
	}
	public void removeEntry(int index) {
		entries.remove(index);
	}
	@Override
	public String toString() {
		return String.join(System.lineSeparator(),entries);
	}
	
	public void save(String filename) throws FileNotFoundException {		//should seperate to Persistance class
		try (PrintStream out = new PrintStream(filename)){
			out.println(toString());
		}
	}
	public void load(String Filename) {
		
	};
	public void load(URL url) {
		
	};
}

class Persistance {
	public void savetoFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
		if (overwrite || new File(filename).exists()) {
			try (PrintStream out = new PrintStream(filename)){
				out.println(journal.toString());
			}
		}
	}
	/*
	public Journal load(String Filename) {
		 
	};
	public Journal load(URL url) {
		
	};
	*/
}

class Demo{
	public static void main(String[] args) throws Exception {
		Journal j = new Journal();
		j.addentries("Today is Saturday");
		j.addentries("tomorrow is Sunday");
		System.out.println(j);
		
		Persistance p = new Persistance();
		String filename = "c:\\Users\\ASUS\\eclipse-workspace\\Design_Pattern\\output.txt";
		p.savetoFile(j, filename, true);
		Runtime.getRuntime().exec("notepad.exe " + filename);
	}
}
