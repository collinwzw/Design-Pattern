package Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject
{
	protected String name = "Group";
	
	public String getName()
	{
		
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
		
	}
	
	public GraphicObject()
	{
		
	}
	
	public String color;
	public List<GraphicObject> children = new ArrayList<>();
	
	private void print(StringBuilder stringBuilder,  int depth)
	  {
	    stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
	      .append(depth > 0 ? " " : "")
	      .append((color == null || color.isEmpty()) ? "" : color + " ")
	      .append(getName())
	      .append(System.lineSeparator());
	    for (GraphicObject child : children)
	      child.print(stringBuilder,  depth+1);
	  }

	  @Override
	  public String toString()
	  {
	    StringBuilder sb = new StringBuilder();
	    print(sb, 0);
	    return sb.toString();
	  }

}

class Circle extends GraphicObject
{
	public Circle(String color)
	{
		name = "Circle";
		this.color = color;
		
	}
}
class Square extends GraphicObject
{
	public Square(String color)
	{
		name = "Square";
		this.color = color;
		
	}
}


class DemoGS
{
	public static void main(String[] args)
	{
		GraphicObject drawing = new GraphicObject();
		drawing.setName("My Drawing");
		drawing.children.add(new Circle("red"));
		drawing.children.add(new Square("yellow"));

		GraphicObject group = new GraphicObject();
		group.setName("My Drawing1");
		group.children.add(new Circle("blue"));
		group.children.add(new Square("blue"));
		drawing.children.add(group);
		
		System.out.println(drawing);
		
	}
}