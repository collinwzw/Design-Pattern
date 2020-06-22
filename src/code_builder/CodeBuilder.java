package code_builder;
import java.util.ArrayList;
import java.util.Collections;

class CodeUnit{
	public String name,type;
	private final int indentSize = 2;
	private final String newLine = System.lineSeparator();
	public ArrayList<CodeUnit> elements = new ArrayList<CodeUnit>();

	public CodeUnit() {

	}
	public CodeUnit(String name, String type) {
		this.name=name;
		this.type=type;
	}
  private String toStringImpl(int indent)
  {
    StringBuilder sb = new StringBuilder();
    String i = String.join("", Collections.nCopies(indent * indentSize, " "));
    sb.append(String.format("%spublic %s %s %s%s{%s", i, type, name, newLine,i,newLine));

    for (CodeUnit e : elements)
      sb.append(e.toStringImpl(indent + 1));

    sb.append(String.format("%s%s}%s",newLine,i,newLine));
    return sb.toString();
  }
  public String toString()
  {
      return this.toStringImpl(0);
  }
}
public class CodeBuilder
{
	public String classname;

	private CodeUnit root = new CodeUnit();

    public CodeBuilder(String className)
    {
    	root.name = className;
    	root.type = "class";
    }
    
    public CodeBuilder addField(String name, String type)
    {
    	CodeUnit cb = new CodeUnit(name,type);
    	root.elements.add(cb);
        return this;
    }
    
    @Override
    public String toString()
    {
        return root.toString();
    }
}

class Demo{
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
}

