package Factory_Method;

class Point{
	private double x,y;
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public static class Factory{
		public static Point NewCatesianPoint(double x, double y) {
			return new Point(x,y);
		}
		
		public static Point NewPolarPoint(double radius, double theta) {
			return new Point(radius * Math.cos(theta), radius * Math.sin(theta));
		}
			
	}
	
    @Override
	public String toString() {
		return String.format("The point is located at x:%s and y:%s.", this.x, this.y);
	}
}

class Demo{
	public static void main(String[] args) {
		Point p = Point.Factory.NewPolarPoint(2, 3);
		System.out.println(p);
	}
}