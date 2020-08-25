
package Heap;
import java.util.PriorityQueue;

class Tuple
{	
	public Integer key;
	public String value;
	public Tuple(Integer key, String s)
	{
		this.key = key;
		this.value = s;
	}

}

class DemoHeap
{
	public static void main(String[] args)
	{
		PriorityQueue<Tuple> hp = new PriorityQueue<>((x, y)  -> x.key - y.key);
		hp.add(new Tuple(5,"five"));
		hp.add(new Tuple(3,"three"));
		hp.add(new Tuple(4,"four"));
		hp.poll();
		System.out.println(hp.peek().value);
	}
}