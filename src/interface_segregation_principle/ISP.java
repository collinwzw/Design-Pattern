package interface_segregation_principle;

class Document{
	private String content;
	public Document(String s) {
		this.content = s;
	}
	public String GetContent() {
		return this.content;
	}
}

interface Machine{
	void print(Document d);
	void fax(Document d);
	void scan(Document d);
}

class MultiFunctionPrinter implements Machine{
	@Override
	public void print(Document d) {
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

class OldFasionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// old fasion printer does not know how to fax. and we can't modify original interface.
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

interface Printer{
	void print(Document d);
}

interface Scanner{
	void scan(Document d);
}

interface Faxer{
	void fax(Document d);
}

//YAGNI = you ain't going to need it

class JustAPrinter implements Printer{

	@Override
	  public void print(Document d) {
		System.out.println("printing " + d.GetContent());	  
	  }
}

class JustAScanner implements Scanner{

	@Override
	  public void scan(Document d) {
		  System.out.println("Scanning " + d.GetContent());
	  }
}

class JustAFaxer implements Faxer{

	@Override
	  public void fax(Document d) {
		  System.out.println("Faxing " + d.GetContent());
	  }
}

class Photocopier implements Printer, Scanner{

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

//make interface extends multiple interfaces
interface MultiFunctionDevice extends Printer, Scanner, Faxer{
	
}

class MultiFunctionMachine implements MultiFunctionDevice{


	// decorator design pattern
	private Printer printer;
	private Faxer faxer;
	private Scanner scanner;
	
	public MultiFunctionMachine(Printer printer, Faxer faxer, Scanner scanner) {
		this.printer = printer;
		this.faxer = faxer;
		this.scanner = scanner;
	}
	
	
	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		printer.print(d);
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		scanner.scan(d);
	}

	@Override
	public void fax(Document d) {
		this.faxer.fax(d);
		
	}
	
}

class ISPDemo
{



  public static void main(String[] args) {
	  Document d = new Document("Hello");
	  
	  MultiFunctionMachine mfm = new MultiFunctionMachine(new JustAPrinter(),new JustAFaxer(),new JustAScanner());
	  mfm.print(d);
  }
}