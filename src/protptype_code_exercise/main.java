package protptype_code_exercise;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

class Point implements Serializable
{
  public int x, y;
  
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public String toString() {
	  return "(" + x + " , " + y + " )"; 
  }
}

class Line
{
  public Point start, end;
  
  public Line(Point start, Point end)
  {
    this.start = start;
    this.end = end;
  }

  public Line deepCopy()
  {
	  // method 1: copy constructor
	  // method 2: copy through serialization
    // todo
	  Point Point_start = SerializationUtils.roundtrip(this.start);
	  Point Point_end = SerializationUtils.roundtrip(this.end);
	  return new Line(Point_start, Point_end);
  }
  @Override
  public String toString() {
	  return "start point ='" + start + "\' and end point = '" + end + "\'.";
  }
}

class Demo{
	public static void main(String[] args) {
		Line line = new Line(new Point(0,0), new Point(1,1));
		Line line2 = line.deepCopy();
		line2.end.x = 2;
		System.out.println(line);
		System.out.println(line2);
	}
}